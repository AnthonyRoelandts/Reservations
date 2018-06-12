package com.icc.reservations.utils;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Source : https://gist.github.com/swhp/7e58e42dfc79f0645f7f145c4a361672
 *
 * @author antho
 */
public class EncryptionUtils {

    private static final String TOKEN = "passwd";
    private static final String SALT = getSalt();
    private static final int PWD_ITERATIONS = 65536;
    private static final int KEY_SIZE = 256;
    private static byte[] IV_BYTES;
    private static final String KEY_ALGORITHM = "AES";
    private static final String ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA1";

    private static String getSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String text = new String(bytes);
        return text;
    }

    /**
     *
     * @param plainText
     * @return encrypted text
     * @throws Exception
     */
    public static String encrypt(String plainText) throws Exception {
        //generate key
        byte[] saltBytes = SALT.getBytes("UTF-8");

        SecretKeyFactory skf = SecretKeyFactory.getInstance(EncryptionUtils.SECRET_KEY_FACTORY_ALGORITHM);
        PBEKeySpec spec = new PBEKeySpec(TOKEN.toCharArray(), saltBytes, EncryptionUtils.PWD_ITERATIONS, EncryptionUtils.KEY_SIZE);
        SecretKey secretKey = skf.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);

        //AES initialization
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        //generate IV
        EncryptionUtils.IV_BYTES = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        byte[] encryptedText = cipher.doFinal(plainText.getBytes("UTF-8"));
        return new Base64().encodeAsString(encryptedText);
    }

    /**
     *
     * @param encryptText
     * @return decrypted text
     * @throws Exception
     */
    public static String decrypt(String encryptText) throws Exception {
        byte[] saltBytes = SALT.getBytes("UTF-8");
        byte[] encryptTextBytes = new Base64().decode(encryptText);

        SecretKeyFactory skf = SecretKeyFactory.getInstance(EncryptionUtils.SECRET_KEY_FACTORY_ALGORITHM);
        PBEKeySpec spec = new PBEKeySpec(TOKEN.toCharArray(), saltBytes, EncryptionUtils.PWD_ITERATIONS, EncryptionUtils.KEY_SIZE);
        SecretKey secretKey = skf.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);

        //decrypt the message
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV_BYTES));

        byte[] decyrptTextBytes = null;
        try {
            decyrptTextBytes = cipher.doFinal(encryptTextBytes);
        } catch (IllegalBlockSizeException e) {
            Logger.getLogger(EncryptionUtils.class.getName()).log(Level.SEVERE, null, e);
        } catch (BadPaddingException e) {
            Logger.getLogger(EncryptionUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        String text = new String(decyrptTextBytes);
        return text;
    }

}

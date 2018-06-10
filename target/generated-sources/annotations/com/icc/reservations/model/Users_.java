package com.icc.reservations.model;

import com.icc.reservations.model.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-10T15:53:40")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, Roles> roleId;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> langue;
    public static volatile SingularAttribute<Users, String> login;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> lastname;

}
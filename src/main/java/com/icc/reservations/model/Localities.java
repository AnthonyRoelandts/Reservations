package com.icc.reservations.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author antho
 */
@Entity
@Table(name = "localities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localities.findAll", query = "SELECT l FROM Localities l")
    , @NamedQuery(name = "Localities.findById", query = "SELECT l FROM Localities l WHERE l.id = :id")
    , @NamedQuery(name = "Localities.findByPostalCode", query = "SELECT l FROM Localities l WHERE l.postalCode = :postalCode")
    , @NamedQuery(name = "Localities.findByLocality", query = "SELECT l FROM Localities l WHERE l.locality = :locality")})
public class Localities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "locality")
    private String locality;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityId")
    private Collection<Locations> locationsCollection;

    public Localities() {
    }

    public Localities(Integer id) {
        this.id = id;
    }

    public Localities(Integer id, String postalCode, String locality) {
        this.id = id;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @XmlTransient
    public Collection<Locations> getLocationsCollection() {
        return locationsCollection;
    }

    public void setLocationsCollection(Collection<Locations> locationsCollection) {
        this.locationsCollection = locationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localities)) {
            return false;
        }
        Localities other = (Localities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Localities[ id=" + id + " ]";
    }

}

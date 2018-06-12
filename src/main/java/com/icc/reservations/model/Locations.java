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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id")
    , @NamedQuery(name = "Locations.findBySlug", query = "SELECT l FROM Locations l WHERE l.slug = :slug")
    , @NamedQuery(name = "Locations.findByDesignation", query = "SELECT l FROM Locations l WHERE l.designation = :designation")
    , @NamedQuery(name = "Locations.findByAddress", query = "SELECT l FROM Locations l WHERE l.address = :address")
    , @NamedQuery(name = "Locations.findByWebsite", query = "SELECT l FROM Locations l WHERE l.website = :website")
    , @NamedQuery(name = "Locations.findByPhone", query = "SELECT l FROM Locations l WHERE l.phone = :phone")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "slug")
    private String slug;
    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<Shows> showsCollection;
    @JoinColumn(name = "locality_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Localities localityId;
    @OneToMany(mappedBy = "locationId")
    private Collection<Representations> representationsCollection;

    public Locations() {
    }

    public Locations(Integer id) {
        this.id = id;
    }

    public Locations(Integer id, String slug, String designation, String address, String website, String phone) {
        this.id = id;
        this.slug = slug;
        this.designation = designation;
        this.address = address;
        this.website = website;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Shows> getShowsCollection() {
        return showsCollection;
    }

    public void setShowsCollection(Collection<Shows> showsCollection) {
        this.showsCollection = showsCollection;
    }

    public Localities getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Localities localityId) {
        this.localityId = localityId;
    }

    @XmlTransient
    public Collection<Representations> getRepresentationsCollection() {
        return representationsCollection;
    }

    public void setRepresentationsCollection(Collection<Representations> representationsCollection) {
        this.representationsCollection = representationsCollection;
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
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locations[ id=" + id + " ]";
    }

}

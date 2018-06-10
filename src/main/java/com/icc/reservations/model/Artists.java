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
@Table(name = "artists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artists.findAll", query = "SELECT a FROM Artists a")
    , @NamedQuery(name = "Artists.findById", query = "SELECT a FROM Artists a WHERE a.id = :id")
    , @NamedQuery(name = "Artists.findByFirstname", query = "SELECT a FROM Artists a WHERE a.firstname = :firstname")
    , @NamedQuery(name = "Artists.findByLastname", query = "SELECT a FROM Artists a WHERE a.lastname = :lastname")})
public class Artists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistId")
    private Collection<ArtisteType> artisteTypeCollection;

    public Artists() {
    }

    public Artists(Integer id) {
        this.id = id;
    }

    public Artists(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<ArtisteType> getArtisteTypeCollection() {
        return artisteTypeCollection;
    }

    public void setArtisteTypeCollection(Collection<ArtisteType> artisteTypeCollection) {
        this.artisteTypeCollection = artisteTypeCollection;
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
        if (!(object instanceof Artists)) {
            return false;
        }
        Artists other = (Artists) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.spring.model.Artists[ id=" + id + " ]";
    }

}

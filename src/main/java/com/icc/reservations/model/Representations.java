package com.icc.reservations.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author antho
 */
@Entity
@Table(name = "representations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representations.findAll", query = "SELECT r FROM Representations r")
    , @NamedQuery(name = "Representations.findById", query = "SELECT r FROM Representations r WHERE r.id = :id")
    , @NamedQuery(name = "Representations.findByWhen", query = "SELECT r FROM Representations r WHERE r.when = :when")})
public class Representations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "when")
    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shows showId;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne
    private Locations locationId;

    public Representations() {
    }

    public Representations(Integer id) {
        this.id = id;
    }

    public Representations(Integer id, Date when) {
        this.id = id;
        this.when = when;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Shows getShowId() {
        return showId;
    }

    public void setShowId(Shows showId) {
        this.showId = showId;
    }

    public Locations getLocationId() {
        return locationId;
    }

    public void setLocationId(Locations locationId) {
        this.locationId = locationId;
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
        if (!(object instanceof Representations)) {
            return false;
        }
        Representations other = (Representations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.spring.model.Representations[ id=" + id + " ]";
    }

}

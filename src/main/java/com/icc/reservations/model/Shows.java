package com.icc.reservations.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "shows")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shows.findAll", query = "SELECT s FROM Shows s")
    , @NamedQuery(name = "Shows.findById", query = "SELECT s FROM Shows s WHERE s.id = :id")
    , @NamedQuery(name = "Shows.findBySlug", query = "SELECT s FROM Shows s WHERE s.slug = :slug")
    , @NamedQuery(name = "Shows.findByTitle", query = "SELECT s FROM Shows s WHERE s.title = :title")
    , @NamedQuery(name = "Shows.findByPosterUrl", query = "SELECT s FROM Shows s WHERE s.posterUrl = :posterUrl")
    , @NamedQuery(name = "Shows.findByBookable", query = "SELECT s FROM Shows s WHERE s.bookable = :bookable")
    , @NamedQuery(name = "Shows.findByPrice", query = "SELECT s FROM Shows s WHERE s.price = :price")})
public class Shows implements Serializable {

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
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "poster_url")
    private String posterUrl;
    @Basic(optional = false)
    @Column(name = "bookable")
    private boolean bookable;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Locations locationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showId")
    private Collection<Representations> representationsCollection;

    public Shows() {
    }

    public Shows(Integer id) {
        this.id = id;
    }

    public Shows(Integer id, String slug, String title, String posterUrl, boolean bookable, BigDecimal price) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.posterUrl = posterUrl;
        this.bookable = bookable;
        this.price = price;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean getBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Locations getLocationId() {
        return locationId;
    }

    public void setLocationId(Locations locationId) {
        this.locationId = locationId;
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
        if (!(object instanceof Shows)) {
            return false;
        }
        Shows other = (Shows) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shows[ id=" + id + " ]";
    }

}

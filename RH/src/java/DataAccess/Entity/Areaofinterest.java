/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "areaofinterest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areaofinterest.findAll", query = "SELECT a FROM Areaofinterest a"),
    @NamedQuery(name = "Areaofinterest.findByPkID", query = "SELECT a FROM Areaofinterest a WHERE a.pkID = :pkID"),
    @NamedQuery(name = "Areaofinterest.findByName", query = "SELECT a FROM Areaofinterest a WHERE a.name = :name")})
public class Areaofinterest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkID")
    private Integer pkID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "userareaofinterest", joinColumns = {
        @JoinColumn(name = "fkareaofinterestID", referencedColumnName = "pkID")}, inverseJoinColumns = {
        @JoinColumn(name = "fkuserID", referencedColumnName = "pkID")})
    @ManyToMany
    private Collection<User> userCollection;
    @JoinTable(name = "certificationsareaofinterest", joinColumns = {
        @JoinColumn(name = "fkareaofinterestID", referencedColumnName = "pkID")}, inverseJoinColumns = {
        @JoinColumn(name = "fkcertificationsID", referencedColumnName = "pkID")})
    @ManyToMany
    private Collection<Certifications> certificationsCollection;

    public Areaofinterest() {
    }

    public Areaofinterest(Integer pkID) {
        this.pkID = pkID;
    }

    public Areaofinterest(Integer pkID, String name) {
        this.pkID = pkID;
        this.name = name;
    }

    public Integer getPkID() {
        return pkID;
    }

    public void setPkID(Integer pkID) {
        this.pkID = pkID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Certifications> getCertificationsCollection() {
        return certificationsCollection;
    }

    public void setCertificationsCollection(Collection<Certifications> certificationsCollection) {
        this.certificationsCollection = certificationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkID != null ? pkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areaofinterest)) {
            return false;
        }
        Areaofinterest other = (Areaofinterest) object;
        if ((this.pkID == null && other.pkID != null) || (this.pkID != null && !this.pkID.equals(other.pkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Areaofinterest[ pkID=" + pkID + " ]";
    }
    
}

package entity;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    //@NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.infoentity.phoneCollection.phonenum = :phonenum"),
    //@NamedQuery(name = "Person.findByHobby", query = "SELECT p FROM Person p WHERE p.hobbyCollection.hobbyname = :hobbyname"),
    //@NamedQuery(name = "Person.findByHobbyCount", query = "SELECT COUNT(p) FROM Person p WHERE p.hobbyCollection.hobbyname = :hobbyname"),
    //@NamedQuery(name = "Person.findByCity", query = "SELECT p FROM Person p WHERE p.infoentity.addressCollection.cityinfo.zipcode = :zip"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @JoinColumn(name = "ID_P", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Infoentity infoentity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Hobby> hobbyCollection = new ArrayList();

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
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

    public Infoentity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(Infoentity infoentity) {
        this.infoentity = infoentity;
    }

    public Collection<Hobby> getHobbyCollection() {
        return hobbyCollection;
    }

    public void setHobbyCollection(Collection<Hobby> hobbyCollection) {
        this.hobbyCollection = hobbyCollection;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ id=" + id + " ]";
    }

}

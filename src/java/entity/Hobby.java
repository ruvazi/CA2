package entity;

import java.io.Serializable;
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

@Entity
@Table(name = "hobby")
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h"),
    @NamedQuery(name = "Hobby.findById", query = "SELECT h FROM Hobby h WHERE h.id = :id"),
    @NamedQuery(name = "Hobby.findByHobbyname", query = "SELECT h FROM Hobby h WHERE h.hobbyname = :hobbyname"),
    @NamedQuery(name = "Hobby.findByDescription", query = "SELECT h FROM Hobby h WHERE h.description = :description")})
public class Hobby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "HOBBYNAME")
    private String hobbyname;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ID_H", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Person person;

    public Hobby() {
    }

    public Hobby(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHobbyname() {
        return hobbyname;
    }

    public void setHobbyname(String hobbyname) {
        this.hobbyname = hobbyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hobby[ id=" + id + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Rune
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Person.findByCity", query = "SELECT p FROM Person p, Infoentity e WHERE p.id = e.id AND e.address.cityinfo.zip = :zip")

})
    public class Person extends InfoEntity implements Serializable {
   @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Hobby> hobbyCollection = new ArrayList();

    public Person() {
    }

    public Person(String firstname, String lastname, String email, Collection<Address> addressCollection, Collection<Phone> phoneCollection) {
        super(email, addressCollection, phoneCollection);
        this.firstname = firstname;
        this.lastname = lastname;
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

    public Collection<Hobby> getHobbyCollection() {
        return hobbyCollection;
    }

    public void setHobbyCollection(Collection<Hobby> hobbyCollection) {
        this.hobbyCollection = hobbyCollection;
    }
    
}

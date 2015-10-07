/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rune
 */
@Entity
public class Company extends InfoEntity implements Serializable {
   
   
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CVR")
    private String cvr;
    
    @Column(name = "NUMEMPLOYEES")
    private int numemployees;
    
    @Column(name = "MARKETVALUE")
    private String marketvalue;

    public Company() {
    }

    public Company(String companyname, String description, String cvr, int numemployees, String marketvalue, String email, Collection<Address> addressCollection, Collection<Phone> phoneCollection) {
        super(email, addressCollection, phoneCollection);
        this.companyname = companyname;
        this.description = description;
        this.cvr = cvr;
        this.numemployees = numemployees;
        this.marketvalue = marketvalue;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public int getNumemployees() {
        return numemployees;
    }

    public void setNumemployees(int numemployees) {
        this.numemployees = numemployees;
    }

    public String getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(String marketvalue) {
        this.marketvalue = marketvalue;
    }
    
}

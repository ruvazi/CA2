/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author Rune
 */
@Entity
public class Company extends InfoEntity {
    private String name;
    private String discription;
    private String cvr;
    private String NumEmployees;
    private String marketValue;

    public Company(String name, String discription, String cvr, String NumEmployees, String marketValue) {
        this.name = name;
        this.discription = discription;
        this.cvr = cvr;
        this.NumEmployees = NumEmployees;
        this.marketValue = marketValue;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getNumEmployees() {
        return NumEmployees;
    }

    public void setNumEmployees(String NumEmployees) {
        this.NumEmployees = NumEmployees;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }
    
}

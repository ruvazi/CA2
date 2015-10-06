/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;

/**
 *
 * @author Rune
 */
@Entity
public class Phone extends InfoEntity{
    private String number;
    private String discription;

    public Phone(String number, String discription) {
        this.number = number;
        this.discription = discription;
    }

    public Phone() {
    }
    

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rune
 */
@Entity
public class Phone{
    private String number;
    private String discription;
    @Id
    private Long id;
    
    @ManyToOne
    List<InfoEntity> infoEntity = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Rune
 */
@Entity
public class Address{
    @Id
    private Long id;
    private String Address;
    private String AdditionalInfo;
    
    
    @ManyToOne
    List<CityInfo> cityInfo = new ArrayList<>();
    
    @OneToMany
    List<InfoEntity> infoEntity = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address() {
    }

    public Address(String Address, String AdditionalInfo) {
        this.Address = Address;
        this.AdditionalInfo = AdditionalInfo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public void setAdditionalInfo(String AdditionalInfo) {
        this.AdditionalInfo = AdditionalInfo;
    }
    
}

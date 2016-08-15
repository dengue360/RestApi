/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Rafael
 */
@Embeddable
public class CasePK implements Serializable{
    private Long personCod;
    private Long locationCod;
    private Long timeCod;

    public CasePK() {
    }

    public CasePK(Long personCod, Long locationCod, Long timeCod) {
        this.personCod = personCod;
        this.locationCod = locationCod;
        this.timeCod = timeCod;
    }

    public Long getPersonCod() {
        return personCod;
    }

    public void setPersonCod(Long personCod) {
        this.personCod = personCod;
    }

    public Long getLocationCod() {
        return locationCod;
    }

    public void setLocationCod(Long locationCod) {
        this.locationCod = locationCod;
    }

    public Long getTimeCod() {
        return timeCod;
    }

    public void setTimeCod(Long timeCod) {
        this.timeCod = timeCod;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
}

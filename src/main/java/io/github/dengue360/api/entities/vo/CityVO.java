/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities.vo;

/**
 *
 * @author Rafael
 */
public class CityVO {
    private String value;
    private String data;

    public CityVO(String cidade, String estado) {
        this.value = cidade + " - " + estado;
        this.data = cidade;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
}

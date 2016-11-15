/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities.vo;

import java.util.Date;
/**
 *
 * @author Rafael
 */
public class Filtro {
    private String categoria;
    private Date dtInit;
    private Date dtEnd;
    private String gravidez;
    private Integer faixaInit;
    private Integer faixaEnd;
    private String sexo;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDtInit() {
        return dtInit;
    }

    public void setDtInit(Date dtInit) {
        this.dtInit = dtInit;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getGravidez() {
        return gravidez;
    }

    public void setGravidez(String gravidez) {
        this.gravidez = gravidez;
    }

    public Integer getFaixaInit() {
        return faixaInit;
    }

    public void setFaixaInit(Integer faixaInit) {
        this.faixaInit = faixaInit;
    }

    public Integer getFaixaEnd() {
        return faixaEnd;
    }

    public void setFaixaEnd(Integer faixaEnd) {
        this.faixaEnd = faixaEnd;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rafael
 */
@Entity
public class TimeD implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia;
    private String mes;
    private String semanaEpdem;
    private Integer ano;
    @Temporal(TemporalType.DATE)
    private Date noteDate;
    @Temporal(TemporalType.DATE)
    private Date encerrDate;
    
    public TimeD() {
    }

    public TimeD(String dia, String mes, String semanaEpdem, Integer ano, Date noteDate, Date encerrDate) {
        this.dia = dia;
        this.mes = mes;
        this.semanaEpdem = semanaEpdem;
        this.ano = ano;
        this.noteDate = noteDate;
        this.encerrDate = encerrDate;
    }

    
    public Long getId() {
        return id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getSemanaEpdem() {
        return semanaEpdem;
    }

    public void setSemanaEpdem(String semanaEpdem) {
        this.semanaEpdem = semanaEpdem;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public Date getEncerrDate() {
        return encerrDate;
    }

    public void setEncerrDate(Date encerrDate) {
        this.encerrDate = encerrDate;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idade;
    private String sexo;
    private String gestante;
    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    public Person(String idade, String sexo, String gestante, Date dataNasc) {
        this.idade = idade;
        this.sexo = sexo;
        this.gestante = gestante;
        this.dataNasc = dataNasc;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
}

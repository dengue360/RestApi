/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.entities.vo;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Rafael
 */
public class InfoGraphVO {
    private List<Integer> notificados;
    private List<Integer> confirmados;
    private List<Integer> graves;
    private List<Integer> obitos;

    public InfoGraphVO() {
        this.notificados = new ArrayList();
        this.confirmados = new ArrayList();
        this.graves = new ArrayList();
        this.obitos = new ArrayList();
    }

    public void addNotificado(Integer n){
        notificados.add(n);
    }
    
    public void addConfirmado(Integer n){
        confirmados.add(n);
    }
    
    public void addObito(Integer n){
        obitos.add(n);
    }
    public void addGrave(Integer n){
        graves.add(n);
    }

    public List<Integer> getNotificados() {
        return notificados;
    }

    public void setNotificados(List<Integer> notificados) {
        this.notificados = notificados;
    }

    public List<Integer> getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(List<Integer> confirmados) {
        this.confirmados = confirmados;
    }

    public List<Integer> getGraves() {
        return graves;
    }

    public void setGraves(List<Integer> graves) {
        this.graves = graves;
    }

    public List<Integer> getObitos() {
        return obitos;
    }

    public void setObitos(List<Integer> obitos) {
        this.obitos = obitos;
    }
    
    
}

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
public class InfoVO{
    
    private Integer notificados;
    private Integer confirmados;
    private Integer graves;
    private Integer obitos;

    public Integer getNotificados() {
        return notificados;
    }

    public void setNotificados(Integer notificados) {
        this.notificados = notificados;
    }

    public Integer getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(Integer confirmados) {
        this.confirmados = confirmados;
    }

    public Integer getGraves() {
        return graves;
    }

    public void setGraves(Integer graves) {
        this.graves = graves;
    }

    public Integer getObitos() {
        return obitos;
    }

    public void setObitos(Integer obitos) {
        this.obitos = obitos;
    }
    
    
    
}

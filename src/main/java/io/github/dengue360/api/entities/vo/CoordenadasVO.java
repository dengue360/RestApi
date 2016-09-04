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
public class CoordenadasVO {
    private List pos;

    public CoordenadasVO(String lat, String lng) {
        this.pos = new ArrayList();
        pos.add(lat);
        pos.add(lng);
    }

    public List getPos() {
        return pos;
    }

    public void setPos(List pos) {
        this.pos = pos;
    }  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.controllers;

import io.github.dengue360.api.entities.Location;
import io.github.dengue360.api.entities.vo.CityVO;
import io.github.dengue360.api.services.LocationService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael
 */
@RestController
@RequestMapping(value = "/l")
public class LocationController {
    @Inject
    private LocationService lService;
    
    @RequestMapping(method = RequestMethod.GET, value="/{cidade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> list(@PathVariable String cidade){
        return lService.findbyCity(cidade);
    }
    @RequestMapping(method = RequestMethod.GET, value="/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityVO> listCities(){
        return lService.listCidades();
    }
}

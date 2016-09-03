/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import io.github.dengue360.api.entities.Location;
import io.github.dengue360.api.entities.vo.CityVO;
import io.github.dengue360.api.repositories.LocationRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Rafael
 */
@Named
public class LocationServiceImpl implements LocationService{
    private LocationRepository repo;
    
    @Inject
    public void setDao(LocationRepository repo) {
        this.repo = repo;
    }
    
    
    @Override
    public List<Location> findbyCity(String cidade) {
        return repo.findByCidade(cidade);
    }

    @Override
    public List<CityVO> listCidades() {
        return repo.listCityNames();
    }
    
}

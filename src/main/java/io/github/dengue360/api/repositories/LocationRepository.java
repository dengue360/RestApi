/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.repositories;

import java.util.List;
import io.github.dengue360.api.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    public List<Location> findByCidade(String cidade);
    
    @Query("select DISTINCT(l.cidade) from Location l")
    public List<String> listCityNames();
}

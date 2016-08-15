/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.repositories;

import io.github.dengue360.api.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}

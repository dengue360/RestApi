/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import io.github.dengue360.api.entities.Person;
import io.github.dengue360.api.repositories.PersonRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Rafael
 */
@Named
public class PersonServiceImpl implements PersonService{
    private PersonRepository repo;
    
    @Inject
    public void setDao(PersonRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<Person> listAll() {
        return repo.findAll();
    }
    
}

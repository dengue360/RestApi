/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.controllers;

import io.github.dengue360.api.entities.Person;
import io.github.dengue360.api.services.PersonService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael
 */
@RestController
@RequestMapping (value = "/p")
public class PersonController {
    @Inject
    private PersonService pservice;
    
    @RequestMapping(value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> list(){
        return pservice.listAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import io.github.dengue360.api.entities.Person;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael
 */
@Service
public interface PersonService {
    public List<Person> listAll();
}

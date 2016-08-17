/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.controllers;

import io.github.dengue360.api.services.CaseService;
import javax.inject.Inject;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael
 */
@RestController
@RequestMapping(value = "/c")
public class CaseController {
    @Inject
    private CaseService cService;
    
    @RequestMapping(method = RequestMethod.GET, value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> list(@RequestParam(value = "mes",required = false) String mes, 
            @RequestParam(value = "ano",required = false) Integer ano){
        return cService.listSexo(mes, ano);
    }
}

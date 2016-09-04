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
import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.vo.CoordenadasVO;
import io.github.dengue360.api.entities.vo.InfoVO;
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
    public List<CaseD> list(@RequestParam(value = "mes",required = false) String mes, 
            @RequestParam(value = "ano",required = false) Integer ano){
        return cService.listSexo(mes, ano);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public InfoVO infoQtde(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano){
        return cService.getInfo(cidade, ano);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/coor", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CoordenadasVO> coordenadas(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano){
        return cService.getCoodenadas(cidade, ano);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import io.github.dengue360.api.repositories.CaseRepository;
import io.github.dengue360.api.entities.CaseD;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Rafael
 */
@Named
public class CaseServiceImpl implements CaseService{
    private CaseRepository repo;
    
    @Inject
    public void setDao(CaseRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<CaseD> listSexo(String mes, Integer ano) {
        return repo.findAllSexByMonth(mes, ano);
    }
    
}

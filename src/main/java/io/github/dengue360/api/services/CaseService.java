/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import org.springframework.stereotype.Service;
import io.github.dengue360.api.entities.CaseD;
import java.util.List;

/**
 *
 * @author Rafael
 */
@Service
public interface CaseService {
    public List<CaseD> listSexo(String mes, Integer ano);
}

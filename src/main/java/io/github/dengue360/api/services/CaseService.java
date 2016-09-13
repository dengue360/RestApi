/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import org.springframework.stereotype.Service;
import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.vo.CoordenadasVO;
import io.github.dengue360.api.entities.vo.GravidezGraphVO;
import io.github.dengue360.api.entities.vo.InfoGraphVO;
import io.github.dengue360.api.entities.vo.InfoVO;
import io.github.dengue360.api.entities.vo.SexoGraphVO;
import java.util.List;

/**
 *
 * @author Rafael
 */
@Service
public interface CaseService {
    public List<CaseD> listSexo(String mes, Integer ano);
    
    public InfoVO getInfo(String cidade, Integer ano);
    
    public List<CoordenadasVO> getCoodenadas(String cidade, Integer ano);
    
    public SexoGraphVO getSexoNumbers(String cidade, Integer ano, String mes);
    public GravidezGraphVO getGravidezNumbers(String cidade, Integer ano, String mes);
    public InfoGraphVO getInfoNumbers(String cidade, Integer ano);
    
//    public List<CoordenadasVO> getCoodenadasComFiltro(String cidade, Integer ano, String filtro);
}

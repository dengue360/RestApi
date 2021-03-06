/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.controllers;

import io.github.dengue360.api.services.CaseService;
import javax.inject.Inject;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.StringBuilder;
import org.springframework.http.MediaType;
import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.vo.CoordenadasVO;
import io.github.dengue360.api.entities.vo.FaixaEtariaVO;
import io.github.dengue360.api.entities.vo.Filtro;
import io.github.dengue360.api.entities.vo.GravidezGraphVO;
import io.github.dengue360.api.entities.vo.InfoGraphVO;
import io.github.dengue360.api.entities.vo.InfoVO;
import io.github.dengue360.api.entities.vo.SexoGraphVO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @RequestMapping(method = RequestMethod.GET, value="/graph/sex", produces = MediaType.APPLICATION_JSON_VALUE)
    public SexoGraphVO getSexGraphNumbers(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano,
            @RequestParam(value = "mes",required = false) String mes){
        return cService.getSexoNumbers(cidade, ano, mes);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/graph/gravidez", produces = MediaType.APPLICATION_JSON_VALUE)
    public GravidezGraphVO getGravidezGraphNumbers(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano,
            @RequestParam(value = "mes",required = false) String mes){
        return cService.getGravidezNumbers(cidade, ano, mes);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/graph/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public InfoGraphVO getInfoGraphNumbers(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano){
        return cService.getInfoNumbers(cidade, ano);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/graph/faixa", produces = MediaType.APPLICATION_JSON_VALUE)
    public FaixaEtariaVO getFaixaGraphNumbers(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano){
        return cService.getFaixaNumbers(cidade, ano);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/coor/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CoordenadasVO> coordenadasFilter(@RequestParam(value = "cidade",required = true) String cidade, 
            @RequestParam(value = "ano",required = true) Integer ano, 
            @RequestParam(value = "dtInicio",required = false) String dtInicio,
            @RequestParam(value = "dtFim",required = false) String dtFim,
            @RequestParam(value = "categoria",required = false) String categoria,
            @RequestParam(value = "gestante",required = false) String gestante,
            @RequestParam(value = "faixaInit",required = false) String faixainit,
            @RequestParam(value = "faixaEnd",required = false) String faixaend,
            @RequestParam(value = "sexo",required = false) String sexo){
        Filtro f = new Filtro();
        f.setCategoria(categoria);
        try {
            f.setDtInit(formataData(dtInicio));
            f.setDtEnd(formataData(dtFim));
        } catch (ParseException ex) {
            Logger.getLogger(CaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(faixainit.equals("undefined")||faixaend.equals("undefined")){
            f.setFaixaInit(null);
            f.setFaixaEnd(null);
        }else{
            f.setFaixaInit(Integer.parseInt(faixainit));
            f.setFaixaEnd(Integer.parseInt(faixaend));
        }
        f.setGravidez(gestante);
        f.setSexo(sexo);
        return cService.getCoordenadasComFiltro(cidade, ano, f);
    }
    
    
    /**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou nula, 
	 * retorna null - para facilitar em casos onde formulários podem ter campos
	 * de datas vazios.
	 * @param data String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws java.text.ParseException
	 */
	public static Date formataData(String data) throws ParseException{ 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
        
        return date;
	}
//    @RequestMapping(method = RequestMethod.GET, value="/coor", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CoordenadasVO> coordenadasComFiltro(
//            @RequestParam(value = "cidade",required = true) String cidade, 
//            @RequestParam(value = "ano",required = true) Integer ano, 
//            @RequestParam(value = "dtInicio",required = false) String dtInicio,
//            @RequestParam(value = "dtFim",required = false) String dtFim,
//            @RequestParam(value = "categoria",required = false) String categoria,
//            @RequestParam(value = "gestante",required = false) String gestante,
//            @RequestParam(value = "faixa",required = false) String faixa,
//            @RequestParam(value = "sexo",required = false) String sexo){
//        
//        StringBuilder filter = new StringBuilder();
//        filter.append(dataQueryTransform(dtInicio,dtFim));
//        filter.append(categoriaQueryTransform(categoria));
//        filter.append(gestanteQueryTransform(gestante));
//        filter.append(faixaQueryTransform(faixa));
//        filter.append(sexoQueryTransform(sexo));
//        
//        return cService.getCoodenadasComFiltro(cidade, ano, filter.toString());
//    }
//
//    private String dataQueryTransform(String dtInicio, String dtFim) {
//        String query = "";
//        if((dtInicio != null) && (dtFim != null) )
//            query = "AND (t.noteDate BETWEEN '"+dtInicio+"' AND '"+dtFim+"') ";
//        return query;
//    }
//
//    private String categoriaQueryTransform(String categoria) {
//        String query = "";
//        if(categoria != null)
//            query = "AND (c."+categoria+" = true) ";
//        return query;
//    }
//
//    private String gestanteQueryTransform(String gestante) {
//        String query = "";
//        if(gestante != null)
//            query = "AND (p.gestante = '"+gestante+"') ";
//        return query;
//    }
//
//    private String faixaQueryTransform(String faixa) {
//        return "";
//    }
//
//    private String sexoQueryTransform(String sexo) {
//        String query = "";
//        if(sexo != null)
//            query = "AND (p.sexo = '"+sexo+"') ";
//        return query;
//    }
//    
}

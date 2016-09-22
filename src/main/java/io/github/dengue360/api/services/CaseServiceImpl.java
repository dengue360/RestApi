/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.services;

import io.github.dengue360.api.repositories.CaseRepository;
import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.vo.CoordenadasVO;
import io.github.dengue360.api.entities.vo.FaixaEtariaVO;
import io.github.dengue360.api.entities.vo.GravidezGraphVO;
import io.github.dengue360.api.entities.vo.InfoGraphVO;
import io.github.dengue360.api.entities.vo.InfoVO;
import io.github.dengue360.api.entities.vo.SexoGraphVO;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
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

    @Override
    public InfoVO getInfo(String cidade, Integer ano) {
        InfoVO info = new InfoVO();
        
        info.setNotificados(repo.countAllCasesByCity(cidade, ano));
        info.setConfirmados(repo.countCasesConfirmadosByCity(cidade, ano));
        info.setGraves(repo.countCasesGraveByCity(cidade, ano));
        info.setObitos(repo.countCasesObitoByCity(cidade, ano));
        return info;
    }

    @Override
    public List<CoordenadasVO> getCoodenadas(String cidade, Integer ano) {
        return repo.listCasesCoordenates(cidade, ano);
    }

//    @Override
//    public List<CoordenadasVO> getCoodenadasComFiltro(String cidade, Integer ano, String filtro) {
//        return repo.listCasesCoordenatesFilter(cidade, ano, filtro);
//    }

    @Override
    public SexoGraphVO getSexoNumbers(String cidade, Integer ano, String mes) {
        SexoGraphVO graphVO = new SexoGraphVO();
        if (mes == null) {
            graphVO.setQtdeMasc(repo.countSexo(cidade, ano, "Masculino"));
            graphVO.setQtdeFem(repo.countSexo(cidade, ano, "Feminino"));
            graphVO.setQtdeIg(repo.countSexo(cidade, ano, "Ignorado"));
        }else{
            graphVO.setQtdeMasc(repo.countSexoByMount(cidade, ano, "Masculino", mes));
            graphVO.setQtdeFem(repo.countSexoByMount(cidade, ano, "Feminino", mes));
            graphVO.setQtdeIg(repo.countSexoByMount(cidade, ano, "Ignorado", mes));
        }
        return graphVO;
    }

    @Override
    public GravidezGraphVO getGravidezNumbers(String cidade, Integer ano, String mes) {
        GravidezGraphVO graphVO = new GravidezGraphVO();
        if (mes == null) {
            graphVO.setPrimeiroTriQtde(repo.countGravidez(cidade, ano, "1° Trimestre"));
            graphVO.setSegundoTriQtde(repo.countGravidez(cidade, ano, "2° Trimestre"));
            graphVO.setTerceiroTriQtde(repo.countGravidez(cidade, ano, "3° Trimestre"));
            graphVO.setIdadeIgnQtde(repo.countGravidez(cidade, ano, "Idade gestacional ignorada"));
            graphVO.setNotQtde(repo.countGravidez(cidade, ano, "Não"));
            graphVO.setNotAplQtde(repo.countGravidez(cidade, ano, "Não se aplica"));
            graphVO.setIgnQtde(repo.countGravidez(cidade, ano, "Ignorado"));
        }else{
            graphVO.setPrimeiroTriQtde(repo.countGravidezByMount(cidade, ano, "1° Trimestre",mes));
            graphVO.setSegundoTriQtde(repo.countGravidezByMount(cidade, ano, "2° Trimestre",mes));
            graphVO.setTerceiroTriQtde(repo.countGravidezByMount(cidade, ano, "3° Trimestre",mes));
            graphVO.setIdadeIgnQtde(repo.countGravidezByMount(cidade, ano, "Idade gestacional ignorada",mes));
            graphVO.setNotQtde(repo.countGravidezByMount(cidade, ano, "Não",mes));
            graphVO.setNotAplQtde(repo.countGravidezByMount(cidade, ano, "Não se aplica",mes));
            graphVO.setIgnQtde(repo.countGravidezByMount(cidade, ano, "Ignorado",mes));
        }
        
        return graphVO;
    }
    
     @Override
    public FaixaEtariaVO getFaixaNumbers(String cidade, Integer ano) {
        FaixaEtariaVO etariaVO = new FaixaEtariaVO();
        Date d = new Date();
        etariaVO.setDe0a12(repo.countCasesByFaixa(cidade, ano, 0, 12, d));
        etariaVO.setDe13a24(repo.countCasesByFaixa(cidade, ano, 13, 24, d));
        etariaVO.setDe25a36(repo.countCasesByFaixa(cidade, ano, 25, 36, d));
        etariaVO.setDe37a48(repo.countCasesByFaixa(cidade, ano, 37, 48, d));
        etariaVO.setDe49a60(repo.countCasesByFaixa(cidade, ano, 49, 60, d));
        etariaVO.setAcimaDe60(repo.countCasesByFaixa(cidade, ano, 61, 100, d));
        return etariaVO;
    }
    
    
    @Override
    public InfoGraphVO getInfoNumbers(String cidade, Integer ano) {
        InfoGraphVO graphVO = new InfoGraphVO();
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Janeiro"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Fevereiro"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Março"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Abril"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Maio"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Junho"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Julho"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Agosto"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Setembro"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Outubro"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Novembro"));
        graphVO.addNotificado(repo.countAllCasesByCityAndMount(cidade, ano, "Dezembro"));
        
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Janeiro"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Fevereiro"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Março"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Abril"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Maio"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Junho"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Julho"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Agosto"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Setembro"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Outubro"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Novembro"));
        graphVO.addConfirmado(repo.countCasesConfirmadosByCityAndMount(cidade, ano, "Dezembro"));
        
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Janeiro"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Fevereiro"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Março"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Abril"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Maio"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Junho"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Julho"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Agosto"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Setembro"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Outubro"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Novembro"));
        graphVO.addObito(repo.countCasesObitoByCityAndMount(cidade, ano, "Dezembro"));
        
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Janeiro"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Fevereiro"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Março"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Abril"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Maio"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Junho"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Julho"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Agosto"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Setembro"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Outubro"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Novembro"));
        graphVO.addGrave(repo.countCasesGraveByCityAndMount(cidade, ano, "Dezembro"));
        
        return graphVO;
    }

   
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.repositories;

import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.CasePK;
import io.github.dengue360.api.entities.vo.CoordenadasVO;
import io.github.dengue360.api.entities.vo.SexoGraphVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael
 */
@Repository
public interface CaseRepository extends JpaRepository<CaseD, CasePK>{
    
    //TODO Verificar essa consulta 
     @Query("SELECT c FROM CaseD c "
            + "INNER JOIN Person p ON (c.id.personCod = p.id) "
            + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
            + "WHERE t.mes = :month AND t.ano = :year")
    public List<CaseD> findAllSexByMonth(@Param("month")String mes, @Param("year") Integer ano);
      
      @Query("SELECT COUNT(c) FROM CaseD c")  
      public Integer countAllCases();
      
      @Query("SELECT COUNT(c) FROM CaseD c WHERE c.confirmado = true")  
      public Integer countCasesConfirmados();
      
      @Query("SELECT COUNT(c) FROM CaseD c WHERE c.grave = true")  
      public Integer countCasesGrave();
      
     //COunt Queries 
     @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE l.cidade = :city AND t.ano = :year")  
      public Integer countAllCasesByCity(@Param("city")String cidade, @Param("year")Integer ano);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND c.confirmado = true")   
      public Integer countCasesConfirmadosByCity(@Param("city")String cidade, @Param("year")Integer ano);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND c.grave = true") 
      public Integer countCasesGraveByCity(@Param("city")String cidade, @Param("year")Integer ano);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND c.obito = true") 
      public Integer countCasesObitoByCity(@Param("city")String cidade, @Param("year")Integer ano);
      
      
      //infoGRaph
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE l.cidade = :city AND t.ano = :year AND t.mes = :mount")  
      public Integer countAllCasesByCityAndMount(@Param("city")String cidade, @Param("year")Integer ano, @Param("mount")String mes);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND (c.confirmado = true AND t.mes = :mount)")   
      public Integer countCasesConfirmadosByCityAndMount(@Param("city")String cidade, @Param("year")Integer ano, @Param("mount")String mes);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND (c.grave = true AND t.mes = :mount)") 
      public Integer countCasesGraveByCityAndMount(@Param("city")String cidade, @Param("year")Integer ano, @Param("mount")String mes);
      
      @Query("SELECT COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND (c.obito = true AND t.mes = :mount)") 
      public Integer countCasesObitoByCityAndMount(@Param("city")String cidade, @Param("year")Integer ano, @Param("mount")String mes);
      
      
      
      //Graph Queries
       @Query("select COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "INNER JOIN Person p ON (c.id.personCod = p.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND p.sexo = :sex")
      public Integer countSexo(@Param("city")String cidade, @Param("year")Integer ano, @Param("sex")String sexo);
      
        @Query("select COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "INNER JOIN Person p ON (c.id.personCod = p.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND (p.sexo = :sex AND t.mes = :mount)")
      public Integer countSexoByMount(@Param("city")String cidade, @Param("year")Integer ano, 
              @Param("sex")String sexo, @Param("mount")String mes);
      
      @Query("select COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "INNER JOIN Person p ON (c.id.personCod = p.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND p.gestante = :tipoG")
      public Integer countGravidez(@Param("city")String cidade, @Param("year")Integer ano, @Param("tipoG")String tipo);
      
        @Query("select COUNT(c) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "INNER JOIN Person p ON (c.id.personCod = p.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND (p.gestante = :tipoG AND t.mes = :mount)")
      public Integer countGravidezByMount(@Param("city")String cidade, @Param("year")Integer ano, 
              @Param("tipoG")String tipo, @Param("mount")String mes);
      
      //Map Queries
      
      @Query("select DISTINCT NEW io.github.dengue360.api.entities.vo.CoordenadasVO(l.lat, l.lng) FROM CaseD c "
          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
          + "WHERE (l.cidade = :city AND t.ano = :year) AND l.lat not like ''")
      public List<CoordenadasVO> listCasesCoordenates(@Param("city")String cidade, @Param("year")Integer ano);
      
//      //como resolver essa porra aqui
//      
//      @Query("select DISTINCT NEW io.github.dengue360.api.entities.vo.CoordenadasVO(l.lat, l.lng) FROM CaseD c "
//          + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
//          + "INNER JOIN TimeD t ON (c.id.timeCod = t.id) "
//          + "INNER JOIN Person p ON (c.id.personCod = p.id) "
//          + "WHERE (l.cidade = :city AND t.ano = :year) AND (l.lat not like '') :filter")
//      public List<CoordenadasVO> listCasesCoordenatesFilter(@Param("city")String cidade, 
//              @Param("year")Integer ano, @Param("filter")String filter);
}

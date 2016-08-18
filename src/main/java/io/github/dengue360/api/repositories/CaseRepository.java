/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api.repositories;

import io.github.dengue360.api.entities.CaseD;
import io.github.dengue360.api.entities.CasePK;
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
    
      @Query("SELECT COUNT(c) FROM CaseD c "
              + "INNER JOIN Location l ON (c.id.locationCod = l.id) "
              + "WHERE l.cidade = ?1")  
      public Integer countAllCasesByCity(String cidade);
      
      @Query("SELECT COUNT(c) FROM CaseD c")  
      public Integer countAllCases();
      
      @Query("SELECT COUNT(c) FROM CaseD c WHERE c.confirmado = true")  
      public Integer countCasesConfirmados();
      
      @Query("SELECT COUNT(c) FROM CaseD c WHERE c.grave = true")  
      public Integer countCasesGrave();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

package org.solver.app.reservaVuelo.Repository;

import java.util.Calendar;
import java.util.List;
import org.solver.app.reservaVuelo.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author César Aguirre Vega
 */
public interface VueloRepository extends JpaRepository<Vuelo,Long> {
   @Query("SELECT v FROM Vuelo v where v.tarifaVuelo.ciudadOrigen = ?1 AND  v.tarifaVuelo.ciudadDestino = ?2  AND v.fecha = ?3")
   public List<Vuelo> consultarVueloCriterio(String ciudadOrigen,String ciudadDestino, Calendar fecha);     
}

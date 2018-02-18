/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solver.app.reservaVuelo.Repository;

import java.io.Serializable;
import org.solver.app.reservaVuelo.entity.TarifaVuelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HOGAR
 */
public interface TarifaVueloRepository extends JpaRepository<TarifaVuelo, Long> {
    
    public TarifaVuelo findByCiudadOrigenAndCiudadDestino(String ciudadOrigen,String ciudadDestino);        
    
}

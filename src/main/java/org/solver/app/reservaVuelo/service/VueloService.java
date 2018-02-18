/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.service;

import java.util.List;
import org.solver.app.reservaVuelo.Repository.VueloRepository;
import org.solver.app.reservaVuelo.entity.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author César Aguirre Vega
 */
@Service
public class VueloService {
  
    @Autowired
    VueloRepository vueloRepository;
    public List<Vuelo> consultarVuelos(Vuelo vuelo){
        return vueloRepository.consultarVueloCriterio(vuelo.getTarifaVuelo().getCiudadOrigen(),vuelo.getTarifaVuelo().getCiudadDestino(),vuelo.getFecha());
    }
    
    public List<Vuelo> consultarTodosVuelos(){
        return vueloRepository.findAll();
    }
}

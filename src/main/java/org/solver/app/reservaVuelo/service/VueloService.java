/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.service;

import java.util.Calendar;
import java.util.List;
import org.solver.app.reservaVuelo.Repository.TarifaVueloRepository;
import org.solver.app.reservaVuelo.Repository.VueloRepository;
import org.solver.app.reservaVuelo.entity.TarifaVuelo;
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
    @Autowired
    TarifaVueloRepository tarifaVueloRepository;
    
    public List<Vuelo> consultarVuelos(Vuelo vuelo){
        List<Vuelo> vuelos = vueloRepository.consultarVueloCriterio(vuelo.getTarifaVuelo().getCiudadOrigen(),vuelo.getTarifaVuelo().getCiudadDestino(),vuelo.getFecha()); 
        ajustarPreciosVuelo(vuelos);
        return vuelos;
    }
    
    public List<Vuelo> consultarTodosVuelos(){
        return vueloRepository.findAll();
    }
    
    public List<TarifaVuelo> consultarTodosTarifas(){
        return tarifaVueloRepository.findAll(); 
    }
    
    private void ajustarPreciosVuelo(List<Vuelo> vuelos){
        if(vuelos != null){
            for (Vuelo vuelo : vuelos){
                if(esFechaFinDeSemana(vuelo.getFecha())){
                    vuelo.setPrecio(vuelo.getTarifaVuelo().getPrecio() + (vuelo.getTarifaVuelo().getPrecio() *(vuelo.getTarifaVuelo().getPorcentajeRecargoFinSemana()/100)));
                }else{
                    if( vuelo.getHora() < 1200){
                       vuelo.setPrecio(vuelo.getTarifaVuelo().getPrecio() + (vuelo.getTarifaVuelo().getPrecio() *(vuelo.getTarifaVuelo().getPorcentajeRecargoManana()/100)));
                     }else{
                        vuelo.setPrecio(vuelo.getTarifaVuelo().getPrecio() + (vuelo.getTarifaVuelo().getPrecio() *(vuelo.getTarifaVuelo().getPorcentajeRecargoTarde()/100)));
                    }
                }
            }
        }
    }
    
    private boolean esFechaFinDeSemana(Calendar fechaVuelo){
       return (fechaVuelo.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || fechaVuelo.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY );
    }
}

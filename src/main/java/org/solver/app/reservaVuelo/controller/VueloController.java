/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.controller;

import java.util.Calendar;
import java.util.List;
import org.solver.app.reservaVuelo.Repository.VueloRepository;
import org.solver.app.reservaVuelo.entity.TarifaVuelo;
import org.solver.app.reservaVuelo.entity.Vuelo;
import org.solver.app.reservaVuelo.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author César Aguirre Vega
 */
@RestController
public class VueloController {
    @Autowired
    VueloService vueloService;
    
    @CrossOrigin
    @PostMapping("/consultarvuelos")
    public List<Vuelo> consultarVuelos(@RequestBody Vuelo vuelo){
        /*Vuelo vuelo = new Vuelo(); 
        TarifaVuelo tarifaVuelo = new TarifaVuelo();
        tarifaVuelo.setCiudadOrigen("Bogota");
        tarifaVuelo.setCiudadDestino("Cúcuta");                
        vuelo.setTarifaVuelo(tarifaVuelo);
        vuelo.setFecha(Calendar.getInstance());
        vuelo.getFecha().add(Calendar.DAY_OF_YEAR, 2);*/
        return vueloService.consultarVuelos(vuelo); 
    }
    
    
    @GetMapping("/vuelos")
    public List<Vuelo> consultarTodosVuelos(){
        return vueloService.consultarTodosVuelos();
    }
    
    
    @CrossOrigin
    @GetMapping("/tarifas")    
    public List<TarifaVuelo> consultarTodosTafifas(){
        return vueloService.consultarTodosTarifas();
    }

}

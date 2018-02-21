/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.controller;

import java.util.List;
import org.solver.app.reservaVuelo.entity.Reserva;
import org.solver.app.reservaVuelo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author César Aguirre Vega
 */

@RestController
public class ReservaController {
    
    @Autowired
    ReservaService reservaService;
    
    @CrossOrigin
    @PostMapping("/reserva")
    public Reserva registrarReserva(@RequestBody Reserva reserva){
        return reservaService.registrarReserva(reserva);
    }
    
    
    @CrossOrigin
    @GetMapping("/consultareservas")
    public List<Reserva> consultarReservasUsuario(@RequestParam ("identificacion") String identificacion){
        System.out.println("identificacion--> "+identificacion);
        return reservaService.consultarReservasUsuario(identificacion);
    }

}

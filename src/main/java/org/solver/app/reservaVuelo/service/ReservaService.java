/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.service;

import java.util.Calendar;
import java.util.List;
import org.solver.app.reservaVuelo.Repository.ReservaRepository;
import org.solver.app.reservaVuelo.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author César Aguirre Vega
 */
@Service
public class ReservaService {
  @Autowired
  ReservaRepository reservaRepository;
  public Reserva registrarReserva(Reserva reserva){
      reserva.setFechaRegistro(Calendar.getInstance());
      reserva.setEstado("ACTIVO");
      return reservaRepository.save(reserva);
  }
  
  
  public List<Reserva> consultarReservasUsuario(String identificacion){
        return reservaRepository.consultarReservasUsuario(identificacion);
  }
}

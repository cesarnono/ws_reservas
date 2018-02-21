/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solver.app.reservaVuelo.Repository;

import java.io.Serializable;
import java.util.List;
import org.solver.app.reservaVuelo.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HOGAR
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    @Query("SELECT r FROM Reserva r where r.usuario.identificacion = ?1")
    public List<Reserva> consultarReservasUsuario(String identificacion);
}

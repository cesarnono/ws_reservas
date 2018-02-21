/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.Repository;

import org.solver.app.reservaVuelo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author César Aguirre Vega
 */
public interface UserRepository extends JpaRepository<Usuario,Long> {
  public Usuario findByIdentificacion(String identificacion);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.service;

import java.util.List;
import org.solver.app.reservaVuelo.Repository.UserRepository;
import org.solver.app.reservaVuelo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author César Aguirre Vega
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public List<Usuario> obtenerUsuarios(){
        return userRepository.findAll();
    }
    
    public Usuario registrarUsuario(Usuario usuario){
        return userRepository.save(usuario);
    }
    
    public Usuario consultarUsuario(String identificacion){
        Usuario usuario = userRepository.findByIdentificacion(identificacion);
        System.out.println("usuario consultado : "+usuario);
        return usuario;
    }

}

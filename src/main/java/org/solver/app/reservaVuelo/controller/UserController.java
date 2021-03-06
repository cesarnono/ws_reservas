/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.controller;

import java.util.List;
import org.solver.app.reservaVuelo.entity.Usuario;
import org.solver.app.reservaVuelo.service.UserService;
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
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }
    
    @CrossOrigin
    @PostMapping("/regusuario")    
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return userService.registrarUsuario(usuario);
    }
    
    @CrossOrigin
    @GetMapping("/consultausuario")    
    public Usuario consultarUsuario(@RequestParam("identificacion") String identificacion){
        System.out.println("consultausuario.....["+identificacion +"]");
        return userService.consultarUsuario(identificacion); 
    }
    

}

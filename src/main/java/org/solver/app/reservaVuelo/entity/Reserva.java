/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author César Aguirre Vega
 */
@Entity
public class Reserva implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   @Temporal(TemporalType.DATE)   
   private Calendar fechaRegistro;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "usua_id")
   private Usuario usuario;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "vuelo_id")
   private Vuelo vuelo;
   private String estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }  
     
}

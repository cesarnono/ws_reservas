/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author César Aguirre Vega
 */
@Entity
public class Vuelo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numeroAvion;    
    private int tiempoDuracionMinutos;
    @Temporal(TemporalType.DATE)
    private Calendar fecha;
    private int hora;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarfvuelo_id")
    private TarifaVuelo tarifaVuelo;
    
    @JsonIgnore
    @OneToMany(mappedBy = "vuelo",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Reserva> reservas;
    
    @Transient
    private float precio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroAvion() {
        return numeroAvion;
    }

    public void setNumeroAvion(String numeroAvion) {
        this.numeroAvion = numeroAvion;
    }  

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public TarifaVuelo getTarifaVuelo() {
        return tarifaVuelo;
    }

    public void setTarifaVuelo(TarifaVuelo tarifaVuelo) {
        this.tarifaVuelo = tarifaVuelo;
    }   

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }   

    public int getTiempoDuracionMinutos() {
        return tiempoDuracionMinutos;
    }

    public void setTiempoDuracionMinutos(int tiempoDuracionMinutos) {
        this.tiempoDuracionMinutos = tiempoDuracionMinutos;
    } 

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    

}

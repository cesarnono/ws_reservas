/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.solver.app.reservaVuelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author César Aguirre Vega
 */
@Entity
public class TarifaVuelo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private float precio;
    private float porcentajeRecargoManana;
    private float porcentajeRecargoTarde;
    private float porcentajeRecargoFinSemana;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tarifaVuelo",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Vuelo> vuelos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPorcentajeRecargoManana() {
        return porcentajeRecargoManana;
    }

    public void setPorcentajeRecargoManana(float porcentajeRecargoManana) {
        this.porcentajeRecargoManana = porcentajeRecargoManana;
    }

    public float getPorcentajeRecargoTarde() {
        return porcentajeRecargoTarde;
    }

    public void setPorcentajeRecargoTarde(float porcentajeRecargoTarde) {
        this.porcentajeRecargoTarde = porcentajeRecargoTarde;
    }

    public float getPorcentajeRecargoFinSemana() {
        return porcentajeRecargoFinSemana;
    }

    public void setPorcentajeRecargoFinSemana(float porcentajeRecargoFinSemana) {
        this.porcentajeRecargoFinSemana = porcentajeRecargoFinSemana;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }  

}

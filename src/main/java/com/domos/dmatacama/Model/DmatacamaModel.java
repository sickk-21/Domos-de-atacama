package com.domos.dmatacama.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DmatacamaModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private int capacidad;
    private String estado; // "Disponible", "Ocupado"

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

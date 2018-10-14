/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="auto")
public class Auto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer idAuto;
    
    
    
    @Column
    private String Marca;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "auto",cascade = CascadeType.ALL)
    private List <Viajes>viajes;
    
    @Column
    private String Modelo;
    
    @Column
    private String Matricula;
    
    @Column
    private String NroPuesto;

    public Auto() {
    }

    public Integer getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNroPuesto() {
        return NroPuesto;
    }

    public void setNroPuesto(String NroPuesto) {
        this.NroPuesto = NroPuesto;
    }
  
}

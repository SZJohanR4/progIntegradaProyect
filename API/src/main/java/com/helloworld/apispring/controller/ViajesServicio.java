/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;


import com.helloworld.apispring.model.dao.ViajesRepositorio;
import java.util.Date;
import com.helloworld.apispring.model.entity.Viajes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author eser
 */
@Service
public class ViajesServicio {
    @Autowired
    private ViajesRepositorio viajesRepositorio;

    public ViajesServicio() {
    }
    
    public List<Viajes> getAllViajes(){
        return viajesRepositorio.getAllViajes();
    }
    
     public List<Viajes> viajeListFilters(){
        return viajesRepositorio.viajeListFilters();
    }
    
    
     public List<Viajes> getviajeHistory(String idUsuario){
        return viajesRepositorio.getAllViajes();
    }
    public String crear(Viajes viajes) {
    long ViajeId= viajesRepositorio.crearViaje(viajes);
    return "Visje creado con ID:"+ViajeId;
    }
     public List<Viajes>  Criterios_viajes(String Origen,String Destino, Date Fecha, String NroAsientos) {
      return viajesRepositorio.getViajeCriterios(Origen,Destino,Fecha,NroAsientos);
    }

     
      public List<Viajes>  Criterios_viajes_user_auto(Integer user,Integer auto, Integer viaje) {
      return viajesRepositorio.getViajeCriterios_auto_user(user,auto,viaje);
    }


    
}

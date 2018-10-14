/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;


import java.util.Date;
import com.helloworld.apispring.model.entity.Auto;
import com.helloworld.apispring.model.entity.Usuario;
import com.helloworld.apispring.model.entity.Viajes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
    
    @Autowired
    private AutoServicio autoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private ViajesServicio viajesservicio;
    
    @RequestMapping(value = "/autosList/", method = RequestMethod.GET)//ok
    public ResponseEntity<List<Auto>> obtenerAutos() {
        List<Auto> carros = autoServicio.getAllAutos();
        return new ResponseEntity<List<Auto>>(carros, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usuariosList/", method = RequestMethod.GET)//ok
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> users = usuarioServicio.getAllUsuario();
        return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Viajeslist/", method = RequestMethod.GET)//ok
    public ResponseEntity<List<Viajes>> obtenerViaje() {
        List<Viajes> viajes = viajesservicio.getAllViajes();
        return new ResponseEntity<List<Viajes>>(viajes, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/autoNew/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearAuto(@RequestBody Auto carroNew) {
        String resultado = autoServicio.crearAuto(carroNew);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
   
   @RequestMapping(value = "/usuarioNew/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario userNew) {
        String resultado = usuarioServicio.crearUsuario(userNew);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/viajeHistory/", method = RequestMethod.GET)
    public ResponseEntity<List<Viajes>> viajeHistory(@RequestParam ("Usuario_idUsuario") String idUsuario) {
        List<Viajes> viajes = viajesservicio.getviajeHistory(idUsuario);
        return new ResponseEntity<List<Viajes>>(viajes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/viajeListFilters/", method = RequestMethod.GET)
    public ResponseEntity<List<Viajes>> viajeListFilters() {
        List<Viajes> viajes = viajesservicio.viajeListFilters();
        return new ResponseEntity<List<Viajes>>(viajes, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/CrearViaje/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearViaje(@RequestBody Viajes viaje) {
        String resultado = viajesservicio.crear(viaje);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
   
    @RequestMapping(value = "/ViajeFechaOrigenDestino", method = RequestMethod.GET)
    public ResponseEntity<List<Viajes>> ViajeFechaOrigenDestino(@RequestParam ("Origen") String Origen,@RequestParam ("Destino") String Destino,@RequestParam ("Fecha") Date Fecha,@RequestParam ("NroAsientosViaje") String Asientos) {
        List<Viajes> viaje =  viajesservicio.Criterios_viajes(Origen,Destino,Fecha,Asientos);
        return new ResponseEntity<List<Viajes>>(viaje, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/ViajeUsuarioAuto", method = RequestMethod.GET)
    public ResponseEntity<List<Viajes>> ViajeUsuarioAuto(@RequestParam ("idViajes") Integer idviaje,@RequestParam ("idAuto") Integer idauto,@RequestParam ("idUsuario") Integer iduser) {
        List<Viajes> viaje =  viajesservicio.Criterios_viajes_user_auto(iduser,idauto,idviaje);
        return new ResponseEntity<List<Viajes>>(viaje, HttpStatus.OK);
    }
}

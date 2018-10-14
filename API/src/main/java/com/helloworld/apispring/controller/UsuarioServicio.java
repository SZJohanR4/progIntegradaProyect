/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.UsuarioRepositorio;
import com.helloworld.apispring.model.entity.Auto;
import com.helloworld.apispring.model.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eser
 */
@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio() {
    }
    
    public List<Usuario> getAllUsuario(){
        return usuarioRepositorio.getAllUsuario();
    }
    
    public String crearUsuario(Usuario userNew) {
    long equipoId= usuarioRepositorio.crearUsuario(userNew);
    return "Usuario creado con ID:"+equipoId;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.model;

import java.util.Date;

/**
 *
 * @author Java_VS
 */
public class Usuario {
    
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    private String correo;
    private String profesion;
    private boolean esCasado;
    private int edad;
    private String fechaNacimiento;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}

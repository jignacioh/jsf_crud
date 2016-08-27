/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.model.Cliente;
import com.cibertec.crudpracticamaven.model.Producto;
import com.cibertec.crudpracticamaven.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author jhurtace
 */
@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteController implements Serializable{
    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;
    private Usuario clienteCreate;
    private String nombreCliente;
    private Usuario usuarioEdit;
    private String index;
    
    @PostConstruct
    public void init(){
        
    } 
    public void createCliente(){
        clienteCreate=new Usuario();
    }
    public void buscarCliente(){
        if (nombreCliente.isEmpty() || nombreCliente.trim().isEmpty()) {
             loginController.getClientes().clear();
             loginController.getClientes().addAll(loginController.getAllClientes());
         }else{
             loginController.getClientes().clear();
            for (Usuario cliente : loginController.getAllClientes()) {
                if (cliente.getNombre().contains(nombreCliente)) {
                        loginController.getClientes().add(cliente);
                }
            }
         }
    }
    public void create(){
       loginController.getAllClientes().add(clienteCreate);
       loginController.getClientes().add(clienteCreate);
    }
    public void saveCliente(Usuario usuarioEdit){
        setIndex(loginController.getAllClientes().indexOf(usuarioEdit)+"");
        this.usuarioEdit=usuarioEdit;
    }
     public void deleteCliente(Usuario usuario){
        loginController.getClientes().remove(usuario);
        loginController.getAllClientes().remove(usuario);
    }
     public String getIndex() {
        return index;
    }
    public void save(){
        
        loginController.getAllClientes().set(Integer.parseInt(getIndex()), usuarioEdit);
        
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public Usuario getClienteCreate() {
        return clienteCreate;
    }

    public void setClienteCreate(Usuario clienteCreate) {
        this.clienteCreate = clienteCreate;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

   
    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    
}

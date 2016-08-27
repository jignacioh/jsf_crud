/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.model.Cliente;
import com.cibertec.crudpracticamaven.model.Producto;
import com.cibertec.crudpracticamaven.model.Usuario;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Java_VS
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    public Usuario usuario;
    private ArrayList<Producto> productos;
    private ArrayList<Producto> allProductos;
    private ArrayList<Usuario> clientes;
    private ArrayList<Usuario> allClientes;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        productos = new ArrayList<>();
        Producto producto = new Producto();
        producto.setCodigo("AB1");
        producto.setNombre("mesa");
        producto.setStock(30);
        producto.setAmount(20.50);
        productos.add(producto);
        producto = new Producto();
        producto.setCodigo("DF3");
        producto.setNombre("mesa de oro");
        producto.setAmount(10.30);
        producto.setStock(13);
        productos.add(producto);
        producto = new Producto();
        producto.setCodigo("TG2");
        producto.setNombre("tv smart");
        producto.setAmount(34.30);
        producto.setStock(25);
        productos.add(producto);
        producto = new Producto();
        producto.setCodigo("TH0");
        producto.setNombre("tv analogica");
        producto.setAmount(50.50);
        producto.setStock(5);
        productos.add(producto);
        allProductos = new ArrayList<>();
        allProductos.addAll(productos);

        clientes = new ArrayList<>();
        Usuario cliente = new Usuario();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setPassword("a123");
        cliente.setUsername("jupe1");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Jose");
        cliente.setApellido("Anaya");
        cliente.setPassword("xyz2");
        cliente.setUsername("joan2");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Ana");
        cliente.setApellido("Hurtado");
        cliente.setPassword("a1d2f4");
        cliente.setUsername("anhu7");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Maria");
        cliente.setApellido("Cortez");
        cliente.setPassword("o0p9i8");
        cliente.setUsername("maco3");
        clientes.add(cliente);
        allClientes = new ArrayList<>();
        allClientes.addAll(clientes);
    }

    public String login() {
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ex.getRequest();
        HttpSession session = request.getSession(true);
        for (Usuario cliente : clientes) {
            if (cliente.getUsername().equalsIgnoreCase(usuario.getUsername()) && cliente.getPassword().equalsIgnoreCase(usuario.getPassword())) {
                if (session != null) {
                    session.setAttribute("usuario", usuario.getUsername());
                    return "usuarios?faces-redirect-true";
                }
            }
        }
        
        return "";
        
    }

    public void cerraSesion() {
    }

    public String procesar() {
        return "paso3";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getAllProductos() {
        return allProductos;
    }

    public void setAllProductos(ArrayList<Producto> allProductos) {
        this.allProductos = allProductos;
    }

    public ArrayList<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Usuario> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Usuario> getAllClientes() {
        return allClientes;
    }

    public void setAllClientes(ArrayList<Usuario> allClientes) {
        this.allClientes = allClientes;
    }

}

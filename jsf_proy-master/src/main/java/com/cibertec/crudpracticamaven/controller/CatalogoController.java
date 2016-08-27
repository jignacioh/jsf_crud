/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.model.Factura;
import com.cibertec.crudpracticamaven.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jhurtace
 */
@ManagedBean(name="catalogoController")
@ViewScoped
public class CatalogoController {
    //List<Producto> productos,allProductos;
    Factura factura=new Factura();
    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;
    @PostConstruct
    public void init(){
       
    }


    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public void calcularTotal(){
        for (Producto producto : loginController.getProductos()) {
            if (producto.getCantidadComprar()!=0) {
                factura.getMisProductos().add(producto);
            }
        }
        Double total=0.0; 
        for (Producto misProducto : factura.getMisProductos()) {
            total=total+misProducto.getCantidadComprar()*misProducto.getAmount();
        }
        
        factura.setSubtotal(total);
        factura.calcularImpuesto();
        factura.setImpuesto(total*0.19);
        factura.setTotal(total*0.81);
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
}

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
import javax.faces.view.ViewScoped;

/**
 *
 * @author jhurtace
 */
@ManagedBean(name="catalogoController")
@ViewScoped
public class CatalogoController {
    List<Producto> productos,allProductos;
    Factura factura=new Factura();
    @PostConstruct
    public void init(){
       
        productos=new ArrayList<>();
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
        allProductos=new ArrayList<>();
        allProductos.addAll(productos);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getAllProductos() {
        return allProductos;
    }

    public void setAllProductos(List<Producto> allProductos) {
        this.allProductos = allProductos;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public void calcularTotal(){
        for (Producto producto : productos) {
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
}

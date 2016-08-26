/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhurtace
 */
public class Factura {
    private List<Producto> misProductos=new ArrayList<>();
    private Cliente cliente=new Cliente();
    private Double total=0.0;
    private Double subtotal=0.0;
    private Double impuesto=0.0;
    public List<Producto> getMisProductos() {
        return misProductos;
    }

    public void setMisProductos(List<Producto> misProductos) {
        this.misProductos = misProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }
    
    public void calcularImpuesto(){
        impuesto=total*0.19;
    }
}

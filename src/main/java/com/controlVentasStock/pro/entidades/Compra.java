/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlVentasStock.pro.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author juliavallejos
 */
@Entity
public class Compra {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idCompra;
    private String proveedor;
    
    private LocalDateTime fecha;
    private Double costo;
    private String metodoPago;
    private Integer cantidad;
    private String detalle;

    public Compra(String idCompra, String proveedor, LocalDateTime fecha, Double costo, String metodoPago, Integer cantidad, String detalle) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.costo = costo;
        this.metodoPago = metodoPago;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
    public Compra() {
    }

    public String getIdCompra() {
        return idCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public Double getCosto() {
        return costo;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", proveedor=" + proveedor + ", fecha=" + fecha + ", costo=" + costo + ", metodoPago=" + metodoPago + ", cantidad=" + cantidad + ", detalle=" + detalle + '}';
    }

  
    
    
   
}

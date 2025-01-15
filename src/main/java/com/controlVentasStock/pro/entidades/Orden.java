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
public class Orden {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idOrder;
    private String nombre;
    private String menu;
    private Double bebida;
    private String metodoPago;
    private Integer cantidad;
    private LocalDateTime fecha;
    private String hora;
    private Double costoEnvio;
    private Double costoMenu;
    private Double total;

    public Orden(String idOrder, String nombre, String menu, Double bebida, String metodoPago, Integer cantidad, LocalDateTime fecha, String hora, Double costoEnvio, Double costoMenu, Double total) {
        this.idOrder = idOrder;
        this.nombre = nombre;
        this.menu = menu;
        this.bebida = bebida;
        this.metodoPago = metodoPago;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.hora = hora;
        this.costoEnvio = costoEnvio;
        this.costoMenu = costoMenu;
        this.total = total;
    }

    

    public Orden() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

   


    public void setCostoMenu(Double costoMenu) {
        this.costoMenu = costoMenu;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCostoMenu() {
        return costoMenu;
    }

    public Double getTotal() {
        return total;
    }

    

    
    public String getIdOrder() {
        return idOrder;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMenu() {
        return menu;
    }

    public Double getBebida() {
        return bebida;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getHora() {
        return hora;
    }

    public Double getCostoEnvio() {
        return costoEnvio;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setBebida(Double bebida) {
        this.bebida = bebida;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCostoEnvio(Double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrder=" + idOrder + ", nombre=" + nombre + ", menu=" + menu + ", bebida=" + bebida + ", metodoPago=" + metodoPago + ", cantidad=" + cantidad + ", fecha=" + fecha + ", hora=" + hora + ", costoEnvio=" + costoEnvio + ", costoMenu=" + costoMenu + ", total=" + total + '}';
    }

   
    
            
}

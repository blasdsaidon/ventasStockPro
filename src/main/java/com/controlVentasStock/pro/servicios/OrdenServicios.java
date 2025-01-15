/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlVentasStock.pro.servicios;


import com.controlVentasStock.pro.entidades.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlVentasStock.pro.repositorios.OrdenRepo;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * private String idOrder;
    private String nombre;
    private String menu;
    private Double bebida;
    private String metodoPago;
    private Integer cantidad;
    private String hora;
    private double costoEnvio;
 *
 * @author juliavallejos
 */
@Service
public class OrdenServicios {
    
    @Autowired
private OrdenRepo ordenRepo; 
    
    @Transactional
    public void crearOrden(String nombre, String menu, Double bebida, String metodoPago, Integer cantidad, 
            String hora, Double costoEnvio, Double costoMenu, Double total){
        
        LocalDateTime fechaActual = LocalDateTime.now();
        
         
        
        Orden orden = new Orden();
        
        orden.setBebida(bebida);
        orden.setCantidad(cantidad);
        orden.setCostoEnvio(costoEnvio);
        orden.setHora(hora);
        orden.setMenu(menu);
        orden.setMetodoPago(metodoPago);
        orden.setNombre(nombre);
        orden.setTotal(total);
        orden.setCostoMenu(costoMenu);
        orden.setFecha(fechaActual);
        
        
        ordenRepo.save(orden);

        
        
        
    }
    
    public List<Orden> verOrdenesDeHoy(){
        
        return ordenRepo.findOrdenesDeHoy();
    
}
    @Transactional
    public Orden getOne(String idOrden){
        
        Orden orden = null;
          
          Optional<Orden> respuesta = ordenRepo.findById(idOrden);
          
          if (respuesta.isPresent()) {
              
              orden = respuesta.get();
              
          }
          
        return orden;
        
       
        
    }
    
      
    @Transactional
      public void modificarOrden(String idOrder, String menu, String nombre,Double bebida,
              String hora, Integer cantidad, Double costoEnvio, Double costoMenu, Double total, String metodoPago ){
          
          Orden orden = getOne(idOrder);
          System.out.println("orden");
          System.out.println(orden);
        LocalDateTime fechaActual = LocalDateTime.now();
          
        orden.setBebida(bebida);
        orden.setCantidad(cantidad);
        orden.setCostoEnvio(costoEnvio);
        orden.setCostoMenu(costoMenu);
        orden.setHora(hora);
        orden.setMenu(menu);
        orden.setMetodoPago(metodoPago);
        orden.setNombre(nombre);
        orden.setTotal(total);
        orden.setFecha(fechaActual);
        
        ordenRepo.save(orden);
          
      }
         
      @Transactional
      public void eliminarOrden(String idOrder){
        
          
          ordenRepo.deleteById(idOrder);
          
      }
    
      public Map<String, Double> cajaOrden() {
    List<Orden> ordenes = verOrdenesDeHoy();
    Map<String, Double> totalesPorMetodo = new HashMap<>();

    // Inicializar los totales en 0
    totalesPorMetodo.put("ordenEfectivo", 0.0);
    totalesPorMetodo.put("ordenMercadoPago", 0.0);
    totalesPorMetodo.put("ordenCuentaCorriente", 0.0);

    // Calcular los totales
    for (Orden orden : ordenes) {
        String metodoPago = "orden"+orden.getMetodoPago().replace(" ", "");
        Double costo = orden.getTotal();

        totalesPorMetodo.put(metodoPago, totalesPorMetodo.getOrDefault(metodoPago, 0.0) + costo);
    }

    return totalesPorMetodo;
}
}

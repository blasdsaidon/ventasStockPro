/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlVentasStock.pro.servicios;

import com.controlVentasStock.pro.entidades.Compra;
import com.controlVentasStock.pro.repositorios.CompraRepo;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juliavallejos
 */
@Service
public class CompraServicios {
    
    @Autowired
private CompraRepo compraRepo;
    @Transactional
    public void crearCompra(String proveedor, Double costo, String metodoPago, 
            Integer cantidad, String detalle){
       
        LocalDateTime fechaActual = LocalDateTime.now();
        
         
        
        Compra compra = new Compra();
        
        compra.setCantidad(cantidad);
        compra.setCosto(costo);
        compra.setDetalle(detalle);
        compra.setMetodoPago(metodoPago);
        compra.setProveedor(proveedor);
        compra.setFecha(fechaActual);
        
        compraRepo.save(compra);
        
    }
    
      public List<Compra> verComprasDeHoy(){
        
        return compraRepo.findComprasDeHoy();
    
}
      @Transactional
      public Compra getOne(String idCompra){
          
          Compra compra = null;
          
          Optional<Compra> respuesta = compraRepo.findById(idCompra);
          
          if (respuesta.isPresent()) {
              
              compra = respuesta.get();
              
          }
          
        return compra;
          
      }
      
      @Transactional
      public void modificarCompra(String idCompra, Double costo, String detalle,
              String metodoPago, Integer cantidad, String proveedor ){
          
          Compra compra = getOne(idCompra);
          
          LocalDateTime fechaActual = LocalDateTime.now();
          
          compra.setCantidad(cantidad);
        compra.setCosto(costo);
        compra.setDetalle(detalle);
        compra.setMetodoPago(metodoPago);
        compra.setProveedor(proveedor);
        compra.setFecha(fechaActual);
        
        compraRepo.save(compra);
          
      }
         
      @Transactional
      public void eliminarCompra(String idCompra){
        
          
          compraRepo.deleteById(idCompra);
          
      }
      
      public Map<String, Double> cajaCompra() {
    
          List<Compra> compras = verComprasDeHoy();
    
        Map<String, Double> totalesPorMetodo = new HashMap<>();

    // Inicializar los totales en 0
    totalesPorMetodo.put("compraEfectivo", 0.0);
    totalesPorMetodo.put("compraMercadoPago", 0.0);
    totalesPorMetodo.put("compraCuentaCorriente", 0.0);

    // Calcular los totales
    for (Compra compra : compras) {
        String metodoPago = "compra"+compra.getMetodoPago().replace(" ", "");
        Double costo = compra.getCosto();

        totalesPorMetodo.put(metodoPago, totalesPorMetodo.getOrDefault(metodoPago, 0.0) + costo);
    }

    return totalesPorMetodo;
}
      
              
}

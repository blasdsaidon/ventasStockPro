/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlVentasStock.pro.controladores;

import com.controlVentasStock.pro.entidades.Compra;
import com.controlVentasStock.pro.entidades.Orden;
import com.controlVentasStock.pro.servicios.CompraServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controlVentasStock.pro.servicios.OrdenServicios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author juliavallejos
 */
@RestController
@RequestMapping("/")
public class PortalControlador {
    
    @Autowired
    private OrdenServicios ordenServicio;
    @Autowired
    private CompraServicios compraServicio;
    
    
    @GetMapping
    public String inicio() {
        return "App listening";
    }
    
    @PostMapping("/crearOrden")
    public ResponseEntity<String> crearOrden( String nombre, String menu, Double bebida, String metodoPago, Integer cantidad, 
            String hora, Double costoEnvio, Double costoMenu, Double total){
        try{
        ordenServicio.crearOrden(nombre, menu, bebida, metodoPago, cantidad, hora, costoEnvio, costoMenu,total );
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Orden creada");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
        
    }
    
    @GetMapping("/OrdenesDelDia")
    public ResponseEntity<List<Orden>> obtenerOrdenesDeHoy() {
        List<Orden> ordenes = ordenServicio.verOrdenesDeHoy();
        return ResponseEntity.ok(ordenes);
    }
    
    @PostMapping("/modificarOrden")
    public ResponseEntity<String> modificarOrden(String idOrder, String nombre, String menu, Double bebida, String metodoPago, Integer cantidad, 
            String hora, Double costoEnvio, Double costoMenu, Double total){
        
        ordenServicio.modificarOrden(idOrder, menu, nombre, bebida, hora, cantidad, costoEnvio, costoMenu, total, metodoPago);
        
        return ResponseEntity.status(HttpStatus.OK).body("Orden modificada");
        
        
    }
    
    @DeleteMapping("/eliminarOrden/{idOrder}")
    public ResponseEntity<String> eliminarOrden( @PathVariable String idOrder){
        
        ordenServicio.eliminarOrden(idOrder);
        
        return ResponseEntity.status(HttpStatus.OK).body("Orden eliminada");
        
    }
    
    @PostMapping("/crearCompra")
    public ResponseEntity<String> crearCompra(String proveedor, Double costo,
            String metodoPago, Integer cantidad, String detalle){
        try {
            compraServicio.crearCompra(proveedor, costo, metodoPago, cantidad, detalle);
            return ResponseEntity.status(HttpStatus.CREATED).body("Compra creada");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
        
        
        
        
    }
    
    @GetMapping("/ComprasDelDia")
    public ResponseEntity<List<Compra>> obtenerComprasDeHoy() {
        List<Compra> Compras = compraServicio.verComprasDeHoy();
        return ResponseEntity.ok(Compras);
    }
    
    @PostMapping("/modificarCompra")
    public ResponseEntity<String> modificarCompra(String idCompra, Double costo, String detalle,
              String metodoPago, Integer cantidad, String proveedor ){
        
        System.out.println("idCompra");
        System.out.println(idCompra);
        
        compraServicio.modificarCompra(idCompra, costo, detalle, metodoPago, cantidad, proveedor);
        
        return ResponseEntity.status(HttpStatus.OK).body("Compra modificada");
        
        
    }
    
    @DeleteMapping("/eliminarCompra/{idCompra}")
    public ResponseEntity<String> eliminarCompra( @PathVariable String idCompra){
        
        compraServicio.eliminarCompra(idCompra);
        
        return ResponseEntity.status(HttpStatus.OK).body("Compra eliminada");
        
    }
    
    @GetMapping("/totales")
    public ResponseEntity<Map<String, Map>> getTotalesPorMetodo() {
        
        Map<String, Double> cajaCompra = compraServicio.cajaCompra();
        Map<String, Double> cajaOrden = ordenServicio.cajaOrden();
        
        
        Map<String, Map> totales = new HashMap<>();
        
        totales.put("totalCompra", cajaCompra);
        totales.put("totalOrden", cajaOrden);
        
        
        
        
        return ResponseEntity.ok(totales);
    }
    
}

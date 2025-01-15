/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlVentasStock.pro.repositorios;

import com.controlVentasStock.pro.entidades.Orden;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juliavallejos
 */

@Repository
public interface OrdenRepo extends JpaRepository<Orden, String> {
    
    @Query("SELECT o FROM Orden o WHERE FUNCTION('DATE', o.fecha) = CURRENT_DATE")
    List<Orden> findOrdenesDeHoy();
    
}

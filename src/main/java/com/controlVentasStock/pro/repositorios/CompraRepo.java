/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlVentasStock.pro.repositorios;

import com.controlVentasStock.pro.entidades.Compra;
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
public interface CompraRepo extends JpaRepository<Compra, String> {
    
    @Query("SELECT c FROM Compra c WHERE FUNCTION('DATE', c.fecha) = CURRENT_DATE")
    List<Compra> findComprasDeHoy();
    
}

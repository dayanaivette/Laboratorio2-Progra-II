/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author BetoCalderon
 */
@Data
public class CuentasUsuario extends Usuario {
    private int IdCuentasusuario;
    private double Saldo;
    private int IdUsuario; 
    private int Transaccion;
    private Date fecha;
}

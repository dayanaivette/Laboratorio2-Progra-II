/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BetoCalderon
 */
public class ConexionBD {

    /**
     *
     */
    public Connection con;
    
    public ConexionBD()
    {
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/appbanco","root","root");
        System.out.println("Conectado");
        
    }catch (Exception e)
    {
        System.out.println("Error de Conexion "+ e);
    }
    }
    public Connection RetornarConexion(){   
        return con;   
    }
}

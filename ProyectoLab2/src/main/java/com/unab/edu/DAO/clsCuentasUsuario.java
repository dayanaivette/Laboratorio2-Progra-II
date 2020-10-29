/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.CuentasUsuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class clsCuentasUsuario {
    ConexionBD conec = new ConexionBD();
    Connection con = conec.RetornarConexion();
   
   public ArrayList<CuentasUsuario>MostrarCuentas(CuentasUsuario cuentas) {
    ArrayList<CuentasUsuario> List = new ArrayList<>();
    
    try {
            CallableStatement st = con.prepareCall("call SP_S_CUENTASUSUARIO (?)");
            st.setInt("PIdUsuario", cuentas.getIdUsuario());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CuentasUsuario es = new CuentasUsuario();
                es.setSaldo(rs.getDouble("saldo"));
                es.setTransaccion(rs.getInt("transaccion"));
                es.setFecha(rs.getDate("fecha"));

                List.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return List;
    }
   
    public void AgregarCuentasUsuario(CuentasUsuario cuentas){
        
        try {
            
            CallableStatement consulta = con.prepareCall("call SP_I_CUENTASUSUARIO(?,?,?,?)");
            consulta.setDouble("PSaldo", cuentas.getSaldo());
            consulta.setInt("PidUsuario", cuentas.getIdUsuario());
            consulta.setInt("PTransaccion", cuentas.getTransaccion());
            consulta.setDate("PFecha", new java.sql.Date(cuentas.getFecha().getTime()));
            consulta.executeQuery();
            JOptionPane.showMessageDialog(null, "Inserción realizada con exito");
            con.close();
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }   
}
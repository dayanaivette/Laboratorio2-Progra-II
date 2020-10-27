/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.CuentasUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class clsCuentasUsuario {
     ConexionBD conec = new ConexionBD();
   Connection coon = conec.RetornarConexion();
   
   public ArrayList<CuentasUsuario> MostrarCuentas() throws SQLException {
        ArrayList<CuentasUsuario> ListaCuentasUsuario = new ArrayList<>();{
         
         try {
            CallableStatement Statement = coon.prepareCall("");
            ResultSet resultadodeConsulta = Statement.executeQuery();
            while (resultadodeConsulta.next()) {
                CuentasUsuario cuenta = new CuentasUsuario();
                cuenta.setIdCuentasusuario(resultadodeConsulta.getInt("IdCuentasusuario"));
                cuenta.setSaldo(resultadodeConsulta.getDouble("Saldo"));
                cuenta.setIdUsuario(resultadodeConsulta.getInt("IdUsuario"));
                cuenta.setTransaccion(resultadodeConsulta.getInt("Transaccion"));
                cuenta.setfecha(resultadoDeConsulta);

                ListaCuentasUsuario.add(cuenta);
            }
            coon.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaCuentasUsuario;}
   }
   public void AgregarCuenta(CuentasUsuario cuenta){
       try {
           CallableStatement Statement = coon.prepareCall(" ");
 
           Statement.setInt("uIdCuentasUsuario", cuenta.getIdCuentasusuario());
           Statement.setdouble("uSaldo", cuenta.getSaldo());
           Statement.setInt("uIdUsuario", cuenta.getIdUsuario());
           Statement.setInt("uTransaccion", cuenta.getTransaccion());
           Statement.setDate("uFecha",new java.sql.Date(cuenta.getFecha().getTime()));
         
           
           
           
           

           Statement.execute();
             JOptionPane.showMessageDialog(null,"cuenta Guardada");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}
   public void BorrarPersona(CuentasUsuario cuenta){
       try {
           CallableStatement Statement = coon.prepareCall("(?)");
           
           Statement.setInt("uCuentasUsuario", cuenta.getIdCuentasUsuario);
          Statement.execute();
             JOptionPane.showMessageDialog(null,"Cuenta Eliminada");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);}
            
       }
         public void ActualizarCuenta(CuentasUsuario cuenta){
       try {
           CallableStatement Statement = coon.prepareCall(" ");
 
           Statement.setInt("uIdCuentasUsuario", cuenta.getIdCuentasusuario());
           Statement.setdouble("uSaldo", cuenta.getSaldo());
           Statement.setInt("uIdUsuario", cuenta.getIdUsuario());
           Statement.setInt("uTransaccion", cuenta.getTransaccion());
           Statement.setDate("uFecha",new java.sql.Date(cuenta.getFecha().getTime()));
         
           
           
           
           

           Statement.execute();
             JOptionPane.showMessageDialog(null,"cuenta Guardada");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}


}
   

   
        



   
        
       
   
        
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.TipoUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton
 */
public class clsTipoUsuario {
    
   ConexionBD conec = new ConexionBD();
   Connection coon = conec.RetornarConexion();
   
   public ArrayList<TipoUsuario> MostrarTipo() {
        ArrayList<TipoUsuario> ListaTipo = new ArrayList<>();
        try {
            CallableStatement Statement = coon.prepareCall("");
            ResultSet resultadodeConsulta = Statement.executeQuery();
            while (resultadodeConsulta.next()) {
                TipoUsuario tip = new TipoUsuario();
                tip.setTipoUser(resultadodeConsulta.getString("TipoUsuario"));
                tip.setId(resultadodeConsulta.getInt("Id"));

                ListaTipo.add(tip);
            }
            coon.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaTipo;
    }
   
   public void AgregarTipo(TipoUsuario tip){
       try {
           CallableStatement Statement = coon.prepareCall(" ");
 
           Statement.setInt("uIdUsuario", tip.getId());
           Statement.setString("uUsuario", tip.getTipoUser());


           Statement.execute();
             JOptionPane.showMessageDialog(null,"TipoUsuario Guardado");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}
    public void BorrarTipo(TipoUsuario tip) {
        try {
            CallableStatement Statement = coon.prepareCall("(?)");
            Statement.setInt("uUIdUsuario", tip.getId());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "TipoUsuario Eliminado");
            coon.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void ActualizarTipo(TipoUsuario tip){
       try {
           CallableStatement Statement = coon.prepareCall(" ");
 
           Statement.setInt("uIdUsuario", tip.getId());
           Statement.setString("uUsuario", tip.getTipoUser());


           Statement.execute();
             JOptionPane.showMessageDialog(null,"TipoUsuario Actualizado");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}
}

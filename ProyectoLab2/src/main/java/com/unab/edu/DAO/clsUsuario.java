/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.Usuario;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton
 */
public class clsUsuario {
    ConexionBD conec = new ConexionBD();
     Connection coo = conec.RetornarConexion();

   
   public ArrayList <Usuario> MostrarUsuario(){
    ArrayList <Usuario> ListaUsuario = new ArrayList <>();
        
        try{
            
           CallableStatement stn = coo.prepareCall("Select * from usuario where usuarios ");

            ResultSet resultador = Statement.executeQuery();
                Usuario user = new Usuario();
            while (resultador.next()) {
             
                user.setIdUsuario(resultador.getInt("idUsuario"));
                user.setUsuario(resultador.getString("Usuario"));
                user.setPassWord(resultador.getString("Password"));
                user.setTipoUsuario(resultador.getInt("tipoUsuario"));

                ListaUsuario.add(user);
            }
            coo.close();
            
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        }
      
        
        
        
        
        
        
        
        
        return ListaUsuario;
        
    }
    public void AgregarUsuario(Usuario user, String usuario, String pass, int combo){
       try {
           CallableStatement Statement = coo.prepareCall("Select * from usuario where usuarios ");
 
           Statement.setInt("uIdUsuario", user.getIdUsuario());
           Statement.setString("uUsuario", user.getUsuario());
           Statement.setString("uContraseña", user.getPassWord());
           Statement.setInt("uTipoUsuario", user.getTipoUsuario());

           Statement.execute();
             JOptionPane.showMessageDialog(null,"USuario Guardado");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}
    
    public void BorrarUsuario(Usuario user) {
        try {
            CallableStatement Statement = coo.prepareCall("(?)");
            Statement.setInt("UIdUsuario", user.getIdUsuario());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            coo.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void ActualizarUsuario(Usuario user){
       try {
           
           CallableStatement Statement = coo.prepareCall("");
           Statement.setInt("uIdUsuario", user.getIdUsuario());
           Statement.setString("uUsuario", user.getUsuario());
           Statement.setString("uContraseña", user.getPassWord());
           Statement.setInt("uTipoUsuario", user.getTipoUsuario());

           Statement.execute();
             JOptionPane.showMessageDialog(null,"USuario Actualizado");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
    }
}
    
    
    


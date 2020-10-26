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
     Connection conectar = con.conexion();
    private Object con;
    
    public List<Usuario> ListaUsuario (String usuario, String pass, int combo){
        List<Usuario> ListaUsuario= new ArrayList<>();
        
        try{
            
           CallableStatement stn = conectar.prepareCall("Select * from usuario where usuarios "
                   + "" + usuario +  "'and Password' " + pass "" + "tipo de Usuario" + combo );
            
            
            ResultSet resultador = Statement.executeQuery();
            while (resultador.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultador.getInt("idUsuario"));
                user.setUsuario(resultador.getString("Usuario"));
                user.setPassword(resultador.getString("Password"));
                user.setIdTipo(resultador.getInt("tipoUsuario"));

                ListaUsuario.add(user);
            }
            conectar.close();
            
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        }
      
        
        
        
        
        
        
        
        
        return ListaUsuario;
        
    }
    public void AgregarUsuario(Usuario user){
       try {
           CallableStatement Statement = conectar.prepareCall("call SP_I_(?,?,?,?)");
           Statement.setInt("IdUsuario", user.getIdUSuario());
           Statement.setString("Usuario", user.getUsuario());
           Statement.setString("Contraseña", user.getPassword());
           Statement.setInt("TipoUsuario", user.getTipoUsuario());

           Statement.execute();
             JOptionPane.showMessageDialog(null,"USuario Guardado");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
                   
       }}
    
    
    }
    


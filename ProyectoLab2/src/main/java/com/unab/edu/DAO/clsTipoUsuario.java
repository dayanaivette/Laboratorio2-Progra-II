/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.TipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dayan
 */
   public class clsTipoUsuario {
      ConexionBD conec = new ConexionBD();
        Connection con = conec.RetornarConexion();
    
    public ArrayList<TipoUsuario> MostrarTiposUsuario() {
        ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<>();

        try {
            CallableStatement Statement = con.prepareCall("call SP_S_TIPOUSUARIO()");
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {
                TipoUsuario usuario = new TipoUsuario();
                usuario.setId(resultadoConsulta.getInt("Id"));
                usuario.setTipoUser(resultadoConsulta.getString("TipoUser"));
                
                tipoUsuarios.add(usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tipoUsuarios;
    }  
}
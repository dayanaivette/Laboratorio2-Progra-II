
package com.unab.edu.DAO;

import com.unab.edu.Conexion.ConexionBD;
import com.unab.edu.Entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 
 */
public class clsUsuario {
    ConexionBD conec = new ConexionBD();
     Connection con = conec.RetornarConexion();

   
   public boolean LoguinUsuario(String Usuario, String Password, int Combo) {

        ArrayList<Usuario> ListadoUsuario = new ArrayList<>();
        ArrayList<Usuario> ListaPass = new ArrayList<>();

        try {
            CallableStatement Statement = con.prepareCall("call SP_S_LOGIN(?,?,?)");
            Statement.setString("PUsuario", Usuario);
            Statement.setString("PPass", Password);
            Statement.setInt("PTipoUsuario", Combo);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUsuario(rs.getString("Usuario"));
                user.setPassword(rs.getString("PassWord"));
                user.setIdUsuario(rs.getInt("tipoUsuario"));
                ListadoUsuario.add(user);
            }
            String usuarioBD = null;
            String passwordBD = null;
            for (var iterar : ListadoUsuario) {

                usuarioBD = iterar.getUsuario();
                passwordBD = iterar.getPassword();
            }

            CallableStatement Statement2 = con.prepareCall("call SP_S_CRIPUSUARIO(?)");
            Statement2.setString("PPass", Password);
            ResultSet rs2 = Statement2.executeQuery();
            while (rs2.next()) {
                Usuario user = new Usuario();
                user.setPassword(rs2.getNString("crip"));
                ListaPass.add(user);
            }
            String passcrip = null;
            for (var iterar : ListaPass) {

                passcrip = iterar.getPassword();
                Password = passcrip;
            }
            if (usuarioBD != null && passwordBD != null) {
                if (usuarioBD.equals(Usuario) && passwordBD.equals(Password)) {
                    return true;
                }
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en: " + e);
        }
        return false;
    }

    public ArrayList<Usuario> ListadoUSUARIOS() {
        ArrayList<Usuario> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPassword(rs.getString("PassWord"));
                user.setTipoUsuario(rs.getInt("tipoUsuario"));
                Lista.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

        return Lista;
    }

    public int obtnerId(String Usuario, String Password, int TipoUsuario) {

        int ID = 0;

        try {
            CallableStatement Statement = con.prepareCall("call SP_S_LOGIN(?,?,?)");
            Statement.setString("PUsuario", Usuario);
            Statement.setString("PPass", Password);
            Statement.setInt("PTipoUsuario", TipoUsuario);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {

                ID = rs.getInt("idUsuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

        return ID;
    }
    
    public Usuario Login(Usuario user) {
        Usuario usu = new Usuario();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Login(?,?,?);");
            statement.setString("pUsuario", user.getUsuario());
            statement.setString("pPass", user.getPassword());
            statement.setInt("pTipo", user.getTipoUsuario());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassword(res.getString("PassWord"));
                usu.setTipoUsuario(res.getInt("tipoUsuario"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario" + " Intenete de nuevo"  + e);
        }
        return usu;
    }
}
    
    
    


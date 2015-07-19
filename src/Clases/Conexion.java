/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;


import Formularios.Login;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class Conexion {
        public static String NombreUsuario;
        public static String Contraseña;
        public static String Materia;
        public static String Tipo;
   public static int CodigoUsuario;
   //JERRYOSWALD\\SQLEXPRESS
  public static String url="jdbc:sqlserver://localhost;databaseName=pcb;integratedSecurity=true;";
       //public static String urlWindows = "jdbc:sqlserver://localhost;databaseName=PTC;integratedSecurity=true";
   public Connection cn = null;
   public static int sucursal;
   public static Connection cn2 = null;
  public Statement st = null;
    public Connection conect()
    {
        Connection cn = null;
        try
        {
            
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pcb;integratedSecurity=true;");
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
      public Statement Conectar() 
        {
              
        try
       {
        Connection cn = DriverManager.getConnection(url);   
        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       
       } catch (SQLException i)
       {
           JOptionPane.showMessageDialog(null, i);
       } 
        return st;
        }
        public static void Reiniciar() {
        Login Sesion = new Login();
        Sesion.setVisible(true);
}
        public static PreparedStatement mthPrepararSentenciaSQL(String query) {
        try {
            PreparedStatement Resultado;
            //Para usar la autentificación de Windows:
            cn2 = DriverManager.getConnection(url);
            //Para usar la autentificación de SQL Server:
            //conexion = DriverManager.getConnection(url, prpUsuario, prpContraseña);
            Resultado = cn2.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return Resultado;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
                    public static ResultSet mthObtenerValor(PreparedStatement query) {
        ResultSet resultado = null;
        try {
            resultado = query.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
        public static void mthEjecutarOperacionSM(PreparedStatement query) {
        try {
            query.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        public static void mthEjecutarOperacionCM(PreparedStatement query) {
        try {
            Object [] opciones ={"Aceptar","Cancelar"};
            if (JOptionPane.showOptionDialog(null, "¿Desea realizar la operación?", "AVISO", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION, null, opciones, "Aceptar") == JOptionPane.YES_OPTION) {
                if (query.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "¡Operación exitosa!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
            public static JComboBox mthCargarLista(PreparedStatement query, JComboBox origen) {
        try {
            ResultSet rs = mthObtenerValor(query);
            while (rs.next())
            { 
                origen.addItem(rs.getString(1));
            }
            return origen;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return origen;
        }
    }
}

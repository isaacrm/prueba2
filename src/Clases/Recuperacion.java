/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class Recuperacion {
            public static String NombreUsuario;
   public static int CodigoUsuario;
   public static String url="jdbc:sqlserver://localhost;databaseName=pcb;integratedSecurity=true;";
   public Connection cn = null;
   public static Connection conexion = null;
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
    
        public static void EnviarCorreo(String destino, String mensaje) {
        try {
            Properties Propiedades = new Properties();
            Session Sesión;
            Propiedades.put("mail.smtp.host", "smtp.gmail.com");
            Propiedades.put("mail.smtp.starttls.enable", "true");
            Propiedades.put("mail.smtp.port", 587);
            Propiedades.put("mail.smtp.mail.sender", "izzakku.11@gmail.com");
            Propiedades.put("mail.smtp.password", "20130498");
            Propiedades.put("mail.smtp.user", "izzakku.11@gmail.com");
            Propiedades.put("mail.smtp.auth", "true");
            Sesión = Session.getDefaultInstance(Propiedades);
            MimeMessage message = new MimeMessage(Sesión);
            message.setFrom(new InternetAddress((String) Propiedades.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject("Recuperación de contraseña.");
            message.setText(mensaje);
            Transport Cuenta = Sesión.getTransport("smtp");
            Cuenta.connect((String) Propiedades.get("mail.smtp.user"), (String) Propiedades.get("mail.smtp.password"));
            Cuenta.sendMessage(message, message.getAllRecipients());
            Cuenta.close();
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al enviar el correo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
       public static String Encriptar(String Texto) { 
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Texto.getBytes());
            byte byteData[] = md.digest();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sb.toString();
    }
       


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Laboratorio
 */
public class Validar {
        public static boolean CorreoElectronico(String correo) {
        Pattern Patron = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher Comparar = Patron.matcher(correo);        
        return Comparar.find();
    }
    
    public static boolean NumeroTelefono(String telefono) {
        Pattern Patron = Pattern.compile("^[2^6-7]{1}[0-9]{3}-[0-9]{4}$");
        Matcher Comparar = Patron.matcher(telefono); 
        return Comparar.find();
    }
    
        public static boolean Hora(String hora) {
        Pattern Patron = Pattern.compile("^(d|0[1-9]|0\\d|1[0-2]):([0-5]\\d)$");
        Matcher Comparar = Patron.matcher(hora); 
        return Comparar.find();
    }
}

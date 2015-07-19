/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaac
 */
public class Usuario {
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    int id;
    String nombres;
    String apellidos;
    String nombre_empledo2;
    String identificador;
    String tipo;
    String correo;
    String telefono;
    boolean estado;
    String usuario;
    String contraseña;
    int id_sucursal;
    String llegada;
    String despido;
    String foto;
    String nacimiento;
    String materia;
    boolean gerente;
    int id_sucursal2;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    public int getId_sucursal2() {
        return id_sucursal2;
    }

    public void setId_sucursal2(int id_sucursal2) {
        this.id_sucursal2 = id_sucursal2;
    }

    public String getNombre_empledo2() {
        return nombre_empledo2;
    }

    public void setNombre_empledo2(String nombre_empledo2) {
        this.nombre_empledo2 = nombre_empledo2;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
    

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getDespido() {
        return despido;
    }

    public void setDespido(String despido) {
        this.despido = despido;
    }
    
    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
        public Usuario()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
        public boolean guardarUsuario()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO usuarios(nombres,apellidos, nacimiento,identificador, tipo, correo, telefono, estado_usuario, nick, contraseña, materia) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, nombres);
        cmd.setString(2, apellidos);
        cmd.setString(3, nacimiento);
        cmd.setString(4, identificador);
        cmd.setString(5, tipo);
        cmd.setString(6, correo);
        cmd.setString(7, telefono);
        cmd.setBoolean(8, estado);
        cmd.setString(9, usuario);
        cmd.setString(10, contraseña);
        cmd.setString(11, materia);
        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
//        cmd.close();
//        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }
        public boolean ModificarUsuario()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "UPDATE usuarios SET nombres=?,apellidos=?,nacimiento=?, identificador=?, tipo=?, correo=?, telefono=?, estado_usuario=?, nick=?, contraseña=?, materia=?  WHERE id_usuario=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, nombres);
        cmd.setString(2, apellidos);
        cmd.setString(3, nacimiento);
        cmd.setString(4, identificador);
        cmd.setString(5, tipo);
        cmd.setString(6, correo);
        cmd.setString(7, telefono);
        cmd.setBoolean(8, estado);
        cmd.setString(9, usuario);
        cmd.setString(10, contraseña);
        cmd.setString(11, materia);
        cmd.setInt(12, id);
        
        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
//        cmd.close();
//        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }        
        public boolean EliminarUsuario()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "UPDATE usuarios SET estado_usuario='false' WHERE id_usuario=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setInt(1, id);
        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
//        cmd.close();
//        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }
        public void llenarTabla(JTable tabla)throws Exception{
            int sucursal = Clases.Conexion.sucursal;
        ps=cn.prepareStatement("select id_usuario, nombres,apellidos,CONVERT(VARCHAR(10), nacimiento, 105), identificador, tipo, correo, telefono, estado_usuario, nick, contraseña from usuarios WHERE estado_usuario='true' AND tipo='Maestro/a'");
               // ps.setInt(1, id_sucursal);
        rs=ps.executeQuery();
        rsm=rs.getMetaData();
        ArrayList<Object[]> datos=new ArrayList<>();
        while (rs.next()) {            
            Object[] filas=new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=rs.getObject(i+1);
                
            }
            datos.add(filas);
        }
        dtm=(DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
        }
}

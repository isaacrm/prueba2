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
public class Scores {
            private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    int id_score;
    double score;
    int correctas;
    int incorrectas;
    String fecha;
    String materia;
    int id_usuario;
    String identificador;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getId_score() {
        return id_score;
    }

    public void setId_score(int id_score) {
        this.id_score = id_score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCorrectas() {
        return correctas;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    public int getIncorrectas() {
        return incorrectas;
    }

    public void setIncorrectas(int incorrectas) {
        this.incorrectas = incorrectas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Scores()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
        public boolean GuardarScore()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO score(score,correctas,incorrectas,fecha,materia_score,id_usuario) "
        + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setDouble(1, score);
        cmd.setInt(2, correctas);
        cmd.setInt(3, incorrectas);
        cmd.setString(4, fecha);
        cmd.setString(5, materia);
        cmd.setInt(6, id_usuario);

        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
        cmd.close();
        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }
         public void General(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT id_score,cast((score-(score%.001)) as decimal (18,2)), correctas,incorrectas,CONVERT(VARCHAR(10), fecha, 105), materia_score,id_usuario FROM score WHERE id_usuario=? ORDER BY materia_score");
        ps.setInt(1, Clases.Conexion.CodigoUsuario);
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
        public void TodasporMateria(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT id_score,cast((score-(score%.001)) as decimal (18,2)), correctas,incorrectas,CONVERT(VARCHAR(10), fecha, 105), materia_score,id_usuario FROM score WHERE id_usuario=? AND materia_score=? ORDER BY materia_score");
        ps.setInt(1, Clases.Conexion.CodigoUsuario);
        ps.setString(2, materia);
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
         public void UltimassinMateria(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(id_score),MAX(cast((score-(score%.001)) as decimal (18,2))), MAX(correctas),MAX(incorrectas),MAX(CONVERT(VARCHAR(10), fecha, 105)), MAX(materia_score),MAX(id_usuario) FROM score WHERE id_usuario=? AND materia_score='Lenguaje' UNION ALL "
                + "SELECT MAX(id_score),MAX(cast((score-(score%.001)) as decimal (18,2))), MAX(correctas),MAX(incorrectas),MAX(CONVERT(VARCHAR(10), fecha, 105)), MAX(materia_score),MAX(id_usuario) FROM score WHERE id_usuario=? AND materia_score='Sociales' UNION ALL "
                + "SELECT MAX(id_score),MAX(cast((score-(score%.001)) as decimal (18,2))), MAX(correctas),MAX(incorrectas),MAX(CONVERT(VARCHAR(10), fecha, 105)), MAX(materia_score),MAX(id_usuario) FROM score WHERE id_usuario=? AND materia_score='Matemáticas' UNION ALL "
                + "SELECT MAX(id_score),MAX(cast((score-(score%.001)) as decimal (18,2))), MAX(correctas),MAX(incorrectas),MAX(CONVERT(VARCHAR(10), fecha, 105)), MAX(materia_score),MAX(id_usuario) FROM score WHERE id_usuario=? AND materia_score='Ciencias'");
        ps.setInt(1, Clases.Conexion.CodigoUsuario);
        ps.setInt(2, Clases.Conexion.CodigoUsuario);
        ps.setInt(3, Clases.Conexion.CodigoUsuario);
        ps.setInt(4, Clases.Conexion.CodigoUsuario);
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
       public void UltimasconMateria(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(id_score),MAX(cast((score-(score%.001)) as decimal (18,2))), MAX(correctas),MAX(incorrectas),MAX(CONVERT(VARCHAR(10), fecha, 105)), MAX(materia_score),MAX(id_usuario) FROM score WHERE id_usuario=? AND materia_score=?");
        ps.setInt(1, Clases.Conexion.CodigoUsuario);
        ps.setString(2, materia);
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
        public void AllforAll(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT s.id_score,u.identificador,u.nombres, u.apellidos,cast((s.score-(s.score%.001)) as decimal (18,2)), s.materia_score,s.id_usuario FROM score s, usuarios u WHERE s.id_usuario=u.id_usuario  ORDER BY u.nombres");
//        ps.setInt(1, Clases.Conexion.CodigoUsuario);
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
                public void AllMateyEst(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT s.id_score,u.identificador,u.nombres, u.apellidos,cast((s.score-(s.score%.001)) as decimal (18,2)), s.materia_score,s.id_usuario FROM score s, usuarios u WHERE s.materia_score=? AND u.identificador=? AND s.id_usuario=u.id_usuario  ORDER BY u.nombres");
        ps.setString(1, materia);
         ps.setString(2, identificador);
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
        public void TodosEstMat(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score=? AND  u.identificador=? AND s.id_usuario=u.id_usuario");
        ps.setString(1, materia);
        ps.setString(2, identificador);
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
        public void TodosUltimas(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score='Matemáticas' AND s.id_usuario=u.id_usuario UNION ALL "
                + "SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score='Sociales' AND s.id_usuario=u.id_usuario UNION ALL "
                + "SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score='Lenguaje' AND s.id_usuario=u.id_usuario UNION ALL "
                + "SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score='Ciencias' AND s.id_usuario=u.id_usuario");
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
       public void Aprobados(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE  s.id_usuario=u.id_usuario AND s.materia_score=? AND s.score>5.9 ");
        ps.setString(1, Clases.Conexion.Materia);
//        ps.setString(2, identificador);
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
        public void AprobadosMiMateria(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.materia_score=? AND u.identificador=? AND s.score>5.9 AND s.id_usuario=u.id_usuario  ");
        ps.setString(1, materia);
        ps.setString(2, identificador);
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
               public void Reprobados(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE  s.id_usuario=u.id_usuario AND s.materia_score=? AND s.score<5.9");
        ps.setString(1, Clases.Conexion.Materia);
//        ps.setString(2, identificador);
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
        public void ReprobadosMiMateria(JTable tabla)throws Exception{
        ps=cn.prepareStatement("SELECT MAX(s.id_score),MAX(u.identificador),MAX(u.nombres), MAX(u.apellidos),MAX(cast((s.score-(s.score%.001)) as decimal (18,2))), MAX(s.materia_score),MAX(s.id_usuario) FROM score s, usuarios u WHERE s.id_usuario=u.id_usuario AND s.materia_score=? AND u.identificador=? AND s.score<5.9 ");
        ps.setString(1, Clases.Conexion.Materia);
        ps.setString(2, identificador);
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

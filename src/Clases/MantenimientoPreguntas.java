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
public class MantenimientoPreguntas {
        private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    String pregunta;
    String materia;
    int id_respuesta;
    int id_pregunta;
    String correcta;
    String opcion1;
    String opcion2;
    String opcion3;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }
            public MantenimientoPreguntas()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
            public boolean GuardarPregunta()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO preguntas(pregunta, materia_pregunta, url) "
        + "VALUES(?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, pregunta);
        cmd.setString(2, materia);
        cmd.setString(3, url);
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
        public boolean ModificarPregunta()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "UPDATE preguntas SET pregunta=?, materia_pregunta=?, url=? WHERE id_pregunta=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, pregunta);
        cmd.setString(2, materia);
        cmd.setString(3, url);
        cmd.setInt(4, id_pregunta);
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
        public boolean EliminarPregunta()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "DELETE FROM preguntas WHERE id_pregunta=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setInt(1, id_pregunta);
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
        
        public boolean GuardarRespuestas()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO respuestas(correcta,opcion1, opcion2,opcion3, id_pregunta) "
        + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, correcta);
        cmd.setString(2, opcion1);
        cmd.setString(3, opcion2);
        cmd.setString(4, opcion3);
        cmd.setInt(5, id_pregunta);
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
        public boolean ModificarRespuestas()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "UPDATE respuestas SET correcta=?, opcion1=?, opcion2=?, opcion3=?, id_pregunta=? WHERE id_pregunta=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, correcta);
        cmd.setString(2, opcion1);
        cmd.setString(3, opcion2);
        cmd.setString(4, opcion3);
        cmd.setInt(5, id_pregunta);
        cmd.setInt(6, id_pregunta);
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
        public boolean EliminarRespuestas()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "DELETE FROM respuestas WHERE id_pregunta=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setInt(1, id_pregunta);
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
        ps=cn.prepareStatement("select p.id_pregunta,p.pregunta, p.materia_pregunta,p.url, r.correcta, r.opcion1, r.opcion2,r.opcion3 from preguntas p, respuestas r where p.id_pregunta=r.id_pregunta AND materia_pregunta=? ORDER BY id_pregunta");
        ps.setString(1, Clases.Conexion.Materia);
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

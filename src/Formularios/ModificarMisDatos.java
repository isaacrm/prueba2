/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;
import Clases.Conexion;
import Clases.Recuperacion;
import Clases.Usuario;
import Clases.Validar;
import com.sun.awt.AWTUtilities;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 *
 * @author Isaac
 */
public class ModificarMisDatos extends javax.swing.JDialog {

    /**
     * Creates new form NuevoMaestro
     */
        private PreparedStatement SentenciaSQL; 
    public ModificarMisDatos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
                setLocationRelativeTo(null);
                setResizable(false);
        ckbActivo.setSelected(true);
        ckbActivo.setVisible(false);
        getContentPane().setBackground(new java.awt.Color(203,203,203));
//        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width, this.getBounds().height,27,27);
//        AWTUtilities.setWindowShape(this, forma);
                //                //Se estable el calendario para que muestre fechas no menores a 18 años de edad.
        GregorianCalendar fechaMaxima = new GregorianCalendar((Calendar.getInstance().get(Calendar.YEAR))-17,(Calendar.getInstance().get(Calendar.MONTH))-12,(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        nac.setMaxSelectableDate(fechaMaxima.getTime());
////        //Se estable el calendario para que muestre fechas no mayores a 60 años de edad.
        GregorianCalendar fechaMinima = new GregorianCalendar((Calendar.getInstance().get(Calendar.YEAR))-59,(Calendar.getInstance().get(Calendar.MONTH))-12,(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        nac.setMinSelectableDate(fechaMinima.getTime());
        nac.getDateEditor().setEnabled(false);
    }

        public void cargar()
        {
        try {
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT nombres,apellidos,CONVERT(VARCHAR(10), nacimiento, 105), identificador, tipo, correo, telefono,estado_usuario,nick, materia FROM usuarios  WHERE id_usuario = ?" );
            SentenciaSQL.setInt(1, Conexion.CodigoUsuario);
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            txtnombre.setText(rs.getString(1));
            txtApellidos.setText(rs.getString(2));
            SimpleDateFormat Formateador = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaTarea = Formateador.parse(rs.getString(3));
            nac.setDate(fechaTarea);
            txtDui.setText(rs.getString(4));
            cmbTipo.setSelectedItem(rs.getString(5));
            txtCorreo.setText(rs.getString(6));
            txtTelefono.setText(rs.getString(7));
            txtusuario.setText(rs.getString(9));
            cmbTipo1.setSelectedItem(rs.getString(10));
            txtcontraseña.setText(Clases.Conexion.Contraseña);
            confirmar.setText(Clases.Conexion.Contraseña);
        } catch (SQLException ex) {
            Logger.getLogger(ModificarMisDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ModificarMisDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtusuario = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        seis = new javax.swing.JLabel();
        siete = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        ocho = new javax.swing.JLabel();
        confirmar = new javax.swing.JPasswordField();
        dos = new javax.swing.JLabel();
        txtDui = new javax.swing.JFormattedTextField();
        tres = new javax.swing.JLabel();
        cuatro = new javax.swing.JLabel();
        cinco = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        ckbActivo = new javax.swing.JCheckBox();
        nac = new com.toedter.calendar.JDateChooser();
        UsuarioE1 = new javax.swing.JLabel();
        uno1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        tres1 = new javax.swing.JLabel();
        cmbTipo1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MODIFICAR MIS DATOS");

        titulo.setBackground(new java.awt.Color(102, 102, 102));
        titulo.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 102, 102));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Modificar mis datos");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jPanel1.setOpaque(false);

        seis.setForeground(new java.awt.Color(255, 255, 255));
        seis.setText("Mi Username");

        siete.setForeground(new java.awt.Color(255, 255, 255));
        siete.setText("Mi Contraseña");

        uno.setForeground(new java.awt.Color(255, 255, 255));
        uno.setText("Nombres");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(255, 204, 51));
        btnAceptar.setText("MODIFICAR");
        btnAceptar.setBorder(null);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        ocho.setForeground(new java.awt.Color(255, 255, 255));
        ocho.setText("Confirmar Contraseña");

        dos.setForeground(new java.awt.Color(255, 255, 255));
        dos.setText("DUI");

        try {
            txtDui.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tres.setForeground(new java.awt.Color(255, 255, 255));
        tres.setText("Tipo de Usuario");

        cuatro.setForeground(new java.awt.Color(255, 255, 255));
        cuatro.setText("Mi Correo");

        cinco.setForeground(new java.awt.Color(255, 255, 255));
        cinco.setText("Mi Teléfono");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Maestro/a" }));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ckbActivo.setText("Activo");

        nac.setDateFormatString("dd-MM-yyyy");

        UsuarioE1.setForeground(new java.awt.Color(255, 255, 255));
        UsuarioE1.setText("Fecha de Nacimiento");

        uno1.setForeground(new java.awt.Color(255, 255, 255));
        uno1.setText("Apellidos");

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        tres1.setForeground(new java.awt.Color(255, 255, 255));
        tres1.setText("Mi Materia");

        cmbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ciencias", "Lenguaje", "Matemáticas", "Sociales" }));
        cmbTipo1.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(ckbActivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioE1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cinco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(siete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ocho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tres1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cuatro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtcontraseña, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDui, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmar))))
                .addGap(163, 163, 163))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uno)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uno1)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsuarioE1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dos)
                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tres)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuatro)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinco)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tres1)
                    .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seis)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siete)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ocho)
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titulo)
                    .addContainerGap(531, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c;
        c=evt.getKeyChar();
        if(!(c<'0'||c>'9')) evt.consume();
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Calendar cale = GregorianCalendar.getInstance();
        GregorianCalendar hoy= new GregorianCalendar();
        if("".equals(txtnombre.getText()) || "".equals(txtDui.getText()) || cmbTipo.getSelectedIndex()<0   || ckbActivo.isSelected()==false || "".equals(txtusuario.getText()) || "".equals(txtcontraseña.getText())||nac.getDate()==null)
        {
            JOptionPane.showMessageDialog(this, "No puede dejar campos vacíos","WARNING", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtusuario.getText().length()<5 || txtusuario.getText().length()>10 || txtcontraseña.getText().length()<4 || txtcontraseña.getText().length()>8)
        {
            JOptionPane.showMessageDialog(this, "El nombre de usuario debe tener entre 5 y 10 carácteres \nLa contraseña debe tener entre 4 y 8 carácteres","", JOptionPane.ERROR_MESSAGE);
        }
        else if (!Validar.CorreoElectronico(txtCorreo.getText()))
        {
            JOptionPane.showMessageDialog(this, "Formato de correo inválido. Verifiquelo.", "WARNING", JOptionPane.ERROR_MESSAGE);
            txtCorreo.setText("");
        }
        else if (!Validar.NumeroTelefono(txtTelefono.getText()))
        {
            JOptionPane.showMessageDialog(this, "Número de teléfono no válido. \nComience con 2,6 o 7", "WARNING", JOptionPane.ERROR_MESSAGE);
        }
        else if (!txtcontraseña.getText().equals(confirmar.getText()))
        {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "WARNING", JOptionPane.ERROR_MESSAGE);
            txtcontraseña.setText(null);
            confirmar.setText(null);
        }
        else  if (JOptionPane.showConfirmDialog(null, "¿Desea realizar la operacón?" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            Usuario obj = new Usuario();
            String Fecha= new SimpleDateFormat("yyyy-MM-dd").format(nac.getDate());
            obj.setNacimiento(Fecha);
            obj.setNombres(txtnombre.getText());
            obj.setApellidos(txtApellidos.getText());
            obj.setIdentificador(txtDui.getText());
            obj.setTipo(cmbTipo.getSelectedItem().toString());
            obj.setCorreo(txtCorreo.getText());
            obj.setTelefono(txtTelefono.getText());
            obj.setEstado(ckbActivo.isSelected());
            obj.setUsuario(txtusuario.getText());
            obj.setContraseña(Recuperacion.Encriptar(txtcontraseña.getText()));
            obj.setMateria(cmbTipo1.getSelectedItem().toString());
            obj.setId(Clases.Conexion.CodigoUsuario);
            if(obj.ModificarUsuario())
            {
                Clases.Conexion.Materia=cmbTipo1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(this, "Datos Modificados");
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error inesperado");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Codigo para ejecutar el look and feel
        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
            setDefaultLookAndFeelDecorated(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en Look and Feel", "ERROR"+ e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarMisDatos dialog = new ModificarMisDatos(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsuarioE1;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel cinco;
    private javax.swing.JCheckBox ckbActivo;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbTipo1;
    private javax.swing.JPasswordField confirmar;
    private javax.swing.JLabel cuatro;
    private javax.swing.JLabel dos;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser nac;
    private javax.swing.JLabel ocho;
    private javax.swing.JLabel seis;
    private javax.swing.JLabel siete;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tres;
    private javax.swing.JLabel tres1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtDui;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JLabel uno;
    private javax.swing.JLabel uno1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;
import Clases.Conexion;
import Clases.MantenimientoPreguntas;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Isaac
 */
public class Mant_Preguntas extends javax.swing.JDialog {

    /**
     * Creates new form Mant_Preguntas
     */    private PreparedStatement SentenciaSQL; 
                  int maximo;
    public Mant_Preguntas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
                getContentPane().setBackground(new java.awt.Color(203,203,203));
                        FileFilter FiltroImagenes = new FileNameExtensionFilter("Imágenes","png", "jpg", "jpeg");
        fcsAbrir.setFileFilter(FiltroImagenes);
        tabla.getTableHeader().setReorderingAllowed(false); 
    }
    public void Limpiar(){
        pregunta.setText(null);
        correcta.setText(null);
        opcion1.setText(null);
        opcion2.setText(null);
        opcion3.setText(null);
        lblPicture.setIcon(null);
                     btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnConsultar.setEnabled(true);
            btnEliminar.setEnabled(false);
            btnLimpiar.setEnabled(false);
    }
    public void LimpiarTabla(){
                try 
            {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
            }
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla");
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fcsAbrir = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        materia = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        btnExplorar = new javax.swing.JButton();
        opcion3 = new javax.swing.JTextField();
        opcion2 = new javax.swing.JTextField();
        opcion1 = new javax.swing.JTextField();
        correcta = new javax.swing.JTextField();
        pregunta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jLabel5.setText("Opcion Incorrecta 1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO DE PREGUNTAS");
        setBackground(new java.awt.Color(203, 203, 203));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Preguntas"));
        jPanel2.setOpaque(false);

        materia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ciencias", "Lenguaje", "Matemáticas", "Sociales" }));
        materia.setSelectedIndex(-1);
        materia.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        lblPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExplorar.setBackground(new java.awt.Color(43, 215, 233));
        btnExplorar.setText("Explorar");
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExplorar)
                        .addGap(119, 119, 119))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExplorar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Pregunta");

        jLabel2.setText("Respuesta Correcta");

        jLabel3.setText("Opcion Incorrecta 1");

        jLabel4.setText("Opcion Incorrecta 2");

        jLabel6.setText("Opcion Incorrecta 3");

        jLabel7.setText("Materia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(opcion1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(opcion2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcion3, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(materia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pregunta)
                            .addComponent(correcta))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(correcta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(opcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(opcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(opcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        id.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        jPanel3.setOpaque(false);

        btnAgregar.setBackground(new java.awt.Color(51, 51, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 153, 102));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(0, 204, 102));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 102, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pregunta", "Materia", "Url", "Respuesta Correcta", "Incorrecta 1", "Incorrecta 2", "Incorrecta 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(2).setMinWidth(0);
            tabla.getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnConsultar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(id)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(pregunta.getText().equals("")|| correcta.getText().equals("")||opcion1.getText().equals("")|| opcion2.getText().equals("")|| opcion3.getText().equals("")|| materia.getSelectedIndex()<1)
        {
         JOptionPane.showMessageDialog(this, "No puede dejar campos vacíos","WARNING/ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
        else if (correcta.getText()==opcion1.getText() ||correcta.getText()==opcion2.getText()||correcta.getText()==opcion3.getText()||opcion1.getText()==opcion2.getText()||opcion1.getText()==opcion3.getText()||opcion2.getText()==opcion3.getText())
        {
         JOptionPane.showMessageDialog(this, "No puede repetir datos","WARNING/ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
        else  if (JOptionPane.showConfirmDialog(null, "¿Desea realizar la operación?" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            String url = "\\no_disponible.png";
            MantenimientoPreguntas obj = new MantenimientoPreguntas();
            obj.setPregunta(pregunta.getText());
            obj.setMateria(materia.getSelectedItem().toString());
            obj.setUrl(url);
            obj.setCorrecta(correcta.getText());
            obj.setOpcion1(opcion1.getText());
            obj.setOpcion2(opcion2.getText());
            obj.setOpcion3(opcion3.getText());
            if(obj.GuardarPregunta())
            {
                try {
                    SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT MAX(id_pregunta) FROM preguntas");
                    ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
                    rs.last();
                    obj.setId_pregunta(rs.getInt(1));
                    obj.GuardarRespuestas();
                    if (lblPicture.getIcon() != null)
                    {
                        String destino = (new File("Imagenes")).getAbsolutePath() + "\\" + materia.getSelectedItem().toString()+"_"+ rs.getString(1) + ".png";
                        ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                        BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                        try {
                            File ImagenDestino = new File(destino);
                            ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                        }
                        catch (IOException e) { } {
                        url = "\\" + materia.getSelectedItem().toString()+"_"+ rs.getString(1) + ".png";
                        SentenciaSQL = Conexion.mthPrepararSentenciaSQL("UPDATE preguntas SET url=? WHERE id_pregunta=? ");
                        SentenciaSQL.setString(1, url);
                        SentenciaSQL.setInt(2, rs.getInt(1));
                        Conexion.mthEjecutarOperacionSM(SentenciaSQL);
                    }
                    }
                    JOptionPane.showMessageDialog(this, "Datos Guardados");
                    Limpiar();
                } catch (SQLException ex) {
                    Logger.getLogger(Mant_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Verifique la pregunta. Esta pregunta existir");
                    }
         
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
            btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnConsultar.setEnabled(true);
            btnEliminar.setEnabled(false);
            btnLimpiar.setEnabled(false);
             materia.setSelectedItem(Clases.Conexion.Materia);
             SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT MAX(id_pregunta) FROM preguntas");
             ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
             rs.last();
             if (rs.getRow()==0)
             {
                 maximo=0+1;
             }
             else
             {
                 maximo= rs.getInt(1)+1;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Mant_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_formWindowOpened

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplorarActionPerformed
        int ArchivoAbierto;
        ArchivoAbierto = fcsAbrir.showOpenDialog(this);
        if (ArchivoAbierto == JFileChooser.APPROVE_OPTION) {
            File ArchivoSeleccionado = fcsAbrir.getSelectedFile();
            String ruta = ArchivoSeleccionado.getAbsolutePath();
            BufferedImage Imagen = null;
            try {
                Imagen = ImageIO.read(new File(ruta));
            }
            catch (IOException e) {
           }
            Image ImagenRedimensionada;
            ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);
            lblPicture.setIcon(ImagenFinal);

        }
        else {
           // lblPicture.setIcon(null);
        }
    }//GEN-LAST:event_btnExplorarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
        LimpiarTabla();
             btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnConsultar.setEnabled(true);
            btnEliminar.setEnabled(false);
            btnLimpiar.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(pregunta.getText().equals("")|| correcta.getText().equals("")||opcion1.getText().equals("")|| opcion2.getText().equals("")|| opcion3.getText().equals("")|| materia.getSelectedIndex()<1)
        {
         JOptionPane.showMessageDialog(this, "No puede dejar campos vacíos","WARNING/ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
        else if (correcta.getText()==opcion1.getText() ||correcta.getText()==opcion2.getText()||correcta.getText()==opcion3.getText()||opcion1.getText()==opcion2.getText()||opcion1.getText()==opcion3.getText()||opcion2.getText()==opcion3.getText())
        {
         JOptionPane.showMessageDialog(this, "No puede repetir datos","WARNING/ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
        else  if (JOptionPane.showConfirmDialog(null, "¿Desea realizar la operación?" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            String url = "\\no_disponible.png";
            MantenimientoPreguntas obj = new MantenimientoPreguntas();
            obj.setPregunta(pregunta.getText());
            obj.setMateria(materia.getSelectedItem().toString());
            obj.setUrl(url);
            obj.setCorrecta(correcta.getText());
            obj.setOpcion1(opcion1.getText());
            obj.setOpcion2(opcion2.getText());
            obj.setOpcion3(opcion3.getText());
            if(obj.ModificarPregunta())
            {
                try {
                    obj.setId_pregunta(Integer.parseInt(id.getText()));
                    obj.ModificarRespuestas();
                    if (lblPicture.getIcon() != null)
                    {
                        String destino = (new File("Imagenes")).getAbsolutePath() + "\\" + materia.getSelectedItem().toString()+"_"+ Integer.parseInt(id.getText()) + ".png";
                        ImageIcon ImagenLabel = (ImageIcon) lblPicture.getIcon();
                        BufferedImage Imagen_en_buffer = new BufferedImage(ImagenLabel.getIconWidth(), ImagenLabel.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        ImagenLabel.paintIcon(null, Imagen_en_buffer.getGraphics(), 0, 0);
                        try {
                            File ImagenDestino = new File(destino);
                            ImageIO.write(Imagen_en_buffer, "png", ImagenDestino);
                        }
                        catch (IOException e) { } {
                        url = "\\" + materia.getSelectedItem().toString()+"_"+ Integer.parseInt(id.getText()) + ".png";
                        SentenciaSQL = Conexion.mthPrepararSentenciaSQL("UPDATE preguntas SET url=? WHERE id_pregunta=? ");
                        SentenciaSQL.setString(1, url);
                        SentenciaSQL.setInt(2, Integer.parseInt(id.getText()));
                        Conexion.mthEjecutarOperacionSM(SentenciaSQL);
                    }
                    }
                    JOptionPane.showMessageDialog(this, "Datos Modificados");
                    Limpiar();
                    LimpiarTabla();
                } catch (SQLException ex) {
                    Logger.getLogger(Mant_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Verifique la pregunta. Esta pregunta existir");
                    }
           
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 if (JOptionPane.showConfirmDialog(null, "¿Desea realizar la operación?" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
       {
        MantenimientoPreguntas obj = new  MantenimientoPreguntas();
        int ide= Integer.parseInt(id.getText());
        obj.setId_pregunta(ide);
        if(obj.EliminarRespuestas())
        {
            obj.EliminarPregunta();
            JOptionPane.showMessageDialog(this, "Datos Eliminados");
            Limpiar();
            LimpiarTabla();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error al eliminar");
            Limpiar();
            LimpiarTabla();
        }
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnConsultar.setEnabled(false);
        btnLimpiar.setEnabled(true);
        Clases.MantenimientoPreguntas f=new Clases.MantenimientoPreguntas();
        try {
            f.llenarTabla(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
            id.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            pregunta.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            materia.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            correcta.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            opcion1.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
            opcion2.setText(tabla.getValueAt(tabla.getSelectedRow(), 6).toString());
            opcion3.setText(tabla.getValueAt(tabla.getSelectedRow(), 7).toString());
                        String Ubicacion = (new File("Imagenes")).getAbsolutePath() + "\\" + tabla.getValueAt(tabla.getSelectedRow(), 3);
            BufferedImage Imagen = null;
            try {
                Imagen = ImageIO.read(new File(Ubicacion));
                Image ImagenRedimensionada;
                ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);
                lblPicture.setIcon(ImagenFinal);
            }
            catch (IOException e) {
                try {
                    JOptionPane.showMessageDialog(null, "Error al cargar la imagen. Considere modificarla", "AVISO/WARNING", JOptionPane.ERROR_MESSAGE);
                    Ubicacion = (new File("Imagenes")).getAbsolutePath() + "\\error.png";
                    Imagen = ImageIO.read(new File(Ubicacion));
                    Image ImagenRedimensionada;
                    ImagenRedimensionada = Imagen.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon ImagenFinal = new ImageIcon(ImagenRedimensionada);
                    lblPicture.setIcon(ImagenFinal);
                }
                catch (IOException a) {
                    lblPicture.setIcon(null);
                }
            }
    }//GEN-LAST:event_tablaMouseClicked

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
                Mant_Preguntas dialog = new Mant_Preguntas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField correcta;
    private javax.swing.JFileChooser fcsAbrir;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JComboBox materia;
    private javax.swing.JTextField opcion1;
    private javax.swing.JTextField opcion2;
    private javax.swing.JTextField opcion3;
    private javax.swing.JTextField pregunta;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

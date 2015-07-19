/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;
import Clases.Conexion;
import Clases.Scores;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Isaac
 */
public class Juego extends javax.swing.JDialog {

    /**
     * Creates new form Juego
     */
    int contador=0;
    double nota=0.0;
    int correctas=0;
    int incorrectas=0;
    PreparedStatement SentenciaSQL;
    PreparedStatement SentenciaSQL1;
    public Juego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        //Código que llama al fondo de pantalla
        fondo2 pnlFondo2 = new fondo2();
        this.add(pnlFondo2, BorderLayout.CENTER);
        cmb.setVisible(false);

    }

       //Aqui se especifica el numero de pregunta que se va a tomar
    public void preguntas()
        {
        try {
            contador=contador+1;
            if (cmb.getSelectedIndex()==24)
            {
             JOptionPane.showMessageDialog(this, "Incorrectas: " +incorrectas +  "\nCorrectas "+ correctas +"\nNota: "+ Math.rint(nota*100)/100 );
             Scores obj = new Scores();
            Calendar calendario = GregorianCalendar.getInstance();
            Date fechas = calendario.getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha= formatoDeFecha.format(fechas);
             obj.setFecha(fecha);
             obj.setScore(nota);
             obj.setCorrectas(correctas);
             obj.setIncorrectas(incorrectas);
             obj.setMateria(Clases.Conexion.Materia);
             obj.setId_usuario(Clases.Conexion.CodigoUsuario);
             obj.GuardarScore();
             JOptionPane.showMessageDialog(this, "Su puntaje ha sido guardado");
             Pregunta.setText(null);
            lblPicture.setIcon(null);
            OpcionA.setText(null);
            OpcionB.setText(null);
            OpcionC.setText(null);
            OpcionD.setText(null);
            Comenzar.setEnabled(true);
            contador=0;
            nota=0.0;
            correctas=0;
            incorrectas=0;
            OpcionA.setEnabled(false);
            OpcionB.setEnabled(false);
            OpcionC.setEnabled(false);
            OpcionD.setEnabled(false);
            int itemCount = cmb.getItemCount();
            for(int i=0;i<itemCount;i++){
                cmb.removeItemAt(0);
            }
            }
            else
           {
            cmb.setSelectedIndex(contador-1);
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT pregunta,url FROM preguntas WHERE id_pregunta=? AND materia_pregunta=?");
            SentenciaSQL.setInt(1, Integer.parseInt(cmb.getSelectedItem().toString()));
            SentenciaSQL.setString(2, Clases.Conexion.Materia);
            ResultSet rs= Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            Pregunta.setText(contador +". "+ rs.getString(1));
            String Ubicacion = (new File("Imagenes")).getAbsolutePath() + "\\" + rs.getString(2);
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
                        }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    //Luego aquí se generaran las opciones de respuesta correctas de manera aleatoria, y como ya se tiene el item seleccionado, solo se le hara referencia (setSelectedItem)
        public void GenerarRespuestas() {
        try {
            int numeroAleatorio = (int) (Math.random()*4+1);
            int opciones = (int) (Math.random()*6+1);
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT correcta FROM respuestas  WHERE id_pregunta = ?" );
            SentenciaSQL.setInt(1, Integer.parseInt(cmb.getSelectedItem().toString()));
            SentenciaSQL1 = Conexion.mthPrepararSentenciaSQL("SELECT opcion1, opcion2, opcion3 FROM respuestas  WHERE id_pregunta = ?" );
            SentenciaSQL1.setInt(1, Integer.parseInt(cmb.getSelectedItem().toString()));
            ResultSet rs1 = Conexion.mthObtenerValor(SentenciaSQL1);
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs1.last();
            rs.last();
            switch (numeroAleatorio)//switch para alternar opciones correctas
            {
                case 1:
                    OpcionA.setText(rs.getString(1));
          switch (opciones) //Switch para alternar opciones incorrectas
            {
                case 1:
                    OpcionB.setText(rs1.getString(1));
                    OpcionC.setText( rs1.getString(2));
                    OpcionD.setText( rs1.getString(3));
                    break;
                case 2:
                    OpcionB.setText(rs1.getString(1));
                    OpcionC.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(2));
                    break;
                case 3:
                    OpcionB.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(3));
                    break;
                case 4:
                    OpcionB.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 5:
                    OpcionB.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(2));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 6:
                    OpcionB.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(2));
                    break;
            }
                    break;
                case 2:
                    OpcionB.setText(rs.getString(1));
          switch (opciones) //Switch para alternar opciones incorrectas
            {
                case 1:
                    OpcionA.setText(rs1.getString(1));
                    OpcionC.setText(rs1.getString(2));
                    OpcionD.setText(rs1.getString(3));
                    break;
                case 2:
                    OpcionA.setText(rs1.getString(1));
                    OpcionC.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(2));
                    break;
                case 3:
                    OpcionA.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(3));
                    break;
                case 4:
                    OpcionA.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 5:
                    OpcionA.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(2));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 6:
                    OpcionA.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(2));
                    break;
            }
                    break;
                case 3:
                    OpcionC.setText(rs.getString(1));
          switch (opciones) //Switch para alternar opciones incorrectas
            {
                case 1:
                    OpcionB.setText(rs1.getString(1));
                    OpcionA.setText(rs1.getString(2));
                    OpcionD.setText(rs1.getString(3));
                    break;
                case 2:
                    OpcionB.setText(rs1.getString(1));
                    OpcionA.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(2));
                    break;
                case 3:
                    OpcionB.setText(rs1.getString(2));
                    OpcionA.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(3));
                    break;
                case 4:
                    OpcionB.setText(rs1.getString(2));
                    OpcionA.setText(rs1.getString(3));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 5:
                    OpcionB.setText(rs1.getString(3));
                    OpcionA.setText(rs1.getString(2));
                    OpcionD.setText(rs1.getString(1));
                    break;
                case 6:
                    OpcionB.setText(rs1.getString(3));
                    OpcionA.setText(rs1.getString(1));
                    OpcionD.setText(rs1.getString(2));
                    break;
            }
                    break;
                case 4:
                    OpcionD.setText(rs.getString(1));
          switch (opciones) //Switch para alternar opciones incorrectas
            {
                case 1:
                    OpcionB.setText(rs1.getString(1));
                    OpcionC.setText(rs1.getString(2));
                    OpcionA.setText(rs1.getString(3));
                    break;
                case 2:
                    OpcionB.setText(rs1.getString(1));
                    OpcionC.setText(rs1.getString(3));
                    OpcionA.setText(rs1.getString(2));
                    break;
                case 3:
                    OpcionB.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(1));
                    OpcionA.setText(rs1.getString(3));
                    break;
                case 4:
                    OpcionB.setText(rs1.getString(2));
                    OpcionC.setText(rs1.getString(3));
                    OpcionA.setText(rs1.getString(1));
                    break;
                case 5:
                    OpcionB.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(2));
                    OpcionA.setText(rs1.getString(1));
                    break;
                case 6:
                    OpcionB.setText(rs1.getString(3));
                    OpcionC.setText(rs1.getString(1));
                    OpcionA.setText(rs1.getString(2));
                    break;
            }
                    break;
            }  
            } catch (SQLException ex) {
            //Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Comenzar = new javax.swing.JButton();
        Contenedor = new javax.swing.JPanel();
        OpcionA = new javax.swing.JButton();
        OpcionB = new javax.swing.JButton();
        OpcionC = new javax.swing.JButton();
        OpcionD = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb = new javax.swing.JComboBox();
        Reiniciar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pregunta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUIEN QUIERE PASAR LA PAES");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JUEGOpng.png"))); // NOI18N

        Comenzar.setBackground(new java.awt.Color(0, 204, 102));
        Comenzar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Comenzar.setForeground(new java.awt.Color(255, 255, 255));
        Comenzar.setText("COMENZAR");
        Comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComenzarActionPerformed(evt);
            }
        });

        Contenedor.setBackground(new java.awt.Color(0, 0, 0));
        Contenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OpcionA.setBackground(new java.awt.Color(0, 51, 204));
        OpcionA.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        OpcionA.setForeground(new java.awt.Color(0, 255, 255));
        OpcionA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OpcionA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        OpcionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionAActionPerformed(evt);
            }
        });

        OpcionB.setBackground(new java.awt.Color(0, 51, 204));
        OpcionB.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        OpcionB.setForeground(new java.awt.Color(0, 255, 255));
        OpcionB.setText(" ");
        OpcionB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OpcionB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        OpcionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionBActionPerformed(evt);
            }
        });

        OpcionC.setBackground(new java.awt.Color(0, 51, 204));
        OpcionC.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        OpcionC.setForeground(new java.awt.Color(0, 255, 255));
        OpcionC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OpcionC.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        OpcionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionCActionPerformed(evt);
            }
        });

        OpcionD.setBackground(new java.awt.Color(0, 51, 204));
        OpcionD.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        OpcionD.setForeground(new java.awt.Color(0, 255, 255));
        OpcionD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OpcionD.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        OpcionD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("a)");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("b)");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("c)");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("d)");

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OpcionD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpcionC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpcionB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpcionA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OpcionA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OpcionB, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OpcionC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OpcionD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        Reiniciar.setBackground(new java.awt.Color(255, 51, 51));
        Reiniciar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Reiniciar.setForeground(new java.awt.Color(255, 255, 255));
        Reiniciar.setText("REINICIAR");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        lblPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IMÁGENES ANEXAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
        );

        Pregunta.setEditable(false);
        Pregunta.setBackground(new java.awt.Color(0, 0, 0));
        Pregunta.setColumns(20);
        Pregunta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Pregunta.setForeground(new java.awt.Color(255, 204, 0));
        Pregunta.setLineWrap(true);
        Pregunta.setRows(5);
        Pregunta.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Pregunta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Comenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Comenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComenzarActionPerformed
        try {
            Comenzar.setEnabled(false);
                   OpcionA.setEnabled(true);
                OpcionB.setEnabled(true);
                OpcionC.setEnabled(true);
                OpcionD.setEnabled(true);
            int itemCount = cmb.getItemCount();
            for(int i=0;i<itemCount;i++){
                cmb.removeItemAt(0);
            }
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT TOP 25 id_pregunta FROM preguntas WHERE materia_pregunta=? ORDER BY NEWID()");
            SentenciaSQL.setString(1, Clases.Conexion.Materia);
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            int datos= rs.getRow();
            if (datos==0 )
            {
                JOptionPane.showMessageDialog(null, "No hay preguntas de esta materia. \nNotifique a los profesores", "ERROR", JOptionPane.ERROR_MESSAGE);
                           OpcionA.setEnabled(false);
       OpcionB.setEnabled(false);
       OpcionC.setEnabled(false);
       OpcionD.setEnabled(false);
       Comenzar.setEnabled(true);
            }
            else if(datos<25)
            {
                JOptionPane.showMessageDialog(null, "No hay suficientes preguntas de esta materia. \nNotifique a los profesores", "ERROR", JOptionPane.ERROR_MESSAGE);
                           OpcionA.setEnabled(false);
       OpcionB.setEnabled(false);
       OpcionC.setEnabled(false);
       OpcionD.setEnabled(false);
       Comenzar.setEnabled(true);
            }
            else
            {
            cmb = Conexion.mthCargarLista(SentenciaSQL, cmb);
            cmb.setSelectedIndex(-1);
            preguntas();
            GenerarRespuestas();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComenzarActionPerformed

    private void OpcionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionAActionPerformed
        try {
        if (JOptionPane.showConfirmDialog(null, "<html><h2><FONT FACE='comis sans ms'>¿Respuesta definitiva?</font></h2></html>" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT correcta FROM respuestas WHERE id_pregunta = ?" );
            SentenciaSQL.setInt(1,Integer.parseInt(cmb.getSelectedItem().toString()));
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            if(OpcionA.getText().equals(rs.getString(1)))
            {
            correctas= correctas+1;
            nota= nota+0.4;
            preguntas();
            GenerarRespuestas();
            }
            else
            {
            incorrectas= incorrectas+1;
            preguntas();
            GenerarRespuestas();
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpcionAActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        Pregunta.setText(null);
        lblPicture.setIcon(null);
        OpcionA.setText(null);
        OpcionB.setText(null);
        OpcionC.setText(null);
        OpcionD.setText(null);
        Comenzar.setEnabled(true);
        contador=0;
        nota=0.0;
        correctas=0;
        incorrectas=0;
               OpcionA.setEnabled(false);
       OpcionB.setEnabled(false);
       OpcionC.setEnabled(false);
       OpcionD.setEnabled(false);
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void OpcionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionBActionPerformed
        try {
                    if (JOptionPane.showConfirmDialog(null, "<html><h2><FONT FACE='comis sans ms'>¿Respuesta definitiva?</font></h2></html>" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT correcta FROM respuestas WHERE id_pregunta = ?" );
            SentenciaSQL.setInt(1,Integer.parseInt(cmb.getSelectedItem().toString()));
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            if(OpcionB.getText().equals(rs.getString(1)))
            {
            correctas= correctas+1;
            nota= nota+0.4;
            preguntas();
            GenerarRespuestas();
            }
            else
            {
            incorrectas= incorrectas+1;
            preguntas();
            GenerarRespuestas();
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpcionBActionPerformed

    private void OpcionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionCActionPerformed
        try {
                    if (JOptionPane.showConfirmDialog(null, "<html><h2><FONT FACE='comis sans ms'>¿Respuesta definitiva?</font></h2></html>" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT correcta FROM respuestas WHERE id_pregunta = ?" );
            SentenciaSQL.setInt(1,Integer.parseInt(cmb.getSelectedItem().toString()));
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            if(OpcionC.getText().equals(rs.getString(1)))
            {
            correctas= correctas+1;
            nota= nota+0.4;
            preguntas();
            GenerarRespuestas();
            }
            else
            {
            incorrectas= incorrectas+1;
            preguntas();
            GenerarRespuestas();
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpcionCActionPerformed

    private void OpcionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionDActionPerformed
        try {
                    if (JOptionPane.showConfirmDialog(null, "<html><h2><FONT FACE='Comic sans MS'>¿Respuesta definitiva?</font></h2></html>" , "WARNING/AVISO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT correcta FROM respuestas WHERE id_pregunta = ?" );
            SentenciaSQL.setInt(1,Integer.parseInt(cmb.getSelectedItem().toString()));
            ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
            rs.last();
            if(OpcionD.getText().equals(rs.getString(1)))
            {
            correctas= correctas+1;
            nota= nota+0.4;
            preguntas();
            GenerarRespuestas();
            }
            else
            {
            incorrectas= incorrectas+1;
            preguntas();
            GenerarRespuestas();
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpcionDActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       OpcionA.setEnabled(false);
       OpcionB.setEnabled(false);
       OpcionC.setEnabled(false);
       OpcionD.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

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
                Juego dialog = new Juego(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Comenzar;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton OpcionA;
    private javax.swing.JButton OpcionB;
    private javax.swing.JButton OpcionC;
    private javax.swing.JButton OpcionD;
    private javax.swing.JTextArea Pregunta;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JComboBox cmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPicture;
    // End of variables declaration//GEN-END:variables
}

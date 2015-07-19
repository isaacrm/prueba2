/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clases.Conexion;
import Clases.Recuperacion;
import com.sun.awt.AWTUtilities;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Isaac
 */
public final class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
            private PreparedStatement SentenciaSQL;
        public Timer objetotimer;
    public int a;
    public Login() {
        initComponents();
        log.setSize(483, 214);
        setSize(Toolkit.getDefaultToolkit().getScreenSize()); 
        getContentPane().setLayout(null);
        getContentPane().add(log);
        setVisible(true);
        int panelX = (getWidth() - log.getWidth() - getInsets().left - getInsets().right) / 2;
        int panelY = ((getHeight() - log.getHeight() - getInsets().top - getInsets().bottom) / 2);
        log.setLocation(panelX, panelY);
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(102,102,102));
        fondo1 pnlFondo = new fondo1();
        this.add(pnlFondo, BorderLayout.CENTER);
    }
int intentos = 0; //Variable para controlar los intentos fallidos.       
        void IntentosFallidos()
        {
            intentos = intentos + 1;
            if (intentos < 3)
            {
                JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta");
                user.setText("");
                pass.setText("");
                user.requestFocusInWindow();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Intentos Fallidos");
                System.exit(0);
            }
            }
        public void IniciarSesion(){
// velocidad en microsegundos
          objetotimer = new Timer(5,new claseTimer());
            try
            {
                if ("".equals(pass.getText()) && "".equals(user.getText())||"".equals(pass.getText()) || "".equals(user.getText()))
                {
                    IntentosFallidos();
                }
                else
                {
                    Conexion conect=new Conexion();
                    Statement st = conect.Conectar();
               try
                    {//compara si existe usuario
                    String users=user.getText();
                    String passe=pass.getText();
                    ResultSet rs = st.executeQuery("SELECT id_usuario,materia,tipo FROM usuarios Where nick='"+users+"'and contraseña='"+Recuperacion.Encriptar(passe)+"' AND estado_usuario='true'");
                    rs.last();
                    int encontrado = rs.getRow();
                    if (encontrado == 1)
                    {
                    Conexion.CodigoUsuario = rs.getInt(1);
                    Conexion.Materia= rs.getString(2);
                    Conexion.Tipo= rs.getString(3);
                    Conexion.Contraseña= pass.getText();
                    Conexion.NombreUsuario= user.getText();
                    objetotimer.start();
                    }
                    else
                    {
                        IntentosFallidos();
                    }
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
           }
                }
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
}
//timer para la barra de progreso
        public class claseTimer implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
              a=jProgressBar1.getValue();
              if (a <100){//Si es menor al 100%
                  a++;//progresa
                  jProgressBar1.setValue(a);
                   }
              else{//si acaba
                  try {
                      objetotimer.stop();//se detiene y hace esto
                      SentenciaSQL = Conexion.mthPrepararSentenciaSQL("SELECT tipo FROM usuarios  WHERE id_usuario = ?" );
                      SentenciaSQL.setInt(1, Conexion.CodigoUsuario);
                      ResultSet rs = Conexion.mthObtenerValor(SentenciaSQL);
                      rs.last();
                      switch (rs.getString(1)) {//tipos de usuario
                          case "Maestro/a":
                              new Principal().show();
                              break;
                          case "Estudiante":
                              new Principal2().show();
                              break;
                      }
                     cerrar();
                  } 
                  catch (SQLException ex) {
                      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                  }

              }        
      
        }
        }
        private void cerrar(){
   this.dispose(); 
}
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        log = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        cancelar = new javax.swing.JLabel();
        recuperar = new javax.swing.JLabel();
        recuperar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        log.setBackground(new java.awt.Color(51, 51, 51));
        log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        log.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rueda.png"))); // NOI18N

        user.setToolTipText("");

        jButton1.setBackground(new java.awt.Color(0, 51, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login2.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(0, 102, 153));
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setStringPainted(true);

        cancelar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 51, 0));
        cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar.setText("Cancelar");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarMouseExited(evt);
            }
        });

        recuperar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar.setForeground(new java.awt.Color(0, 204, 255));
        recuperar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recuperar.setText("Recuperar Contraseña");
        recuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recuperarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recuperarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recuperarMouseExited(evt);
            }
        });

        recuperar1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar1.setForeground(new java.awt.Color(0, 204, 51));
        recuperar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recuperar1.setText("Registrarse");
        recuperar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recuperar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recuperar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recuperar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logLayout = new javax.swing.GroupLayout(log);
        log.setLayout(logLayout);
        logLayout.setHorizontalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recuperar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(logLayout.createSequentialGroup()
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(recuperar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        logLayout.setVerticalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(logLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recuperar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recuperar1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IniciarSesion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
            IniciarSesion();}
    }//GEN-LAST:event_jButton1KeyPressed

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cancelarMouseClicked

    private void cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseEntered
    cancelar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
    cancelar.setForeground(new java.awt.Color(255,153,51));
 
    }//GEN-LAST:event_cancelarMouseEntered

    private void cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseExited
        cancelar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 51, 0));
    }//GEN-LAST:event_cancelarMouseExited

    private void recuperarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseEntered
        recuperar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar.setForeground(new java.awt.Color(0,153,204));
    }//GEN-LAST:event_recuperarMouseEntered

    private void recuperarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseExited
        recuperar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar.setForeground(new java.awt.Color(0, 204, 255));
    }//GEN-LAST:event_recuperarMouseExited

    private void recuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseClicked
      new Recuperar1(this,true).setVisible(true);
    }//GEN-LAST:event_recuperarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void recuperar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperar1MouseClicked
       new NuevoAlumno(this,true).setVisible(true);
    }//GEN-LAST:event_recuperar1MouseClicked

    private void recuperar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperar1MouseEntered
        recuperar1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar1.setForeground(new java.awt.Color(0,255,102));
    }//GEN-LAST:event_recuperar1MouseEntered

    private void recuperar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperar1MouseExited
        recuperar1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        recuperar1.setForeground(new java.awt.Color(0,204,51));
    }//GEN-LAST:event_recuperar1MouseExited


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel log;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel recuperar;
    private javax.swing.JLabel recuperar1;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Isaac
 */
public class NotasTodos extends javax.swing.JDialog {

    /**
     * Creates new form NotasAlumno
     */
    public NotasTodos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.getContentPane().setBackground(new java.awt.Color(203,203,203));
        tabla.getTableHeader().setReorderingAllowed(false); 
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        busqueda = new javax.swing.JComboBox();
        materia = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NIE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TODAS LAS CALIFICACIONES");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Calificaciones"));
        jPanel1.setOpaque(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "NIE", "Nombres", "Apellidos", "Calificacion", "Materia", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        jPanel2.setOpaque(false);

        busqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Opción...", "Mostrar Todas por Materia y Estudiante", "Mostrar Últimas Calificaciones", "Mostrar Últimas Calificaciones por Materia y Estudiante" }));
        busqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                busquedaItemStateChanged(evt);
            }
        });
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });

        materia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Materia...", "Ciencias", "Lenguaje", "Matemáticas", "Sociales" }));
        materia.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton2.setText("RESTAURAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite el NIE de Estudiante");

        NIE.setEditable(false);
        NIE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NIEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NIE, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedaActionPerformed

    private void busquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_busquedaItemStateChanged
       if(evt.getStateChange() == ItemEvent.SELECTED)
       {
          if(this.busqueda.getSelectedIndex()==0)
          { 
              materia.setEnabled(false);
              materia.setSelectedIndex(0);
              NIE.setEditable(false);
          }
          else if(this.busqueda.getSelectedIndex()==1)
           {
               materia.setEnabled(true);
               NIE.setEditable(true);
           }
           else  if(this.busqueda.getSelectedIndex()==2)
           {
               materia.setEnabled(false);
               materia.setSelectedIndex(0);
               NIE.setEditable(false);
           }
           else  if(this.busqueda.getSelectedIndex()==3)
           {
               materia.setEnabled(true);
               NIE.setEditable(true);
           }
        else
        {
            JOptionPane.showMessageDialog(this, "Error");

        }
       }
    }//GEN-LAST:event_busquedaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if(busqueda.getSelectedIndex()==0)
          { 
              JOptionPane.showMessageDialog(this, "Seleccione una opción de búsqueda");
          }
          else if(busqueda.getSelectedIndex()==1)
           {
               //Con materia
               if(materia.getSelectedIndex()==0)
               {
                   JOptionPane.showMessageDialog(this, "Seleccione una materia");
               }
               else if(NIE.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(this, "Digite el NIE");
               }
               else
               {
            LimpiarTabla();
            Clases.Scores f=new Clases.Scores();
            f.setMateria(materia.getSelectedItem().toString());
            f.setIdentificador(NIE.getText());
            try {
                f.AllMateyEst(tabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
               }
           }
           else  if(busqueda.getSelectedIndex()==2)
           {
            LimpiarTabla();
            Clases.Scores f=new Clases.Scores();
            f.setMateria(materia.getSelectedItem().toString());
            try {
                f.TodosUltimas(tabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
           }
           else  if(busqueda.getSelectedIndex()==3)
           {
              //Con materias
             if(materia.getSelectedIndex()==0)
               {
                   JOptionPane.showMessageDialog(this, "Seleccione una materia");
               }
                else if(NIE.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(this, "Digite el NIE");
               }
               else
               {
            LimpiarTabla();
            Clases.Scores f=new Clases.Scores();
            f.setMateria(materia.getSelectedItem().toString());
            f.setIdentificador(NIE.getText());
            try {
                f.TodosEstMat(tabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
               }
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Clases.Scores f=new Clases.Scores();
        try {
            f.AllforAll(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        materia.setEnabled(false);
        materia.setSelectedIndex(0);
        busqueda.setSelectedIndex(0);
        NIE.setEditable(false);
        NIE.setText(null);
        LimpiarTabla();
       Clases.Scores f=new Clases.Scores();
        try {
            f.AllforAll(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NIEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NIEKeyTyped
        char c;
        c=evt.getKeyChar();
        if((c<'0'||c>'9')) evt.consume();
        if (NIE.getText().length() >= 8)
        {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_NIEKeyTyped

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
                NotasTodos dialog = new NotasTodos(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField NIE;
    private javax.swing.JComboBox busqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox materia;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

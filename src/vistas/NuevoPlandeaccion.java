/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

/**
 *
 * @author Sala221
 */
public class NuevoPlandeaccion extends javax.swing.JFrame {

    /**
     * Creates new form NuevoPlandeaccion
     */
    public NuevoPlandeaccion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RTAusuario = new javax.swing.ButtonGroup();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        MODIFICAR = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblplanaccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jBtnVer = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();
        jBtnAgregar = new javax.swing.JButton();
        jbtnactualizar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpanelprincipal = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtcodiplanaccion = new javax.swing.JTextField();
        jtxtcodifuncio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtcodiPQRSM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateFechaSolucion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDatefecharecepcion = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jDatefecharevision = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTexttrata = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        JCBResponsable = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jDateFechaCumpli = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jDatefechaRTA = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jRBTcarta = new javax.swing.JRadioButton();
        jRBTemail = new javax.swing.JRadioButton();
        jRBTTel = new javax.swing.JRadioButton();

        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        jPopupMenu5.add(MODIFICAR);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(816, 680));
        setPreferredSize(new java.awt.Dimension(816, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTblplanaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTblplanaccion.setComponentPopupMenu(jPopupMenu5);
        jScrollPane2.setViewportView(jTblplanaccion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 730, 210));

        jBtnVer.setText("Ver Usuarios");
        jBtnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 590, -1, -1));

        jBtnAdicionar.setText("Adicionar Usuarios");
        jBtnAdicionar.setEnabled(false);
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, -1, -1));

        jBtnAgregar.setText("Agregar Usuarios");
        getContentPane().add(jBtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, -1, -1));

        jbtnactualizar.setText("Actualizar");
        jbtnactualizar.setEnabled(false);
        getContentPane().add(jbtnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, -1, -1));

        jBtnEliminar.setText("Eliminar Usuarios");
        jBtnEliminar.setEnabled(false);
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, -1, -1));

        jScrollPane3.setName(""); // NOI18N

        jpanelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel34.setText("REGISTRO DE NUEVO PLAN DE ACCION");
        jpanelprincipal.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 480, -1));

        jLabel1.setText("Numero plan de accion");
        jpanelprincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));
        jpanelprincipal.add(jtxtcodiplanaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 30, -1));
        jpanelprincipal.add(jtxtcodifuncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 30, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fecha de solucion:");
        jpanelprincipal.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));
        jpanelprincipal.add(jtxtcodiPQRSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 30, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Numero del PQRSM:");
        jpanelprincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Numero del funcionario:");
        jpanelprincipal.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jpanelprincipal.add(jDateFechaSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Medio de respuesta al usuario:");
        jpanelprincipal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));
        jpanelprincipal.add(jDatefecharecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Fecha de revision:");
        jpanelprincipal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));
        jpanelprincipal.add(jDatefecharevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 110, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Fecha de recepcion:");
        jpanelprincipal.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTexttrata.setColumns(20);
        jTexttrata.setRows(5);
        jScrollPane1.setViewportView(jTexttrata);

        jpanelprincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 730, 110));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tratamiento:");
        jpanelprincipal.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jpanelprincipal.add(JCBResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 270, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Fecha de cumplimiento:");
        jpanelprincipal.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));
        jpanelprincipal.add(jDateFechaCumpli, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 110, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Fecha de respuesta al usuario:");
        jpanelprincipal.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));
        jpanelprincipal.add(jDatefechaRTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 110, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Responsable:");
        jpanelprincipal.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        RTAusuario.add(jRBTcarta);
        jRBTcarta.setText("Carta");
        jpanelprincipal.add(jRBTcarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, -1));

        RTAusuario.add(jRBTemail);
        jRBTemail.setText("E-Mail");
        jpanelprincipal.add(jRBTemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        RTAusuario.add(jRBTTel);
        jRBTTel.setText("Telefono");
        jpanelprincipal.add(jRBTTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

        jScrollPane3.setViewportView(jpanelprincipal);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MODIFICARActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void jBtnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnVerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoPlandeaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPlandeaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPlandeaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPlandeaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPlandeaccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox JCBResponsable;
    public javax.swing.JMenuItem MODIFICAR;
    public javax.swing.ButtonGroup RTAusuario;
    public javax.swing.JButton jBtnAdicionar;
    public javax.swing.JButton jBtnAgregar;
    public javax.swing.JButton jBtnEliminar;
    public javax.swing.JButton jBtnVer;
    public com.toedter.calendar.JDateChooser jDateFechaCumpli;
    public com.toedter.calendar.JDateChooser jDateFechaSolucion;
    public com.toedter.calendar.JDateChooser jDatefechaRTA;
    public com.toedter.calendar.JDateChooser jDatefecharecepcion;
    public com.toedter.calendar.JDateChooser jDatefecharevision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel34;
    public javax.swing.JPopupMenu jPopupMenu5;
    public javax.swing.JRadioButton jRBTTel;
    public javax.swing.JRadioButton jRBTcarta;
    public javax.swing.JRadioButton jRBTemail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTblplanaccion;
    public javax.swing.JTextArea jTexttrata;
    public javax.swing.JButton jbtnactualizar;
    public javax.swing.JPanel jpanelprincipal;
    public javax.swing.JTextField jtxtcodiPQRSM;
    public javax.swing.JTextField jtxtcodifuncio;
    public javax.swing.JTextField jtxtcodiplanaccion;
    // End of variables declaration//GEN-END:variables
}

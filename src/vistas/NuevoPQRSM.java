

package vistas;

import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelos.nuevoPQRSMModelo;


public class NuevoPQRSM extends javax.swing.JFrame {

    public String tipoqueja = "";
    public  String anexo1 = "";
    public String Recibo = ""; 
       
    nuevoPQRSMModelo modelo = new nuevoPQRSMModelo();
    
    
    public NuevoPQRSM() {
        initComponents();
        
        AsignarFecha();
    }

    
        public boolean isEmail(String correo){
            Pattern pat = null;
            Matcher mat =null;
            pat = Pattern.compile("^([0-9a-zA-Z]([_.W]*[0-9a-zA-Z])*@8[0-9a-zA-Z]"
                                  +"[-W]*[0-9a-Za-z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
            mat = pat.matcher(correo);
            if (mat.find()){
                return true;
            }
            else{
                return false;
            }
    }
    
    private void AsignarFecha(){
    
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            Date Fecha1 ;
            
            Fecha1 = formato.parse("01/01/1980 18:00:00");
            this.Fecha.setDate(Fecha1);
           Fecha.getDateEditor().setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(FrmNuevoPQRSM.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLblDocumento = new javax.swing.JLabel();
        jLblFecha = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        JTxtDocumento = new javax.swing.JTextField();
        Jtxtnombre = new javax.swing.JTextField();
        jLblTelefono = new javax.swing.JLabel();
        jLblDireccion = new javax.swing.JLabel();
        JtxtTel = new javax.swing.JTextField();
        JtxtDirecc = new javax.swing.JTextField();
        jLblMovil = new javax.swing.JLabel();
        jLblMail = new javax.swing.JLabel();
        JtxtCel = new javax.swing.JTextField();
        JtxtMail = new javax.swing.JTextField();
        jLblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtxtdescrip = new javax.swing.JTextArea();
        JRBmanifes = new javax.swing.JRadioButton();
        JRBQueja = new javax.swing.JRadioButton();
        JRBReclamo = new javax.swing.JRadioButton();
        JRBsuge = new javax.swing.JRadioButton();
        JRBpeticion = new javax.swing.JRadioButton();
        JRBanexosi = new javax.swing.JRadioButton();
        JRBanexono = new javax.swing.JRadioButton();
        jLblDscripcion2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtxtDescrip2 = new javax.swing.JTextArea();
        jLblImagen = new javax.swing.JLabel();
        Jtxtimagen = new javax.swing.JTextField();
        jBtnseleccionar = new javax.swing.JButton();
        JlblFoto = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JRBreciformato = new javax.swing.JRadioButton();
        JRBrecimail = new javax.swing.JRadioButton();
        JRBrecitele = new javax.swing.JRadioButton();
        jLblAnexa = new javax.swing.JLabel();
        JCBCargo = new javax.swing.JComboBox();
        jLblQuienResi = new javax.swing.JLabel();
        JCBfuncionario = new javax.swing.JComboBox();
        jLblApellido = new javax.swing.JLabel();
        JTxtApellido = new javax.swing.JTextField();
        JtxtTipousuario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        JtxtNo = new javax.swing.JTextField();
        jLblTipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("NUEVO PQRSM");

        jLblDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblDocumento.setText("Documento:");

        jLblFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblFecha.setText("Fecha:");

        jLblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblNombre.setText("Nombre:");

        JTxtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTxtDocumentoFocusLost(evt);
            }
        });
        JTxtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTxtDocumentoKeyTyped(evt);
            }
        });

        Jtxtnombre.setEnabled(false);
        Jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtxtnombreKeyTyped(evt);
            }
        });

        jLblTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblTelefono.setText("Telefono:");

        jLblDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblDireccion.setText("Direccion:");

        JtxtTel.setEnabled(false);
        JtxtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtxtTelKeyTyped(evt);
            }
        });

        JtxtDirecc.setEnabled(false);

        jLblMovil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblMovil.setText("Movil:");

        jLblMail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblMail.setText("E-Mail:");

        JtxtCel.setEnabled(false);
        JtxtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtxtCelKeyTyped(evt);
            }
        });

        JtxtMail.setEnabled(false);
        JtxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtxtMailActionPerformed(evt);
            }
        });

        jLblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblDescripcion.setText("Descripcion");

        Jtxtdescrip.setColumns(20);
        Jtxtdescrip.setRows(5);
        jScrollPane1.setViewportView(Jtxtdescrip);

        JRBmanifes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JRBmanifes.setText("MANIFESTACION DE SATISFACCION: Es la expresión de conformidad o reconocimiento por parte del usuario por un buen servicio recibido.");
        JRBmanifes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBmanifesActionPerformed(evt);
            }
        });

        JRBQueja.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JRBQueja.setText("QUEJA: Manifestación de insatisfacción expresada por  el usuario  en relación con la atención y/o servicio recibido.");
        JRBQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBQuejaActionPerformed(evt);
            }
        });

        JRBReclamo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JRBReclamo.setText("RECLAMO: Expresión de inconformidad por parte del usuario  ante el incumplimiento de una garantía implícita o explícita del servicio.");
        JRBReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBReclamoActionPerformed(evt);
            }
        });

        JRBsuge.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JRBsuge.setText("SUGERENCIA: Aquella proposición o idea que aporta el usuario para aumentar su satisfacción en la prestación del servicio.\t");
        JRBsuge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBsugeActionPerformed(evt);
            }
        });

        JRBpeticion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JRBpeticion.setText("PETICION: Es aquella solicitud de aclaración, explicación o información del usuario respecto a la prestación o realización de un servicio  en especial.\t");
        JRBpeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBpeticionActionPerformed(evt);
            }
        });

        JRBanexosi.setText("Si");
        JRBanexosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBanexosiActionPerformed(evt);
            }
        });

        JRBanexono.setText("No");
        JRBanexono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBanexonoActionPerformed(evt);
            }
        });

        jLblDscripcion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblDscripcion2.setText("Descripcion");

        JtxtDescrip2.setColumns(20);
        JtxtDescrip2.setRows(5);
        jScrollPane2.setViewportView(JtxtDescrip2);

        jLblImagen.setText("Imagen:");

        Jtxtimagen.setEnabled(false);

        jBtnseleccionar.setText("Seleccionar");
        jBtnseleccionar.setEnabled(false);
        jBtnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnseleccionarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Cargo:");

        JRBreciformato.setText("Recibida en formato no institucional");

        JRBrecimail.setText("Recibida via E-mail");
        JRBrecimail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBrecimailActionPerformed(evt);
            }
        });

        JRBrecitele.setText("Recibida telefónicamente");

        jLblAnexa.setText("Anexa algun documento:");

        JCBCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        JCBCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCargoActionPerformed(evt);
            }
        });

        jLblQuienResi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblQuienResi.setText("Nombre de quien recibe:");

        JCBfuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        JCBfuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBfuncionarioActionPerformed(evt);
            }
        });

        jLblApellido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblApellido.setText("Apellido:");

        JTxtApellido.setEnabled(false);
        JTxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTxtApellidoKeyTyped(evt);
            }
        });

        JtxtTipousuario.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("No.");

        JtxtNo.setEnabled(false);

        jLblTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblTipo.setText("Tipo de Persona");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JRBReclamo)
                            .addComponent(JRBQueja)
                            .addComponent(JRBmanifes)
                            .addComponent(JRBpeticion)
                            .addComponent(JRBsuge)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLblDescripcion))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLblAnexa)
                                .addGap(6, 6, 6)
                                .addComponent(JRBanexosi)
                                .addGap(2, 2, 2)
                                .addComponent(JRBanexono)
                                .addGap(30, 30, 30)
                                .addComponent(jLblImagen)
                                .addGap(18, 18, 18)
                                .addComponent(Jtxtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jBtnseleccionar)
                                .addGap(18, 18, 18)
                                .addComponent(JlblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLblDscripcion2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(JRBrecimail)
                                .addGap(27, 27, 27)
                                .addComponent(JRBrecitele)
                                .addGap(35, 35, 35)
                                .addComponent(JRBreciformato))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLblQuienResi)
                                .addGap(14, 14, 14)
                                .addComponent(JCBfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel13)
                                .addGap(14, 14, 14)
                                .addComponent(JCBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblFecha)
                                        .addGap(191, 191, 191)
                                        .addComponent(jLblDireccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JtxtDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLblTelefono))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblMail)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLblMovil)
                                        .addGap(12, 12, 12)
                                        .addComponent(JtxtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLblTipo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JtxtTel)
                                    .addComponent(JtxtTipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblDocumento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLblApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JtxtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(JtxtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblApellido)
                    .addComponent(JTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNombre)
                    .addComponent(JTxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblDocumento))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblTelefono)
                            .addComponent(JtxtDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblDireccion))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLblMail))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtxtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JtxtTipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLblTipo)
                                .addComponent(jLblMovil))))
                    .addComponent(jLblFecha))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(JRBReclamo))
                    .addComponent(JRBQueja)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(JRBmanifes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(JRBpeticion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(JRBsuge)))
                .addGap(19, 19, 19)
                .addComponent(jLblDescripcion)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLblAnexa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(JRBanexosi))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(JRBanexono))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLblImagen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Jtxtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBtnseleccionar))
                    .addComponent(JlblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLblDscripcion2)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRBrecimail)
                    .addComponent(JRBrecitele)
                    .addComponent(JRBreciformato))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblQuienResi)
                    .addComponent(JCBfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(JCBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 68, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTxtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTxtDocumentoFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_JTxtDocumentoFocusLost

    private void JTxtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtDocumentoKeyTyped
        // TODO add your handling code here:

        int longitud = this.JTxtDocumento.getText().length() + 1;

        if(!Character.isDigit(evt.getKeyChar()) || longitud > 11)
        evt.consume();
    }//GEN-LAST:event_JTxtDocumentoKeyTyped

    private void JtxtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtnombreKeyTyped
        // TODO add your handling code here:

        int longitud = this.Jtxtnombre.getText().length() + 1;

        if(Character.isDigit(evt.getKeyChar()) || longitud > 25)
        evt.consume();
    }//GEN-LAST:event_JtxtnombreKeyTyped

    private void JtxtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtTelKeyTyped
        // TODO add your handling code here:

        int longitud = this.JtxtTel.getText().length() + 1;

        if(Character.isDigit(evt.getKeyChar()) || longitud > 25)
        evt.consume();
    }//GEN-LAST:event_JtxtTelKeyTyped

    private void JtxtCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtCelKeyTyped
        // TODO add your handling code here:

        int longitud = this.JtxtCel.getText().length() + 1;

        if(Character.isDigit(evt.getKeyChar()) || longitud > 25)
        evt.consume();
    }//GEN-LAST:event_JtxtCelKeyTyped

    private void JtxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtxtMailActionPerformed
        // TODO add your handling code here:
        isEmail(String.valueOf(JtxtMail));

    }//GEN-LAST:event_JtxtMailActionPerformed

    private void JRBmanifesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBmanifesActionPerformed
        // TODO add your handling code here:

        tipoqueja = "Manifestacion de satisfaccion";
    }//GEN-LAST:event_JRBmanifesActionPerformed

    private void JRBQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBQuejaActionPerformed
        // TODO add your handling code here:

        tipoqueja = "Queja";

    }//GEN-LAST:event_JRBQuejaActionPerformed

    private void JRBReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBReclamoActionPerformed
        // TODO add your handling code here:

        tipoqueja = "Reclamo";
    }//GEN-LAST:event_JRBReclamoActionPerformed

    private void JRBsugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBsugeActionPerformed
        // TODO add your handling code here:

        tipoqueja = "Sugerencia";

    }//GEN-LAST:event_JRBsugeActionPerformed

    private void JRBpeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBpeticionActionPerformed
        // TODO add your handling code here:

        tipoqueja = "Peticion";

    }//GEN-LAST:event_JRBpeticionActionPerformed

    private void JRBanexosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBanexosiActionPerformed
        // TODO add your handling code here:

        jBtnseleccionar.setEnabled(true);
        Jtxtimagen.setEnabled(true);
    }//GEN-LAST:event_JRBanexosiActionPerformed

    private void JRBanexonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBanexonoActionPerformed
        // TODO add your handling code here:

        jBtnseleccionar.setEnabled(false);
        Jtxtimagen.setEnabled(false);
    }//GEN-LAST:event_JRBanexonoActionPerformed

    private void jBtnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnseleccionarActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg","jpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:/Users/Sala221/Pictures");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if(ventana == JFileChooser.APPROVE_OPTION){

            File file = archivo.getSelectedFile();
            Jtxtimagen.setText(String.valueOf(file));
            Image foto = getToolkit().getImage(Jtxtimagen.getText());
            foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            JlblFoto.setIcon(new ImageIcon(foto));

        }
    }//GEN-LAST:event_jBtnseleccionarActionPerformed

    private void JRBrecimailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBrecimailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBrecimailActionPerformed

    private void JCBCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBCargoActionPerformed

    private void JCBfuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBfuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBfuncionarioActionPerformed

    private void JTxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtApellidoKeyTyped
        // TODO add your handling code here:

        int longitud = this.JTxtApellido.getText().length() + 1;

        if(Character.isDigit(evt.getKeyChar()) || longitud > 25)
        evt.consume();
    }//GEN-LAST:event_JTxtApellidoKeyTyped

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusLost

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
            java.util.logging.Logger.getLogger(NuevoPQRSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPQRSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPQRSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPQRSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPQRSM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox JCBCargo;
    public javax.swing.JComboBox JCBfuncionario;
    private javax.swing.JRadioButton JRBQueja;
    public javax.swing.JRadioButton JRBReclamo;
    public javax.swing.JRadioButton JRBanexono;
    public javax.swing.JRadioButton JRBanexosi;
    public javax.swing.JRadioButton JRBmanifes;
    public javax.swing.JRadioButton JRBpeticion;
    public javax.swing.JRadioButton JRBreciformato;
    public javax.swing.JRadioButton JRBrecimail;
    public javax.swing.JRadioButton JRBrecitele;
    public javax.swing.JRadioButton JRBsuge;
    public javax.swing.JTextField JTxtApellido;
    public javax.swing.JTextField JTxtDocumento;
    private javax.swing.JLabel JlblFoto;
    public javax.swing.JTextField JtxtCel;
    public javax.swing.JTextArea JtxtDescrip2;
    public javax.swing.JTextField JtxtDirecc;
    public javax.swing.JTextField JtxtMail;
    public javax.swing.JTextField JtxtNo;
    public javax.swing.JTextField JtxtTel;
    public javax.swing.JTextField JtxtTipousuario;
    public javax.swing.JTextArea Jtxtdescrip;
    public javax.swing.JTextField Jtxtimagen;
    public javax.swing.JTextField Jtxtnombre;
    public javax.swing.JButton jBtnseleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLblAnexa;
    private javax.swing.JLabel jLblApellido;
    private javax.swing.JLabel jLblDescripcion;
    private javax.swing.JLabel jLblDireccion;
    private javax.swing.JLabel jLblDocumento;
    private javax.swing.JLabel jLblDscripcion2;
    private javax.swing.JLabel jLblFecha;
    private javax.swing.JLabel jLblImagen;
    private javax.swing.JLabel jLblMail;
    private javax.swing.JLabel jLblMovil;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblQuienResi;
    private javax.swing.JLabel jLblTelefono;
    private javax.swing.JLabel jLblTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

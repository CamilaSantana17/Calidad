package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.nuevoPQRSMModelo;
import vistas.FrmNuevoPQRSM;
import vistas.Principal;
/**
 * @author Ricardo Palacio P.
 */
public class nuevoPQRSMControlador implements ActionListener,MouseListener{
    nuevoPQRSMModelo modelo = new nuevoPQRSMModelo();
//     Principal vtnPrincipal = new Principal();
    FrmNuevoPQRSM ventana;

    public enum AccionMVC{
        _NUEVO_,
        _GUARDAR_,
        _ACTUALIZAR_,
        _CANCELAR_
    }

    public nuevoPQRSMControlador(FrmNuevoPQRSM vista){
        this.ventana = vista;
    }

    public void iniciar(){
//        try{
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(ventana);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
//        } catch (UnsupportedLookAndFeelException ex) {}
//          catch (ClassNotFoundException ex) {
//              JOptionPane.showMessageDialog(ventana, "Error de driver de "
//                      + "video: "+ex.getMessage());
//          }
//          catch (InstantiationException ex) {}
//          catch (IllegalAccessException ex) {}

        this.ventana.btnnuevo.setActionCommand("_NUEVO_");
        this.ventana.btnnuevo.addActionListener(this); 
        
        this.ventana.btnguardar.setActionCommand("_GUARDAR_");
        this.ventana.btnguardar.addActionListener(this); 
        
        this.ventana.btnactualizar.setActionCommand("_ACTUALIZAR_");
        this.ventana.btnactualizar.addActionListener(this); 
        
        this.ventana.btncancelar.setActionCommand("_CANCELAR_");
        this.ventana.btncancelar.addActionListener(this); 
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}        
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
    public void FocusLost(FocusEvent e) {  
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
            case _GUARDAR_:{
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    FileInputStream archivofoto = null;
                   
                    String Fech_Nto = formatofecha.format(ventana.Fecha);
                    String descripcionqueja = ventana.Jtxtdescrip.getText();
                    String nomimagen = ventana.Jtxtimagen.getText();
                    String No = ventana.JtxtNo.getText();
            try {
                archivofoto = new FileInputStream(ventana.Jtxtimagen.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(nuevoPQRSMControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    String docu = ventana.Jtxtdocumento.getText();
                    String Descripcionanexo = ventana.JtxtDescrip2.getText(); 
                    String quienrecibe = ventana.JCBfuncionario.getSelectedItem().toString();
                    String Cargo = ventana.JCBCargo.getSelectedItem().toString();
                    
//                String rta = modelo.NuevoPQRSM(No, docu ,Fech_Nto,ventana.tipoqueja, descripcionqueja, ventana.anexo1, nomimagen, 
//                        archivofoto, Descripcionanexo, ventana.Recibo, quienrecibe, Cargo);
               
                break;
            }      
        }
    }    
    
}

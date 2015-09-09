package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.nuevosegumientoModelo;

import vistas.nuevoseguimiento;
/**
 * @author Ricardo Palacio P.
 */
public class nuevoseguimientoControlador implements ActionListener,MouseListener{
    nuevosegumientoModelo modelo = new nuevosegumientoModelo();
    String Codiseguianterior ;
    nuevoseguimiento ventana;

    
     public enum AccionMVC{
         __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO,
        __ACTUALIZAR_USUARIO,
        __MODIFICAR_USUARIO
    }

    public nuevoseguimientoControlador(nuevoseguimiento vista){
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

       
        this.ventana.jBtnVer.setActionCommand("__VER_USUARIO");
        this.ventana.jBtnVer.addActionListener(this);
        
        this.ventana.jBtnAdicionar.setActionCommand("__ADICIONAR_USUARIO");
        this.ventana.jBtnAdicionar.addActionListener(this);

        this.ventana.jBtnAgregar.setActionCommand("__AGREGAR_USUARIO");
        this.ventana.jBtnAgregar.addActionListener(this);

        this.ventana.jBtnEliminar.setActionCommand("__ELIMINAR_USUARIO");
        this.ventana.jBtnEliminar.addActionListener(this);

        this.ventana.jbtnactualizar.setActionCommand("__ACTUALIZAR_USUARIO");
        this.ventana.jbtnactualizar.addActionListener(this);
        
        this.ventana.MODIFICAR.setActionCommand("__MODIFICAR_USUARIO");
        this.ventana.MODIFICAR.addActionListener(this);
        
        this.ventana.jTblSegumientos.addMouseListener(this);
        this.ventana.jTblSegumientos.setModel(new DefaultTableModel());
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_USUARIO:{
                    this.ventana.jTblSegumientos.setModel(this.modelo.Gettablaseguimiento());
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(false);
                    this.ventana.jDateFecha.setEnabled(false);
                    this.ventana.jTextobservaciones.setEditable(false);
                    this.ventana.jDateFecha2.setEnabled(false);
                    this.ventana.jTextsatis_usuario.setEditable(false);
                    this.ventana.jtxtcodiPQRSM.requestFocus();
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jDateFecha.setDate(null);
                    this.ventana.jTextobservaciones.setText("");
                    this.ventana.jDateFecha2.setDate(null);
                    this.ventana.jTextsatis_usuario.setText("");
                    this.ventana.cierrequeja.clearSelection();
                    this.ventana.jtxtcodiPQRSM.setEnabled(false);
                    this.ventana.jTextobservaciones.setEnabled(false);
                    this.ventana.jTextsatis_usuario.setEnabled(false);
                    this.ventana.jRBTSi.setEnabled(false);
                    this.ventana.jRBTNo.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(false);
                    
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                    this.ventana.jDateFecha.setEnabled(true);
                    this.ventana.jTextobservaciones.setEditable(true);
                    this.ventana.jDateFecha2.setEnabled(true);
                    this.ventana.jTextsatis_usuario.setEditable(true);
                    this.ventana.jtxtcodiPQRSM.requestFocus();
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jDateFecha.setDate(null);
                    this.ventana.jTextobservaciones.setText("");
                    this.ventana.jDateFecha2.setDate(null);
                    this.ventana.jTextsatis_usuario.setText("");
                    this.ventana.cierrequeja.clearSelection();
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jTextobservaciones.setEnabled(true);
                    this.ventana.jTextsatis_usuario.setEnabled(true);
                    this.ventana.jRBTSi.setEnabled(true);
                    this.ventana.jRBTNo.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    
                    
                    break;
                }
                case __AGREGAR_USUARIO:{
                    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                   
                    String Fecha1 = formatofecha.format(ventana.jDateFecha.getDate());
                    String Fecha2 = formatofecha.format(ventana.jDateFecha2.getDate());
                    
                        if (this.modelo.NuevoUsuario(this.ventana.jtxtcodisegui.getText(),
                            this.ventana.jtxtcodiPQRSM.getText(),Fecha1,
                            this.ventana.jTextobservaciones.getText(),Fecha2,
                            this.ventana.jTextsatis_usuario.getText(),
                            this.ventana.Cierre)){
                            
                                this.ventana.jTblSegumientos.setModel(this.modelo.Gettablaseguimiento());
                                JOptionPane.showMessageDialog(ventana,"Usuario Registrado!.");
                                
                            this.ventana.jtxtcodiPQRSM.setEditable(false);
                            this.ventana.jDateFecha.setEnabled(false);
                            this.ventana.jTextobservaciones.setEditable(false);
                            this.ventana.jDateFecha2.setEnabled(false);
                            this.ventana.jTextsatis_usuario.setEditable(false);
                            this.ventana.jtxtcodiPQRSM.requestFocus();
                            this.ventana.jtxtcodiPQRSM.setText("");
                            this.ventana.jDateFecha.setDate(null);
                            this.ventana.jTextobservaciones.setText("");
                            this.ventana.jDateFecha2.setDate(null);
                            this.ventana.jTextsatis_usuario.setText("");
                            this.ventana.cierrequeja.clearSelection();
                            this.ventana.jtxtcodiPQRSM.setEnabled(false);
                            this.ventana.jTextobservaciones.setEnabled(false);
                            this.ventana.jTextsatis_usuario.setEnabled(false);
                            this.ventana.jRBTSi.setEnabled(false);
                            this.ventana.jRBTNo.setEnabled(false);
                            this.ventana.jBtnAgregar.setEnabled(false);
                            this.ventana.jBtnAdicionar.setEnabled(true);
                           
                        }
                        else
                            JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                    
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    
                    if (this.modelo.EliminarUsuario(this.ventana.jtxtcodisegui.getText())){
                        this.ventana.jTblSegumientos.setModel(this.modelo.Gettablaseguimiento());
                        JOptionPane.showMessageDialog(ventana,"Usuario eliminado.");
                            
                            this.ventana.jtxtcodiPQRSM.setEditable(false);
                            this.ventana.jDateFecha.setEnabled(false);
                            this.ventana.jTextobservaciones.setEditable(false);
                            this.ventana.jDateFecha2.setEnabled(false);
                            this.ventana.jTextsatis_usuario.setEditable(false);
                            this.ventana.jtxtcodiPQRSM.requestFocus();
                            this.ventana.jtxtcodiPQRSM.setText("");
                            this.ventana.jDateFecha.setDate(null);
                            this.ventana.jTextobservaciones.setText("");
                            this.ventana.jDateFecha2.setDate(null);
                            this.ventana.jTextsatis_usuario.setText("");
                            this.ventana.cierrequeja.clearSelection();
                            this.ventana.jtxtcodiPQRSM.setEnabled(false);
                            this.ventana.jTextobservaciones.setEnabled(false);
                            this.ventana.jTextsatis_usuario.setEnabled(false);
                            this.ventana.jRBTSi.setEnabled(false);
                            this.ventana.jRBTNo.setEnabled(false);
                            
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                    }else{
                    
                        JOptionPane.showMessageDialog(ventana,"No se ha seleccionado un registro.!");
                    
                    }
                    break;       
                }
                
                case __ACTUALIZAR_USUARIO:{
                     SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                    FileInputStream archivofoto = null;
                   
                    String Fecha1 = formatofecha.format(ventana.jDateFecha.getDate());
                    String Fecha2 = formatofecha.format(ventana.jDateFecha2.getDate());
                   
                    if(this.modelo.Actualizar(Codiseguianterior,this.ventana.jtxtcodisegui.getText(),
                            this.ventana.jtxtcodiPQRSM.getText(),Fecha1,
                            this.ventana.jTextobservaciones.getText(),Fecha2,
                            this.ventana.jTextsatis_usuario.getText(),
                            this.ventana.Cierre)){
                    
                    this.ventana.jTblSegumientos.setModel(this.modelo.Gettablaseguimiento());
                    
                    JOptionPane.showMessageDialog(ventana,"Datos Actualizados Correctamente!.");
                    
                        this.ventana.jtxtcodiPQRSM.setEditable(false);
                        this.ventana.jDateFecha.setEnabled(false);
                        this.ventana.jTextobservaciones.setEditable(false);
                        this.ventana.jDateFecha2.setEnabled(false);
                        this.ventana.jTextsatis_usuario.setEditable(false);
                        this.ventana.jtxtcodiPQRSM.requestFocus();
                        this.ventana.jtxtcodiPQRSM.setText("");
                        this.ventana.jDateFecha.setDate(null);
                        this.ventana.jTextobservaciones.setText("");
                        this.ventana.jDateFecha2.setDate(null);
                        this.ventana.jTextsatis_usuario.setText("");
                        this.ventana.cierrequeja.clearSelection();
                        this.ventana.jtxtcodiPQRSM.setEnabled(false);
                        this.ventana.jTextobservaciones.setEnabled(false);
                        this.ventana.jTextsatis_usuario.setEnabled(false);
                        this.ventana.jRBTSi.setEnabled(false);
                        this.ventana.jRBTNo.setEnabled(false);
                        this.ventana.jbtnactualizar.setEnabled(false);
                        this.ventana.jBtnAdicionar.setEnabled(true);
                        this.ventana.jBtnEliminar.setEnabled(true);    
                    
                    }else{
                  
                    JOptionPane.showMessageDialog(ventana,"Por favor digite informacion en los campos vacios.!");
                   
                  
                  }
                
                     break;
                }
                
                case __MODIFICAR_USUARIO:{
                    
                    Codiseguianterior = ventana.jtxtcodisegui.getText();
                    
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    this.ventana.jbtnactualizar.setEnabled(true);
                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                    this.ventana.jDateFecha.setEnabled(true);
                    this.ventana.jTextobservaciones.setEditable(true);
                    this.ventana.jDateFecha2.setEnabled(true);
                    this.ventana.jTextsatis_usuario.setEditable(true);
                    this.ventana.jtxtcodiPQRSM.requestFocus();
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jTextobservaciones.setEnabled(true);
                    this.ventana.jTextsatis_usuario.setEnabled(true);
                    this.ventana.jRBTSi.setEnabled(true);
                    this.ventana.jRBTNo.setEnabled(true);
                
                }
            }
    
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getButton() == 1)//boton izquierdo
        {
             int fila = this.ventana.jTblSegumientos.rowAtPoint(e.getPoint());
             if (fila > -1){
                 
                 SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                 String fecha2 = String.valueOf(this.ventana.jTblSegumientos.getValueAt(fila, 4));
                 String fecha = String.valueOf(this.ventana.jTblSegumientos.getValueAt(fila, 2));
                 
                 Date dato = null;
                 Date dato2 = null;
                 
                 try {
                     dato2 = formatofecha.parse(fecha2);
                     dato = formatofecha.parse(fecha);
                 } catch (ParseException ex) {
                     Logger.getLogger(nuevoseguimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                this.ventana.jtxtcodisegui.setText(String.valueOf(
                        this.ventana.jTblSegumientos.getValueAt(fila, 0)));
                this.ventana.jtxtcodiPQRSM.setText(String.valueOf(
                        this.ventana.jTblSegumientos.getValueAt(fila, 1)));
                this.ventana.jDateFecha.setDate(dato);
                this.ventana.jTextobservaciones.setText(String.valueOf(
                        this.ventana.jTblSegumientos.getValueAt(fila, 3)));
                this.ventana.jDateFecha2.setDate(dato2);
                this.ventana.jTextsatis_usuario.setText(String.valueOf(
                        this.ventana.jTblSegumientos.getValueAt(fila, 5)));
                
                String Cierre = String.valueOf(this.ventana.jTblSegumientos.getValueAt(fila, 6));
                
                if("Si".equals(Cierre)){
                     this.ventana.jRBTNo.setSelected(false);
                     this.ventana.jRBTSi.setSelected(true);
                
                }else{
                       this.ventana.jRBTNo.setSelected(true);
                     this.ventana.jRBTSi.setSelected(false);
                    }
                }
                this.ventana.jtxtcodiPQRSM.setEditable(false);
                this.ventana.jDateFecha.setEnabled(false);
                this.ventana.jTextobservaciones.setEditable(false);
                this.ventana.jDateFecha2.setEnabled(false);
                this.ventana.jTextsatis_usuario.setEditable(false);
                             
             }
        }
}
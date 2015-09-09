package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.nuevoplandeaccionmodelo;
import vistas.NuevoPlandeaccion;
/**
 * @author Ricardo Palacio P.
 */
public class nuevoplandeaccionControlador implements ActionListener,MouseListener{
    nuevoplandeaccionmodelo modelo = new nuevoplandeaccionmodelo();
    NuevoPlandeaccion ventana;

    
     public enum AccionMVC{
         __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO,
        __ACTUALIZAR_USUARIO,
        __MODIFICAR_USUARIO
    }

    public nuevoplandeaccionControlador(NuevoPlandeaccion vista){
        this.ventana = vista;
        
        this.modelo.llenarComboresponsable(this.ventana.JCBResponsable);
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
        
        this.ventana.jTblplanaccion.addMouseListener(this);
        this.ventana.jTblplanaccion.setModel(new DefaultTableModel());
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_USUARIO:{
                    this.ventana.jTblplanaccion.setModel(this.modelo.gettablaplanaccion());
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(false);
                    this.ventana.jtxtcodifuncio.setEditable(false);
                    this.ventana.jtxtcodiplanaccion.setEditable(false);
                    this.ventana.JCBResponsable.setEditable(false);
                    this.ventana.jTexttrata.setEditable(false);
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jtxtcodifuncio.setText("");
                    this.ventana.jtxtcodiplanaccion.setText("");
                    this.ventana.jTexttrata.setText("");
                    this.ventana.jDateFechaCumpli.setDate(null);
                    this.ventana.jDateFechaSolucion.setDate(null);
                    this.ventana.jDatefechaRTA.setDate(null);
                    this.ventana.jDatefecharecepcion.setDate(null);
                    this.ventana.jDatefecharevision.setDate(null);
                    this.ventana.JCBResponsable.setSelectedIndex(0);                    
                    this.ventana.jtxtcodiPQRSM.setEnabled(false);
                    this.ventana.jtxtcodifuncio.setEnabled(false);
                    this.ventana.jtxtcodiplanaccion.setEnabled(false);
                    this.ventana.jDateFechaCumpli.setEnabled(false);
                    this.ventana.jDateFechaSolucion.setEnabled(false);
                    this.ventana.jDatefechaRTA.setEnabled(false);
                    this.ventana.jDatefecharecepcion.setEnabled(false);
                    this.ventana.jDatefecharevision.setEnabled(false);
                    this.ventana.JCBResponsable.setEnabled(false);
                    
                    this.ventana.jBtnEliminar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(false);
                    
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                    this.ventana.jtxtcodifuncio.setEditable(true);
                    this.ventana.jtxtcodiplanaccion.setEditable(true);
                    this.ventana.JCBResponsable.setEditable(true);
                    this.ventana.jTexttrata.setEditable(true);
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jtxtcodifuncio.setText("");
                    this.ventana.jtxtcodiplanaccion.setText("");
                    this.ventana.jTexttrata.setText("");
                    this.ventana.jDateFechaCumpli.setDate(null);
                    this.ventana.jDateFechaSolucion.setDate(null);
                    this.ventana.jDatefechaRTA.setDate(null);
                    this.ventana.jDatefecharecepcion.setDate(null);
                    this.ventana.jDatefecharevision.setDate(null);
                    this.ventana.JCBResponsable.setSelectedIndex(0);                    
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jtxtcodifuncio.setEnabled(true);
                    this.ventana.jtxtcodiplanaccion.setEnabled(true);
                    this.ventana.jDateFechaCumpli.setEnabled(true);
                    this.ventana.jDateFechaSolucion.setEnabled(true);
                    this.ventana.jDatefechaRTA.setEnabled(true);
                    this.ventana.jDatefecharecepcion.setEnabled(true);
                    this.ventana.jDatefecharevision.setEnabled(true);
                    this.ventana.JCBResponsable.setEnabled(true);
                    
                    
                    this.ventana.jBtnAgregar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    
                    
                    break;
                }
                case __AGREGAR_USUARIO:{
                     SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                   
                    String Fecha1 = formatofecha.format(ventana.jDatefecharecepcion.getDate());
                    String Fecha2 = formatofecha.format(ventana.jDatefecharevision.getDate());
                    String Fecha3 = formatofecha.format(ventana.jDateFechaSolucion.getDate());
                    String Fecha4 = formatofecha.format(ventana.jDateFechaCumpli.getDate());
                    String Fecha5 = formatofecha.format(ventana.jDatefechaRTA.getDate());
                    
                        if (this.modelo.Nuevoplanaccion(this.ventana.jtxtcodiplanaccion.getText(),this.ventana.jtxtcodifuncio.getText(),this.ventana.jtxtcodiPQRSM.getText(),
                        Fecha1,Fecha2,Fecha3,this.ventana.jTexttrata.getText(),(String)this.ventana.JCBResponsable.getSelectedItem(),
                        Fecha4,Fecha5,String.valueOf(this.ventana.RTAusuario.getSelection()))){
                            
                                this.ventana.jTblplanaccion.setModel(this.modelo.gettablaplanaccion());
                                JOptionPane.showMessageDialog(ventana,"Usuario Registrado!.");
                                
                                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                                    this.ventana.jtxtcodifuncio.setEditable(true);
                                    this.ventana.jtxtcodiplanaccion.setEditable(true);
                                    this.ventana.JCBResponsable.setEditable(true);
                                    this.ventana.jTexttrata.setEditable(true);
                                    this.ventana.jtxtcodiPQRSM.setText("");
                                    this.ventana.jtxtcodifuncio.setText("");
                                    this.ventana.jtxtcodiplanaccion.setText("");
                                    this.ventana.jTexttrata.setText("");
                                    this.ventana.jDateFechaCumpli.setDate(null);
                                    this.ventana.jDateFechaSolucion.setDate(null);
                                    this.ventana.jDatefechaRTA.setDate(null);
                                    this.ventana.jDatefecharecepcion.setDate(null);
                                    this.ventana.jDatefecharevision.setDate(null);
                                    this.ventana.JCBResponsable.setSelectedIndex(0);                    
                                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                                    this.ventana.jtxtcodifuncio.setEnabled(true);
                                    this.ventana.jtxtcodiplanaccion.setEnabled(true);
                                    this.ventana.jDateFechaCumpli.setEnabled(true);
                                    this.ventana.jDateFechaSolucion.setEnabled(true);
                                    this.ventana.jDatefechaRTA.setEnabled(true);
                                    this.ventana.jDatefecharecepcion.setEnabled(true);
                                    this.ventana.jDatefecharevision.setEnabled(true);
                                    this.ventana.JCBResponsable.setEnabled(true);
                                
                                    this.ventana.jBtnAgregar.setEnabled(false);
                                    this.ventana.jBtnAdicionar.setEnabled(true);
                           
                        }
                        else
                            JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                    
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    
                    if (this.modelo.Eliminarplanaccion(this.ventana.jtxtcodiplanaccion.getText())){
                        this.ventana.jTblplanaccion.setModel(this.modelo.gettablaplanaccion());
                        JOptionPane.showMessageDialog(ventana,"Usuario eliminado.");
                            
                            this.ventana.jtxtcodiPQRSM.setEditable(true);
                            this.ventana.jtxtcodifuncio.setEditable(true);
                            this.ventana.jtxtcodiplanaccion.setEditable(true);
                            this.ventana.JCBResponsable.setEditable(true);
                            this.ventana.jTexttrata.setEditable(true);
                            this.ventana.jtxtcodiPQRSM.setText("");
                            this.ventana.jtxtcodifuncio.setText("");
                            this.ventana.jtxtcodiplanaccion.setText("");
                            this.ventana.jTexttrata.setText("");
                            this.ventana.jDateFechaCumpli.setDate(null);
                            this.ventana.jDateFechaSolucion.setDate(null);
                            this.ventana.jDatefechaRTA.setDate(null);
                            this.ventana.jDatefecharecepcion.setDate(null);
                            this.ventana.jDatefecharevision.setDate(null);
                            this.ventana.JCBResponsable.setSelectedIndex(0);                    
                            this.ventana.jtxtcodiPQRSM.setEnabled(true);
                            this.ventana.jtxtcodifuncio.setEnabled(true);
                            this.ventana.jtxtcodiplanaccion.setEnabled(true);
                            this.ventana.jDateFechaCumpli.setEnabled(true);
                            this.ventana.jDateFechaSolucion.setEnabled(true);
                            this.ventana.jDatefechaRTA.setEnabled(true);
                            this.ventana.jDatefecharecepcion.setEnabled(true);
                            this.ventana.jDatefecharevision.setEnabled(true);
                            this.ventana.JCBResponsable.setEnabled(true);
                            
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                    }else{
                    
                        JOptionPane.showMessageDialog(ventana,"No se ha seleccionado un registro.!");
                    
                    }
                    break;       
                }
                
                case __ACTUALIZAR_USUARIO:{
                     
                    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                   
                    String Fecha1 = formatofecha.format(ventana.jDatefecharecepcion.getDate());
                    String Fecha2 = formatofecha.format(ventana.jDatefecharevision.getDate());
                    String Fecha3 = formatofecha.format(ventana.jDateFechaSolucion.getDate());
                    String Fecha4 = formatofecha.format(ventana.jDateFechaCumpli.getDate());
                    String Fecha5 = formatofecha.format(ventana.jDatefechaRTA.getDate());
                    
                    if(this.modelo.Actualizar(this.ventana.jtxtcodiplanaccion.getText(),Fecha1,Fecha2,Fecha3,this.ventana.jTexttrata.getText(),
                            (String)this.ventana.JCBResponsable.getSelectedItem(),Fecha4,Fecha5,String.valueOf(this.ventana.RTAusuario.getSelection()))){
                    
                    this.ventana.jTblplanaccion.setModel(this.modelo.gettablaplanaccion());
                    
                    JOptionPane.showMessageDialog(ventana,"Datos Actualizados Correctamente!.");
                    
                        this.ventana.jtxtcodiPQRSM.setEditable(true);
                        this.ventana.jtxtcodifuncio.setEditable(true);
                        this.ventana.jtxtcodiplanaccion.setEditable(true);
                        this.ventana.JCBResponsable.setEditable(true);
                        this.ventana.jTexttrata.setEditable(true);
                        this.ventana.jtxtcodiPQRSM.setText("");
                        this.ventana.jtxtcodifuncio.setText("");
                        this.ventana.jtxtcodiplanaccion.setText("");
                        this.ventana.jTexttrata.setText("");
                        this.ventana.jDateFechaCumpli.setDate(null);
                        this.ventana.jDateFechaSolucion.setDate(null);
                        this.ventana.jDatefechaRTA.setDate(null);
                        this.ventana.jDatefecharecepcion.setDate(null);
                        this.ventana.jDatefecharevision.setDate(null);
                        this.ventana.JCBResponsable.setSelectedIndex(0);                    
                        this.ventana.jtxtcodiPQRSM.setEnabled(true);
                        this.ventana.jtxtcodifuncio.setEnabled(true);
                        this.ventana.jtxtcodiplanaccion.setEnabled(true);
                        this.ventana.jDateFechaCumpli.setEnabled(true);
                        this.ventana.jDateFechaSolucion.setEnabled(true);
                        this.ventana.jDatefechaRTA.setEnabled(true);
                        this.ventana.jDatefecharecepcion.setEnabled(true);
                        this.ventana.jDatefecharevision.setEnabled(true);
                        this.ventana.JCBResponsable.setEnabled(true);
                    
                        this.ventana.jbtnactualizar.setEnabled(false);
                        this.ventana.jBtnAdicionar.setEnabled(true);
                          
                    
                    }else{
                  
                    JOptionPane.showMessageDialog(ventana,"Por favor digite informacion en los campos vacios.!");
                   
                  
                  }
                
                     break;
                }
                
                case __MODIFICAR_USUARIO:{
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                    this.ventana.jtxtcodifuncio.setEditable(true);
                    this.ventana.jtxtcodiplanaccion.setEditable(true);
                    this.ventana.JCBResponsable.setEditable(true);
                    this.ventana.jTexttrata.setEditable(true);
                                     
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jtxtcodifuncio.setEnabled(true);
                    this.ventana.jtxtcodiplanaccion.setEnabled(true);
                    this.ventana.jDateFechaCumpli.setEnabled(true);
                    this.ventana.jDateFechaSolucion.setEnabled(true);
                    this.ventana.jDatefechaRTA.setEnabled(true);
                    this.ventana.jDatefecharecepcion.setEnabled(true);
                    this.ventana.jDatefecharevision.setEnabled(true);
                    this.ventana.JCBResponsable.setEnabled(true);
                    this.ventana.jBtnEliminar.setEnabled(true);  
                
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
             int fila = this.ventana.jTblplanaccion.rowAtPoint(e.getPoint());
             if (fila > -1){
                 
                this.ventana.jtxtcodiplanaccion.setText(String.valueOf(
                        this.ventana.jTblplanaccion.getValueAt(fila, 0)));
                
                 this.ventana.jtxtcodifuncio.setText(String.valueOf(
                        this.ventana.jTblplanaccion.getValueAt(fila, 1)));
                 
                this.ventana.jtxtcodiPQRSM.setText(String.valueOf(
                        this.ventana.jTblplanaccion.getValueAt(fila, 2)));
               
                 SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
                 String fecha1 = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 3));
                 String fecha2 = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 4));
                 String fecha3 = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 5));
                 String fecha4 = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 8));
                 String fecha5 = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 9));
                 
                 
                 Date dato1 = null;
                 Date dato2 = null;
                 Date dato3 = null;
                 Date dato4 = null;
                 Date dato5 = null;
                 
                 try {
                     dato1 = formatofecha.parse(fecha1);
                     dato2 = formatofecha.parse(fecha2);
                     dato3 = formatofecha.parse(fecha3);
                     dato4 = formatofecha.parse(fecha4);
                     dato5 = formatofecha.parse(fecha5);
                 } catch (ParseException ex) {
                     Logger.getLogger(nuevoseguimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 this.ventana.jDatefecharecepcion.setDate(dato1);
                 this.ventana.jDatefecharevision.setDate(dato2);
                 this.ventana.jDateFechaSolucion.setDate(dato3);
                 
                String funcionario = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 7));
                int i = this.ventana.JCBResponsable.getSelectedIndex();
                while(i > 7){
                
                    if(funcionario.equals(i)){
                    
                      this.ventana.JCBResponsable.setSelectedIndex(i);
                      
                      i += 1;
                        
                    }
                
                }
              
                
             String Cierre = String.valueOf(this.ventana.jTblplanaccion.getValueAt(fila, 10));
                
                if("E-Mail".equals(Cierre)){
                     this.ventana.jRBTcarta.setSelected(false);
                     this.ventana.jRBTTel.setSelected(false);
                     this.ventana.jRBTemail.setSelected(true);
                
                }else{
                    if("Telefono".equals(Cierre)){
                        
                        this.ventana.jRBTTel.setSelected(true);
                         this.ventana.jRBTemail.setSelected(false);
                         this.ventana.jRBTcarta.setSelected(false);
                    
                    }else{
                    
                         this.ventana.jRBTTel.setSelected(false);
                         this.ventana.jRBTemail.setSelected(false);
                         this.ventana.jRBTcarta.setSelected(true);
                    
                    }
                       
                    }
                }
                    this.ventana.jtxtcodiPQRSM.setEditable(false);
                    this.ventana.jtxtcodifuncio.setEditable(false);
                    this.ventana.jtxtcodiplanaccion.setEditable(false);
                    this.ventana.JCBResponsable.setEditable(false);
                    this.ventana.jTexttrata.setEditable(false);
                                     
                    this.ventana.jtxtcodiPQRSM.setEnabled(false);
                    this.ventana.jtxtcodifuncio.setEnabled(false);
                    this.ventana.jtxtcodiplanaccion.setEnabled(false);
                    this.ventana.jDateFechaCumpli.setEnabled(false);
                    this.ventana.jDateFechaSolucion.setEnabled(false);
                    this.ventana.jDatefechaRTA.setEnabled(false);
                    this.ventana.jDatefecharecepcion.setEnabled(false);
                    this.ventana.jDatefecharevision.setEnabled(false);
                    this.ventana.JCBResponsable.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);  
                             
             }
        }
}
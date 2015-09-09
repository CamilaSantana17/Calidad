package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.nuevotratamientomodelo;
import vistas.nuevoTratamiento;
/**
 * @author Ricardo Palacio P.
 */
public class nuevoTratamientoControlador implements ActionListener,MouseListener{
    nuevotratamientomodelo modelo = new nuevotratamientomodelo();
    nuevoTratamiento ventana;

    
     public enum AccionMVC{
         __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO,
        __ACTUALIZAR_USUARIO,
        __MODIFICAR_USUARIO
    }

    public nuevoTratamientoControlador(nuevoTratamiento vista){
        this.ventana = vista;
        
        this.modelo.llenarComboDptos(this.ventana.JCBfuncionario);
        this.ventana.jtxtcoditrata.setText(String.valueOf(this.modelo.numeroderegistro()));
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
        
        this.ventana.jTbltratamiento.addMouseListener(this);
        this.ventana.jTbltratamiento.setModel(new DefaultTableModel());
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_USUARIO:{
                    this.ventana.jTbltratamiento.setModel(this.modelo.Gettablatratamiento());
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(false);
                    this.ventana.jtxtcodifuncio.setEditable(false);
                    this.ventana.jtxtcoditrata.setEditable(false);
                    this.ventana.jTextojustificacion.setEditable(false);
                    this.ventana.JCBfuncionario.setEditable(false);
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jtxtcodifuncio.setText("");
                    this.ventana.jtxtcoditrata.setText("");
                    this.ventana.jTextojustificacion.setText("");
                    this.ventana.JCBfuncionario.setSelectedIndex(0);                    
                    this.ventana.jtxtcodiPQRSM.setEnabled(false);
                    this.ventana.jtxtcodifuncio.setEnabled(false);
                    this.ventana.jtxtcoditrata.setEnabled(false);
                    this.ventana.jTextojustificacion.setEnabled(false);
                    this.ventana.JCBfuncionario.setEnabled(false);
                    
                    this.ventana.jBtnEliminar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(false);
                    
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    
                    this.ventana.jtxtcodiPQRSM.setEditable(true);
                    this.ventana.jtxtcodifuncio.setEditable(true);
                    this.ventana.jtxtcoditrata.setEditable(true);
                    this.ventana.jTextojustificacion.setEditable(true);
                    this.ventana.JCBfuncionario.setEditable(true);
                    this.ventana.jtxtcodiPQRSM.setText("");
                    this.ventana.jtxtcodifuncio.setText("");
                    this.ventana.jtxtcoditrata.setText("");
                    this.ventana.jTextojustificacion.setText("");
                    this.ventana.JCBfuncionario.setSelectedIndex(0);
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jtxtcodifuncio.setEnabled(true);
                    this.ventana.jtxtcoditrata.setEnabled(true);
                    this.ventana.jTextojustificacion.setEnabled(true);
                    this.ventana.JCBfuncionario.setEnabled(true);
                    
                    
                    this.ventana.jBtnAgregar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    
                    
                    break;
                }
                case __AGREGAR_USUARIO:{
                    
                        if (this.modelo.NuevoUsuario(this.ventana.jtxtcoditrata.getText(), 
                                this.ventana.jtxtcodifuncio.getText(), this.ventana.jtxtcodiPQRSM.getText(), 
                                this.ventana.jTextojustificacion.getText(), (String) this.ventana.JCBfuncionario.getSelectedItem())){
                            
                                this.ventana.jTbltratamiento.setModel(this.modelo.Gettablatratamiento());
                                JOptionPane.showMessageDialog(ventana,"Usuario Registrado!.");
                                
                                    this.ventana.jtxtcodiPQRSM.setEditable(false);
                                    this.ventana.jtxtcodifuncio.setEditable(false);
                                    this.ventana.jtxtcoditrata.setEditable(false);
                                    this.ventana.jTextojustificacion.setEditable(false);
                                    this.ventana.JCBfuncionario.setEditable(false);
                                    this.ventana.jtxtcodiPQRSM.setText("");
                                    this.ventana.jtxtcodifuncio.setText("");
                                    this.ventana.jtxtcoditrata.setText("");
                                    this.ventana.jTextojustificacion.setText("");
                                    this.ventana.JCBfuncionario.setSelectedIndex(0);                    
                                    this.ventana.jtxtcodiPQRSM.setEnabled(false);
                                    this.ventana.jtxtcodifuncio.setEnabled(false);
                                    this.ventana.jtxtcoditrata.setEnabled(false);
                                    this.ventana.jTextojustificacion.setEnabled(false);
                                    this.ventana.JCBfuncionario.setEnabled(false);
                                
                                    this.ventana.jBtnAgregar.setEnabled(false);
                                    this.ventana.jBtnAdicionar.setEnabled(true);
                           
                        }
                        else
                            JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                    
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    
                    if (this.modelo.EliminarUsuario(this.ventana.jtxtcoditrata.getText())){
                        this.ventana.jTbltratamiento.setModel(this.modelo.Gettablatratamiento());
                        JOptionPane.showMessageDialog(ventana,"Usuario eliminado.");
                            
                            this.ventana.jtxtcodiPQRSM.setEditable(false);
                            this.ventana.jtxtcodifuncio.setEditable(false);
                            this.ventana.jtxtcoditrata.setEditable(false);
                            this.ventana.jTextojustificacion.setEditable(false);
                            this.ventana.JCBfuncionario.setEditable(false);
                            this.ventana.jtxtcodiPQRSM.setText("");
                            this.ventana.jtxtcodifuncio.setText("");
                            this.ventana.jtxtcoditrata.setText("");
                            this.ventana.jTextojustificacion.setText("");
                            this.ventana.JCBfuncionario.setSelectedIndex(0);                    
                            this.ventana.jtxtcodiPQRSM.setEnabled(false);
                            this.ventana.jtxtcodifuncio.setEnabled(false);
                            this.ventana.jtxtcoditrata.setEnabled(false);
                            this.ventana.jTextojustificacion.setEnabled(false);
                            this.ventana.JCBfuncionario.setEnabled(false);
                            
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                    }else{
                    
                        JOptionPane.showMessageDialog(ventana,"No se ha seleccionado un registro.!");
                    
                    }
                    break;       
                }
                
                case __ACTUALIZAR_USUARIO:{
                     
                    if(this.modelo.Actualizar(this.ventana.jtxtcoditrata.getText(), this.ventana.jTextojustificacion.getText(), (String) this.ventana.JCBfuncionario.getSelectedItem())){
                    
                    this.ventana.jTbltratamiento.setModel(this.modelo.Gettablatratamiento());
                    
                    JOptionPane.showMessageDialog(ventana,"Datos Actualizados Correctamente!.");
                    
                        this.ventana.jtxtcodiPQRSM.setEditable(false);
                        this.ventana.jtxtcodifuncio.setEditable(false);
                        this.ventana.jtxtcoditrata.setEditable(false);
                        this.ventana.jTextojustificacion.setEditable(false);
                        this.ventana.JCBfuncionario.setEditable(false);
                        this.ventana.jtxtcodiPQRSM.setText("");
                        this.ventana.jtxtcodifuncio.setText("");
                        this.ventana.jtxtcoditrata.setText("");
                        this.ventana.jTextojustificacion.setText("");
                        this.ventana.JCBfuncionario.setSelectedIndex(0);                    
                        this.ventana.jtxtcodiPQRSM.setEnabled(false);
                        this.ventana.jtxtcodifuncio.setEnabled(false);
                        this.ventana.jtxtcoditrata.setEnabled(false);
                        this.ventana.jTextojustificacion.setEnabled(false);
                        this.ventana.JCBfuncionario.setEnabled(false);
                    
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
                    this.ventana.jtxtcoditrata.setEditable(true);
                    this.ventana.jTextojustificacion.setEditable(true);
                    this.ventana.JCBfuncionario.setEditable(true);
                    
                    this.ventana.jtxtcodiPQRSM.setEnabled(true);
                    this.ventana.jtxtcodifuncio.setEnabled(true);
                    this.ventana.jtxtcoditrata.setEnabled(true);
                    this.ventana.jTextojustificacion.setEnabled(true);
                    this.ventana.JCBfuncionario.setEnabled(true);
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
             int fila = this.ventana.jTbltratamiento.rowAtPoint(e.getPoint());
             if (fila > -1){
                 
                this.ventana.jtxtcoditrata.setText(String.valueOf(
                        this.ventana.jTbltratamiento.getValueAt(fila, 0)));
                this.ventana.jtxtcodiPQRSM.setText(String.valueOf(
                        this.ventana.jTbltratamiento.getValueAt(fila, 1)));
                this.ventana.jtxtcodifuncio.setText(String.valueOf(
                        this.ventana.jTbltratamiento.getValueAt(fila, 2)));
                this.ventana.jTextojustificacion.setText(String.valueOf(
                        this.ventana.jTbltratamiento.getValueAt(fila, 3)));
                
               
                String funcionario = String.valueOf(this.ventana.jTbltratamiento.getValueAt(fila, 4));
                int i = this.ventana.JCBfuncionario.getSelectedIndex();
                while(i > 7){
                
                    if(funcionario.equals(i)){
                    
                      this.ventana.JCBfuncionario.setSelectedIndex(i);
                      
                      i += 1;
                        
                    }
                
                }
                    
                }
                this.ventana.jtxtcodiPQRSM.setEditable(false);
                this.ventana.jtxtcoditrata.setEnabled(false);
                this.ventana.jtxtcodifuncio.setEditable(false);
                this.ventana.jTextojustificacion.setEnabled(false);
                             
             }
        }
}
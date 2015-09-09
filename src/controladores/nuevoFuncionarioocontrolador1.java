package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.nuevofuncionariomodelo;

import vistas.nuevoFuncionario;
/**
 * @author Ricardo Palacio P.
 */
public class nuevoFuncionarioocontrolador1 implements ActionListener,MouseListener{
    nuevofuncionariomodelo modelo = new nuevofuncionariomodelo();
    
    nuevoFuncionario ventana;

    public enum AccionMVC{
         __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO,
        __ACTUALIZAR_USUARIO,
        __MODIFICAR_USUARIO
    }

    public nuevoFuncionarioocontrolador1(nuevoFuncionario vista){
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
        
        this.ventana.jTbFuncionario.addMouseListener(this);
        this.ventana.jTbFuncionario.setModel(new DefaultTableModel());
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getButton() == 1)//boton izquierdo
        {
             int fila = this.ventana.jTbFuncionario.rowAtPoint(e.getPoint());
             if (fila > -1){ 
                 
                this.ventana.jtxtcodisegui.setText(String.valueOf(
                        this.ventana.jTbFuncionario.getValueAt(fila, 0)));
                this.ventana.jtxtnombre.setText(String.valueOf(
                        this.ventana.jTbFuncionario.getValueAt(fila, 1)));
                this.ventana.jtxtCargo.setText(String.valueOf(
                        this.ventana.jTbFuncionario.getValueAt(fila, 2)));
                
                        
                    }
                    
                }
                this.ventana.jtxtcodisegui.setEditable(false);
                this.ventana.jtxtnombre.setEditable(false);
                this.ventana.jtxtCargo.setEditable(false);
                  
                this.ventana.jBtnEliminar.setEnabled(true);
                this.ventana.jBtnAdicionar.setEnabled(true);
                this.ventana.jBtnAgregar.setEnabled(false);
                
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
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_USUARIO:{
                    this.ventana.jTbFuncionario.setModel(this.modelo.getTablafuncionario());
                    this.ventana.jtxtcodisegui.setEditable(false);
                    this.ventana.jtxtnombre.setEditable(false);
                    this.ventana.jtxtCargo.setEditable(false);
                    this.ventana.jtxtcodisegui.setText("");
                    this.ventana.jtxtnombre.setText("");
                    this.ventana.jtxtCargo.setText("");
                    this.ventana.jtxtcodisegui.setEnabled(false);
                    this.ventana.jtxtnombre.setEnabled(false);
                    this.ventana.jtxtCargo.setEnabled(false);
                    
                    this.ventana.jBtnEliminar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(false);
                    
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    this.ventana.jtxtcodisegui.setEditable(true);
                    this.ventana.jtxtnombre.setEditable(true);
                    this.ventana.jtxtCargo.setEditable(true);
                    this.ventana.jtxtnombre.requestFocus();
                    this.ventana.jtxtcodisegui.setText("");
                    this.ventana.jtxtnombre.setText("");
                    this.ventana.jtxtCargo.setText("");
                    this.ventana.jtxtcodisegui.setEnabled(true);
                    this.ventana.jtxtnombre.setEnabled(true);
                    this.ventana.jtxtCargo.setEnabled(true);
                    
                    this.ventana.jBtnAgregar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    
                    break;
                }
                case __AGREGAR_USUARIO:{
                    
                        if (this.modelo.Nuevofuncionario(this.ventana.jtxtcodisegui.getText(), 
                                this.ventana.jtxtnombre.getText(), this.ventana.jtxtCargo.getText())){
                            
                                this.ventana.jTbFuncionario.setModel(this.modelo.getTablafuncionario());
                                JOptionPane.showMessageDialog(ventana,"Usuario Registrado!.");
                                
                            this.ventana.jtxtcodisegui.setEditable(false);
                            this.ventana.jtxtnombre.setEditable(false);
                            this.ventana.jtxtCargo.setEditable(false);
                            this.ventana.jtxtcodisegui.setText("");
                            this.ventana.jtxtnombre.setText("");
                            this.ventana.jtxtCargo.setText("");
                            this.ventana.jtxtcodisegui.setEnabled(false);
                            this.ventana.jtxtnombre.setEnabled(false);
                            this.ventana.jtxtCargo.setEnabled(false);
                            this.ventana.jBtnAgregar.setEnabled(false);
                            this.ventana.jBtnAdicionar.setEnabled(true);
                            
                        }
                        else
                            JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                    
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    
                    if (this.modelo.Eliminarfuncionario(this.ventana.jtxtcodisegui.getText())){
                        this.ventana.jTbFuncionario.setModel(this.modelo.getTablafuncionario());
                        JOptionPane.showMessageDialog(ventana,"Usuario eliminado.");
                        
                           this.ventana.jtxtcodisegui.setEditable(false);
                            this.ventana.jtxtnombre.setEditable(false);
                            this.ventana.jtxtCargo.setEditable(false);
                            this.ventana.jtxtcodisegui.setText("");
                            this.ventana.jtxtnombre.setText("");
                            this.ventana.jtxtCargo.setText("");
                            this.ventana.jtxtcodisegui.setEnabled(false);
                            this.ventana.jtxtnombre.setEnabled(false);
                            this.ventana.jtxtCargo.setEnabled(false);
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                            
                    }
                    break;       
                }
                
                case __ACTUALIZAR_USUARIO:{
                   
                    if(this.modelo.Actualizar(this.ventana.jtxtcodisegui.getText(), 
                                this.ventana.jtxtnombre.getText(), this.ventana.jtxtCargo.getText())){
                    
                    this.ventana.jTbFuncionario.setModel(this.modelo.getTablafuncionario());
                    
                    JOptionPane.showMessageDialog(ventana,"Datos Actualizados Correctamente!.");
                    
                            this.ventana.jtxtcodisegui.setEditable(false);
                            this.ventana.jtxtnombre.setEditable(false);
                            this.ventana.jtxtCargo.setEditable(false);
                            this.ventana.jtxtcodisegui.setText("");
                            this.ventana.jtxtnombre.setText("");
                            this.ventana.jtxtCargo.setText("");
                            this.ventana.jtxtcodisegui.setEnabled(false);
                            this.ventana.jtxtnombre.setEnabled(false);
                            this.ventana.jtxtCargo.setEnabled(false);
                            this.ventana.jBtnEliminar.setEnabled(false);
                            this.ventana.jbtnactualizar.setEnabled(false);
                            this.ventana.jBtnAdicionar.setEnabled(true);
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                            
                    
                    }else{
                  
                    JOptionPane.showMessageDialog(ventana,"Por favor digite informacion en los campos vacios.!");
                   
                  
                  }
                
                     break;
                }
                
                case __MODIFICAR_USUARIO:{
                    
                    this.ventana.jtxtcodisegui.setEditable(true);
                    this.ventana.jtxtnombre.setEditable(true);
                    this.ventana.jtxtCargo.setEditable(true);
                    this.ventana.jtxtnombre.requestFocus();
                    this.ventana.jtxtcodisegui.setEnabled(true);
                    this.ventana.jtxtnombre.setEnabled(true);
                    this.ventana.jtxtCargo.setEnabled(true);
                   
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    this.ventana.jbtnactualizar.setEnabled(true);
                    
                
                }
            }
    }    
 
}

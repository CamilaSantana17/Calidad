package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.nuevousuarioModelo;

import vistas.NuevoUsiario;
/**
 * @author Ricardo Palacio P.
 */
public class nuevousuariocontrolador implements ActionListener,MouseListener{
    nuevousuarioModelo modelo = new nuevousuarioModelo();
    String documentoanterior ;
    NuevoUsiario ventana;

    public enum AccionMVC{
         __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO,
        __ACTUALIZAR_USUARIO,
        __MODIFICAR_USUARIO
    }

    public nuevousuariocontrolador(NuevoUsiario vista){
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
        
        this.ventana.jTblUsuarios.addMouseListener(this);
        this.ventana.jTblUsuarios.setModel(new DefaultTableModel());
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getButton() == 1)//boton izquierdo
        {
             int fila = this.ventana.jTblUsuarios.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.ventana.jtxtdocu.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 0)));
                this.ventana.jtxtNombre.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 1)));
                this.ventana.jtxtApellido.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 2)));
                this.ventana.jtxtdirecc.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 3)));
                this.ventana.jtxtTelefono.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 4)));
                this.ventana.jtxtMail.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 5)));
                this.ventana.jtxtcelular.setText(String.valueOf(
                        this.ventana.jTblUsuarios.getValueAt(fila, 6)));
                String tipopersona = String.valueOf(this.ventana.jTblUsuarios.getValueAt(fila, 7));
                
                if("Estudiante".equals(tipopersona)){
                     this.ventana.JRBVisitante.setSelected(false);
                     this.ventana.JRBProveedor.setSelected(false);
                     this.ventana.JRBFamiEstu.setSelected(false);
                     this.ventana.JRBestuiante.setSelected(true);
                
                }else{
                
                    if("Familiar Estudiante".equals(tipopersona)){
                        this.ventana.JRBVisitante.setSelected(false);
                        this.ventana.JRBestuiante.setSelected(false);
                        this.ventana.JRBProveedor.setSelected(false);
                        this.ventana.JRBFamiEstu.setSelected(true);
                    }else{
                    
                        if("Visitante".equals(tipopersona)){
                            this.ventana.JRBProveedor.setSelected(false);
                            this.ventana.JRBestuiante.setSelected(false);
                            this.ventana.JRBFamiEstu.setSelected(false);
                            this.ventana.JRBVisitante.setSelected(true);
                        }else{
                            this.ventana.JRBVisitante.setSelected(false);
                            this.ventana.JRBestuiante.setSelected(false);
                            this.ventana.JRBFamiEstu.setSelected(false);
                            this.ventana.JRBProveedor.setSelected(true);   
                        }
                        
                    }
                    
                }
                this.ventana.jtxtNombre.setEditable(false);
                this.ventana.jtxtApellido.setEditable(false);
                this.ventana.jtxtTelefono.setEditable(false);
                this.ventana.jtxtdocu.setEditable(false);
                this.ventana.jtxtdirecc.setEditable(false);
                this.ventana.jtxtMail.setEditable(false);
                this.ventana.jtxtcelular.setEditable(false);   
                this.ventana.jBtnEliminar.setEnabled(true);
                this.ventana.jBtnAdicionar.setEnabled(true);
                this.ventana.jBtnAgregar.setEnabled(false);
                
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
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_USUARIO:{
                    this.ventana.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                    this.ventana.jtxtNombre.setEditable(false);
                    this.ventana.jtxtApellido.setEditable(false);
                    this.ventana.jtxtTelefono.setEditable(false);
                    this.ventana.jtxtdocu.setEditable(false);
                    this.ventana.jtxtdirecc.setEditable(false);
                    this.ventana.jtxtMail.setEditable(false);
                    this.ventana.jtxtcelular.setEditable(false);
                    this.ventana.jtxtNombre.requestFocus();
                    this.ventana.jtxtNombre.setText("");
                    this.ventana.jtxtApellido.setText("");
                    this.ventana.jtxtTelefono.setText("");
                    this.ventana.jtxtdocu.setText("");
                    this.ventana.jtxtdirecc.setText("");
                    this.ventana.jtxtMail.setText("");
                    this.ventana.jtxtcelular.setText("");
                    this.ventana.tipouser.clearSelection();
                    this.ventana.jtxtNombre.setEnabled(false);
                    this.ventana.jtxtApellido.setEnabled(false);
                    this.ventana.jtxtTelefono.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnAgregar.setEnabled(false);
                    this.ventana.jtxtdocu.setEnabled(false);
                    this.ventana.jtxtdirecc.setEnabled(false);
                    this.ventana.jtxtMail.setEnabled(false);
                    this.ventana.jtxtcelular.setEnabled(false);  
                    this.ventana.JRBFamiEstu.setEnabled(false);
                    this.ventana.JRBProveedor.setEnabled(false);
                    this.ventana.JRBVisitante.setEnabled(false);
                    this.ventana.JRBestuiante.setEnabled(false);
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    this.ventana.jtxtNombre.setEditable(true);
                    this.ventana.jtxtApellido.setEditable(true);
                    this.ventana.jtxtTelefono.setEditable(true);
                    this.ventana.jtxtdocu.setEditable(true);
                    this.ventana.jtxtdirecc.setEditable(true);
                    this.ventana.jtxtMail.setEditable(true);
                    this.ventana.jtxtcelular.setEditable(true);
                    this.ventana.jtxtNombre.requestFocus();
                    this.ventana.jtxtNombre.setText("");
                    this.ventana.jtxtApellido.setText("");
                    this.ventana.jtxtTelefono.setText("");
                    this.ventana.jtxtdocu.setText("");
                    this.ventana.jtxtdirecc.setText("");
                    this.ventana.jtxtMail.setText("");
                    this.ventana.jtxtcelular.setText("");
                    this.ventana.tipouser.clearSelection();
                    this.ventana.jBtnAgregar.setEnabled(true);
                    this.ventana.jBtnAdicionar.setEnabled(false);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    this.ventana.jtxtNombre.setEnabled(true);
                    this.ventana.jtxtApellido.setEnabled(true);
                    this.ventana.jtxtTelefono.setEnabled(true);
                    this.ventana.jtxtdocu.setEnabled(true);
                    this.ventana.jtxtdirecc.setEnabled(true);
                    this.ventana.jtxtMail.setEnabled(true);
                    this.ventana.jtxtcelular.setEnabled(true);
                    this.ventana.JRBFamiEstu.setEnabled(true);
                    this.ventana.JRBProveedor.setEnabled(true);
                    this.ventana.JRBVisitante.setEnabled(true);
                    this.ventana.JRBestuiante.setEnabled(true);
                    break;
                }
                case __AGREGAR_USUARIO:{
                    
                        if (this.modelo.NuevoUsuario(this.ventana.jtxtdocu.getText(),
                            this.ventana.jtxtNombre.getText(),
                            this.ventana.jtxtApellido.getText(),
                            this.ventana.jtxtdirecc.getText(),
                            this.ventana.jtxtTelefono.getText(),
                            this.ventana.jtxtMail.getText(),
                            this.ventana.jtxtcelular.getText(),
                            this.ventana.tipopersona)){
                            
                                this.ventana.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                                JOptionPane.showMessageDialog(ventana,"Usuario Registrado!.");
                                
                            this.ventana.jtxtNombre.setEditable(false);
                            this.ventana.jtxtApellido.setEditable(false);
                            this.ventana.jtxtTelefono.setEditable(false);
                            this.ventana.jtxtdocu.setEditable(false);
                            this.ventana.jtxtdirecc.setEditable(false);
                            this.ventana.jtxtMail.setEditable(false);
                            this.ventana.jtxtcelular.setEditable(false);
                            this.ventana.jtxtNombre.requestFocus();
                            this.ventana.jtxtNombre.setText("");
                            this.ventana.jtxtApellido.setText("");
                            this.ventana.jtxtTelefono.setText("");
                            this.ventana.jtxtdocu.setText("");
                            this.ventana.jtxtdirecc.setText("");
                            this.ventana.jtxtMail.setText("");
                            this.ventana.jtxtcelular.setText("");
                            this.ventana.tipouser.clearSelection();
                            this.ventana.jBtnAgregar.setEnabled(false);
                            this.ventana.jBtnAdicionar.setEnabled(true);
                            this.ventana.jtxtNombre.setEnabled(false);
                            this.ventana.jtxtApellido.setEnabled(false);
                            this.ventana.jtxtTelefono.setEnabled(false);
                            this.ventana.jtxtdocu.setEnabled(false);
                            this.ventana.jtxtdirecc.setEnabled(false);
                            this.ventana.jtxtMail.setEnabled(false);
                            this.ventana.jtxtcelular.setEnabled(false);
                            this.ventana.JRBFamiEstu.setEnabled(false);
                            this.ventana.JRBProveedor.setEnabled(false);
                            this.ventana.JRBVisitante.setEnabled(false);
                            this.ventana.JRBestuiante.setEnabled(false);
                        }
                        else
                            JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                    
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    
                    if (this.modelo.EliminarUsuario(this.ventana.jtxtdocu.getText())){
                        this.ventana.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                        JOptionPane.showMessageDialog(ventana,"Usuario eliminado.");
                            this.ventana.jtxtNombre.setEditable(false);
                            this.ventana.jtxtApellido.setEditable(false);
                            this.ventana.jtxtTelefono.setEditable(false);
                            this.ventana.jtxtdocu.setEditable(false);
                            this.ventana.jtxtdirecc.setEditable(false);
                            this.ventana.jtxtMail.setEditable(false);
                            this.ventana.jtxtcelular.setEditable(false);
                            this.ventana.jtxtNombre.requestFocus();
                            this.ventana.jtxtNombre.setText("");
                            this.ventana.jtxtApellido.setText("");
                            this.ventana.jtxtTelefono.setText("");
                            this.ventana.jtxtdocu.setText("");
                            this.ventana.jtxtdirecc.setText("");
                            this.ventana.jtxtMail.setText("");
                            this.ventana.jtxtcelular.setText("");
                            this.ventana.tipouser.clearSelection();
                            this.ventana.jtxtNombre.setEnabled(false);
                            this.ventana.jtxtApellido.setEnabled(false);
                            this.ventana.jtxtTelefono.setEnabled(false);
                            this.ventana.jBtnEliminar.setEnabled(false);
                            this.ventana.jtxtdocu.setEnabled(false);
                            this.ventana.jtxtdirecc.setEnabled(false);
                            this.ventana.jtxtMail.setEnabled(false);
                            this.ventana.jtxtcelular.setEnabled(false);  
                            this.ventana.JRBFamiEstu.setEnabled(false);
                            this.ventana.JRBProveedor.setEnabled(false);
                            this.ventana.JRBVisitante.setEnabled(false);
                            this.ventana.JRBestuiante.setEnabled(false);
                            this.ventana.jBtnEliminar.setEnabled(false);
                            
                    }
                    break;       
                }
                
                case __ACTUALIZAR_USUARIO:{
                   
                    if(this.modelo.Actualizar(documentoanterior,this.ventana.jtxtdocu.getText(),
                            this.ventana.jtxtNombre.getText(),
                            this.ventana.jtxtApellido.getText(),
                            this.ventana.jtxtdirecc.getText(),
                            this.ventana.jtxtTelefono.getText(),
                            this.ventana.jtxtMail.getText(),
                            this.ventana.jtxtcelular.getText(),
                            this.ventana.tipopersona)){
                    
                    this.ventana.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                    
                    JOptionPane.showMessageDialog(ventana,"Datos Actualizados Correctamente!.");
                    
                    this.ventana.jtxtNombre.setEditable(false);
                            this.ventana.jtxtApellido.setEditable(false);
                            this.ventana.jtxtTelefono.setEditable(false);
                            this.ventana.jtxtdocu.setEditable(false);
                            this.ventana.jtxtdirecc.setEditable(false);
                            this.ventana.jtxtMail.setEditable(false);
                            this.ventana.jtxtcelular.setEditable(false);
                            this.ventana.jtxtNombre.requestFocus();
                            this.ventana.jtxtNombre.setText("");
                            this.ventana.jtxtApellido.setText("");
                            this.ventana.jtxtTelefono.setText("");
                            this.ventana.jtxtdocu.setText("");
                            this.ventana.jtxtdirecc.setText("");
                            this.ventana.jtxtMail.setText("");
                            this.ventana.jtxtcelular.setText("");
                            this.ventana.tipouser.clearSelection();
                            this.ventana.jbtnactualizar.setEnabled(false);
                            this.ventana.jBtnAdicionar.setEnabled(true);
                            this.ventana.jBtnEliminar.setEnabled(true);
                            this.ventana.jtxtNombre.setEnabled(false);
                            this.ventana.jtxtApellido.setEnabled(false);
                            this.ventana.jtxtTelefono.setEnabled(false);
                            this.ventana.jtxtdocu.setEnabled(false);
                            this.ventana.jtxtdirecc.setEnabled(false);
                            this.ventana.jtxtMail.setEnabled(false);
                            this.ventana.jtxtcelular.setEnabled(false);
                            this.ventana.JRBFamiEstu.setEnabled(false);
                            this.ventana.JRBProveedor.setEnabled(false);
                            this.ventana.JRBVisitante.setEnabled(false);
                            this.ventana.JRBestuiante.setEnabled(false);
                            
                    
                    }else{
                  
                    JOptionPane.showMessageDialog(ventana,"Por favor digite informacion en los campos vacios.!");
                   
                  
                  }
                
                     break;
                }
                
                case __MODIFICAR_USUARIO:{
                    
                    documentoanterior = ventana.jtxtdocu.getText();
                    
                    this.ventana.jBtnAdicionar.setEnabled(true);
                    this.ventana.jBtnEliminar.setEnabled(false);
                    this.ventana.jbtnactualizar.setEnabled(true);
                    this.ventana.jtxtNombre.setEditable(true);
                    this.ventana.jtxtApellido.setEditable(true);
                    this.ventana.jtxtTelefono.setEditable(true);
                    this.ventana.jtxtdocu.setEditable(true);
                    this.ventana.jtxtdirecc.setEditable(true);
                    this.ventana.jtxtMail.setEditable(true);
                    this.ventana.jtxtcelular.setEditable(true);
                    this.ventana.JRBFamiEstu.setEnabled(true);
                    this.ventana.JRBProveedor.setEnabled(true);
                    this.ventana.JRBVisitante.setEnabled(true);
                    this.ventana.JRBestuiante.setEnabled(true);
                    this.ventana.jtxtNombre.setEnabled(true);
                    this.ventana.jtxtApellido.setEnabled(true);
                    this.ventana.jtxtTelefono.setEnabled(true);
                    this.ventana.jtxtdocu.setEnabled(true);
                    this.ventana.jtxtdirecc.setEnabled(true);
                    this.ventana.jtxtMail.setEnabled(true);
                    this.ventana.jtxtcelular.setEnabled(true);
                
                }
            }
    }    
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sala221
 */
public class nuevousuarioModelo extends Conexion{
    
    public boolean Actualizar(String docuanterior, String Documento, String Nombre, String Apellido, String Direccion, 
                              String Telefono, String Mail,String Celular, String Tipousuario){
        
        boolean bandera = false;
      if(valida_datos(Documento,Nombre,Apellido,Direccion,Telefono,Mail,Celular,Tipousuario)){  
       
        
        String sql = "UPDATE usuario SET docu = '"+Documento+"', nombre = '"+Nombre+"', apellido = '"+Apellido+"', direccion = '"+Direccion+"', telefono ='"+Telefono+"', E_Mail = '"+Mail+"', movil = '"+Celular+"',tipo_usuario = '"+Tipousuario+"' WHERE usuario.docu = '"+docuanterior+"';";                       
        try {                            
            try (PreparedStatement sentencia = this.getConexion().prepareStatement(sql)) {
                sentencia.execute();
                sentencia.close();
                bandera = true;
            }
            
        }catch(SQLException e){                
        }}
      
        return bandera;
       
    }
    
    public DefaultTableModel getTablaUsuario(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"Documento","Nombre","Apellido","Direccion","Telefono","E-Mail","Celular","Tipo de usuario"};

      try{
         String sql = "SELECT count(*) as Total FROM usuario;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              numregistros = resultado.getInt("Total");
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][8];
      try{
         String sql = "Select docu, nombre, apellido, direccion, telefono, E_Mail, movil, tipo_usuario from usuario;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          ResultSet resultado = sentencia.executeQuery() ;
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("docu");
                  datos[i][1] = resultado.getString("nombre");
                  datos[i][2] = resultado.getString("apellido");
                  datos[i][3] = resultado.getString("direccion");
                  datos[i][4] = resultado.getString("telefono");
                  datos[i][5] = resultado.getString("E_Mail");
                  datos[i][6] = resultado.getString("movil");
                  datos[i][7] = resultado.getString("tipo_usuario");
                  i++;
              }
              resultado.close();
         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }
    
    
    public boolean NuevoUsuario(String Documento, String Nombre, String Apellido, String Direccion, String Telefono, String Mail,String Celular, String Tipousuario){
        if(valida_datos(Documento,Nombre,Apellido,Direccion,Telefono,Mail,Celular,Tipousuario)){            

            String sql = "Insert into usuario "
                       +"values('"+Documento+"','"+Nombre+"','"+Apellido+"','"+Direccion+"','"+Telefono+"','"+Mail+"','"+Celular+"','"+Tipousuario+"');";                       

            try {
                try (PreparedStatement sentencia = this.getConexion().prepareStatement(sql)) {
                    sentencia.execute();
                    
                    sentencia.close();
                }
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Usuario ya existe!");
            }
            return false;
        }else
           return false;
    }
    
    
    public boolean EliminarUsuario(String documento){
        boolean bandera = false;
        
        String sql = "Delete from usuario where docu = '"+documento+"';";
        
        try {
            PreparedStatement sentencia = getConexion().prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            bandera = true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
        return bandera;
    }
    
    
     private boolean valida_datos(String Nombre, String Apellido , String Documento , String direccion, String telefono, 
             String mail, String celular, String tipopersona){
         
         
        if(Nombre.length() > 0 && Apellido.length() > 0 && Documento.length()> 0 && direccion.length() > 0 && telefono.length() > 0 && mail.length() > 0
                && celular.length() > 0 && tipopersona.length() > 0 ){
            
            return true;
        }else 
            return false;
    }
    
}

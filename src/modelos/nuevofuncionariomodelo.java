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
public class nuevofuncionariomodelo extends Conexion{
    
    public boolean Actualizar(String numfunci , String nombre, String Cargo){
        
        boolean bandera = false;
      if(valida_datos(nombre,Cargo)){  
       
        
        String sql = "UPDATE funcionario SET Nombre = '"+nombre+"', Cargo = '"+Cargo+"' WHERE funcionario.idFuncionario = '"+numfunci+"';";                       
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
    
    public DefaultTableModel getTablafuncionario(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"No.","Nombre completo","Cargo que ejecuta"};

      try{
         String sql = "SELECT count(*) as Total FROM funcionario;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              numregistros = resultado.getInt("Total");
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][3];
      try{
         String sql = "Select * from funcionario;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          ResultSet resultado = sentencia.executeQuery() ;
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("idFuncionario");
                  datos[i][1] = resultado.getString("Nombre");
                  datos[i][2] = resultado.getString("Cargo");
                  
                  i++;
              }
              resultado.close();
         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }
    
    
    public boolean Nuevofuncionario(String numfunci , String nombre, String Cargo){
        if(numfunci.length() > 0 && valida_datos(nombre,Cargo)){            

            String sql = "Insert into funcionario "
                       +"values('"+numfunci+"','"+nombre+"','"+Cargo+"');";                       

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
    
    
    public boolean Eliminarfuncionario(String numfunci){
        boolean bandera = false;
        
        String sql = "Delete from funcionario where idFuncionario = '"+numfunci+"';";
        
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
    
    
     private boolean valida_datos(String nombre, String Cargo){
         
         
        if(nombre.length() > 0 && Cargo.length() > 0 ){
            
            return true;
        }else 
            return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sala221
 */
public class nuevotratamientomodelo extends Conexion{
    
    public int numeroderegistro(){
        
        int Valor = 0;
        
        try{
         String sql = "SELECT count(*) as Total FROM tratamiento;";;
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              Valor = resultado.getInt("Total") + 1;
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
        
        return Valor;
    }
    
    public void llenarComboDptos(JComboBox funcionario){
        
            try{
                Statement sentencia = getConexion().createStatement();
                String sql = "select Nombre from funcionario;";
                
                ResultSet resultado = sentencia.executeQuery(sql);
                
                while (resultado.next()){
                    funcionario.addItem(resultado.getString("Nombre"));
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error SQL: "+ex.getMessage());
            }
        
    }
    
    public boolean Actualizar(String coditrata,String justificacion, String nombrefuncionario){
        
        boolean bandera = false;
      if(valida_datos(justificacion,  nombrefuncionario)){  
       
        
        String sql = "UPDATE tratamiento SET   Justi_Area ='"+justificacion+"', Nom_Funci = '"+nombrefuncionario+"' WHERE tratamiento.CodiTrata = '"+coditrata+"';";                       
       
        
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
    
    
    
    public DefaultTableModel Gettablatratamiento(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"Codigo tratamiento","Codigo Funcionario","Codigo del PQRSM","Justificacion del area asignada","Nombre del funcionario"};

      try{
         String sql = "SELECT count(*) as Total FROM tratamiento;";;
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              numregistros = resultado.getInt("Total");
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][5];
      try{
         String sql = "Select * from tratamiento;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("CodiTrata");
                  datos[i][1] = resultado.getString("idFuncionario");
                  datos[i][2] = resultado.getString("No");
                  datos[i][3] = resultado.getString("Justi_Area");
                  datos[i][4] = resultado.getString("Nom_Funci");
                  
                  
                  i++;
              }
          }
         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }
    
    
    public boolean NuevoUsuario(String coditrata, String codifuncionario, String codiPQRSM ,String justificacion, String nombrefuncionario){
        if(codiPQRSM.length() > 0 && valida_datos(  justificacion,  nombrefuncionario)){            

            String sql = "Insert into tratamiento "
                       +"values('"+coditrata+"','"+codifuncionario+"','"+codiPQRSM+"','"+justificacion+"','"+nombrefuncionario+"');";  
            

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
    
    
    public boolean EliminarUsuario(String CodiTrata){
        boolean bandera = false;
        if(CodiTrata.length() > 0){     
        String sql = "Delete from tratamiento where CodiTrata = '"+CodiTrata+"';";
        
        try {
            try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {
                sentencia.executeUpdate();
            }
            bandera = true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }}
        return bandera;
    }
    
    
     private boolean valida_datos(String justificacion, String nombrefuncionario){
         
        return justificacion.length() > 0 && nombrefuncionario.length() > 0 ;
        
    }
    
}

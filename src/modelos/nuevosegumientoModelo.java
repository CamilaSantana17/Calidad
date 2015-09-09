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
public class nuevosegumientoModelo extends Conexion{
    
    public boolean Actualizar(String numseguianterior, String Numsegui, String numPQRSM, String FechaSegui1, String Obser, String FechaSegui2, String Resulsatis, String Cierretrata){
        
        boolean bandera = false;
      if(valida_datos(Numsegui,  numPQRSM,  FechaSegui1,  Obser,  FechaSegui2,  Resulsatis,  Cierretrata)){  
       
        
        String sql = "UPDATE segumiento SET  No = '"+numPQRSM+"', Fech_Segui = '"+FechaSegui1+"', Observaciones = '"+Obser+"', Fech_Segui2 ='"+FechaSegui2+"', Resul_Satis_user = '"+Resulsatis+"' WHERE segumiento.CodiSegui = '"+numseguianterior+"';";                       
        String Sql = "UPDATE pqrsm SET Cierre_Queja = '"+Cierretrata+"' where pqrsm.No = '"+numPQRSM+"';";
        
        try {                            
            try (PreparedStatement sentencia = this.getConexion().prepareStatement(sql); PreparedStatement Sentencia = this.getConexion().prepareStatement(Sql)) {
                
                sentencia.execute();
                Sentencia.execute();
                
                bandera = true;
                
            }
        }catch(SQLException e){                
        }}
      
        return bandera;
       
    }
    
    
    
    public DefaultTableModel Gettablaseguimiento(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"Numero de seguimento","numero de PQRSM","Fecha de Seguimiento 1","Observaciones","Fecha de Seguimiento 2","Resultado satisfaccion del usuario","Cierre de queja"};

      try{
         String sql = "SELECT ((SELECT count(*) FROM segumiento) + (SELECT count(*) FROM pqrsm)) AS Total;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              numregistros = resultado.getInt("Total");
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][7];
      try{
         String sql = "Select * from segumiento s, pqrsm p where s.No = p.No;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("CodiSegui");
                  datos[i][1] = resultado.getString("No");
                  datos[i][2] = resultado.getString("Fech_Segui");
                  datos[i][3] = resultado.getString("Observaciones");
                  datos[i][4] = resultado.getString("Fech_Segui2");
                  datos[i][5] = resultado.getString("Resul_Satis_user");
                  datos[i][6] = resultado.getString("Cierre_Queja");
                  
                  i++;
              }
          }
         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }
    
    
    public boolean NuevoUsuario(String Numsegui, String numPQRSM, String FechaSegui1, String Obser, String FechaSegui2, String Resulsatis, String Cierretrata){
        if(valida_datos( Numsegui,  numPQRSM,  FechaSegui1,  Obser,  FechaSegui2,  Resulsatis,  Cierretrata)){            

            String sql = "Insert into segumiento "
                       +"values('"+Numsegui+"','"+numPQRSM+"','"+FechaSegui1+"','"+Obser+"','"+FechaSegui2+"','"+Resulsatis+"');";  
            
            String sql2 = "UPDATE pqrsm SET Cierre_Queja = '"+Cierretrata+"' where pqrsm.No = '"+numPQRSM+"';";

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                PreparedStatement sentencia2 = this.getConexion().prepareStatement(sql2);
                
                    sentencia.execute();
                    sentencia2.execute();
                    
                    
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Usuario ya existe!");
            }
            return false;
        }else
           return false;
    }
    
    
    public boolean EliminarUsuario(String numsegui){
        boolean bandera = false;
        if(numsegui.length() > 0){     
        String sql = "Delete from segumiento where CodiSegui = '"+numsegui+"';";
        
        try {
            PreparedStatement sentencia = getConexion().prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            bandera = true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }}
        return bandera;
    }
    
    
     private boolean valida_datos(String Numsegui, String numPQRSM, String FechaSegui1, String Obser, String FechaSegui2, String Resulsatis, String Cierretrata){
         
         
        return Numsegui.length() > 0 && numPQRSM.length() > 0 && FechaSegui1.length() > 0 && Obser.length() > 0 && FechaSegui2.length() > 0 && Resulsatis.length() > 0
                && Cierretrata.length() > 0;
    }
    
}

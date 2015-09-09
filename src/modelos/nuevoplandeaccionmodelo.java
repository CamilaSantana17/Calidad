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
public class nuevoplandeaccionmodelo extends Conexion{
    
    public void llenarComboresponsable(JComboBox responsable){
        
            try{
                Statement sentencia = getConexion().createStatement();
                String sql = "select Nombre from funcionario;";
                
                ResultSet resultado = sentencia.executeQuery(sql);
                
                while (resultado.next()){
                    responsable.addItem(resultado.getString("Nombre"));
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error SQL: "+ex.getMessage());
            }
        
    }
    
    public boolean Actualizar(String codiplan,String Fecharecep, String fecharevi, String fechasolu, String taratamiento,
            String responsable, String fechacumpli, String fechaRTAuser, String medioRTA){
        
        boolean bandera = false;
      if(valida_datos(codiplan,  Fecharecep, fecharevi, fechasolu, taratamiento, responsable, fechacumpli, fechaRTAuser, medioRTA)){  
       
        
        String sql = "UPDATE plan_accion SET   Fech_Recep ='"+Fecharecep+"', Fech_Revi = '"+fecharevi+"', Fech_Solu = '"+fechasolu+"', Tratamiento = '"+taratamiento+"'"
                + ", Responsable = '"+responsable+"', Fech_Cump = '"+fechacumpli+"', Fech_Rta_Usu = '"+fechaRTAuser+"', Medio_Rta = '"+medioRTA+"'"
                + " WHERE plan_accion.CodiPA = '"+codiplan+"';";                       
       
        
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
    
    
    
    public DefaultTableModel gettablaplanaccion(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"No.","No. Funcionario","No. PQRSM","Fecha de recepcion","Fecha de revision","Fecha de solucion","Tratamiento","Responsable","Fecha de cumplimiento","Fecha Respuesta al usuario","Medio de respuesta"};

      try{
         String sql = "SELECT count(*) as Total FROM plan_accion;";;
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              resultado.next();
              numregistros = resultado.getInt("Total");
          }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][11];
      try{
         String sql = "Select * from plan_accion;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("CodiPA");
                  datos[i][1] = resultado.getString("idFuncionario");
                  datos[i][2] = resultado.getString("No");
                  datos[i][3] = resultado.getString("Fech_Recep");
                  datos[i][4] = resultado.getString("Fech_Revi");
                  datos[i][5] = resultado.getString("Fech_Solu");
                  datos[i][6] = resultado.getString("Tratamiento");
                  datos[i][7] = resultado.getString("Responsable");
                  datos[i][8] = resultado.getString("Fech_Cump");
                  datos[i][9] = resultado.getString("Fech_Rta_Usu");
                  datos[i][10] = resultado.getString("Medio_Rta");

                  
                  i++;
              }
          }
         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }
    
    
    public boolean Nuevoplanaccion(String codiplan, String codifuncio, String codiPQRSM,String Fecharecep, String fecharevi, String fechasolu, String taratamiento,
            String responsable, String fechacumpli, String fechaRTAuser, String medioRTA){
        if( codifuncio.length() > 0 && codiPQRSM.length() > 0 && valida_datos( codiplan,  Fecharecep, fecharevi,  fechasolu, taratamiento, responsable, fechacumpli, fechaRTAuser, medioRTA)){            

            String sql = "Insert into plan_accion values('"+codiplan+"','"+codifuncio+"','"+codiPQRSM+"','"+Fecharecep+"','"+fecharevi+"','"+fechasolu+"','"+taratamiento+"','"+responsable+"','"+fechacumpli+"','"+fechaRTAuser+"','"+medioRTA+"');";  
            

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
    
    
    public boolean Eliminarplanaccion(String Codiplan){
        boolean bandera = false;
        if(Codiplan.length() > 0){     
        String sql = "Delete from plan_accion where CodiPA = '"+Codiplan+"';";
        
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
    
    
     private boolean valida_datos(String codiplan,String Fecharecep, String fecharevi, String fechasolu, String taratamiento,
            String responsable, String fechacumpli, String fechaRTAuser, String medioRTA){
         
        return codiplan.length() > 0 &&  Fecharecep.length() > 0 && fecharevi.length() > 0 && fechasolu.length() > 0 &&
                taratamiento.length() > 0 && responsable.length() > 0 && fechacumpli.length() > 0 && fechaRTAuser.length() > 0 && medioRTA.length() > 0;
        
    }
    
}

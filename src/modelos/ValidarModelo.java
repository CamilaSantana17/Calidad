package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;


/**
 * @author Ricardo Palacio P.
 */
public class ValidarModelo extends Conexion{
    Principal vtnPrincipal = new Principal();
    PrincipalModelo modelo = new PrincipalModelo();
    
    public boolean validaEntrada(String usuario, String clave){
      boolean bandera = false;
      
      if(valida_datos(usuario, clave)){
        try{
            String sql = "Select * from Usuarios_Login "
                    + "where NombreUser = '"+usuario+"' and Clave = SHA1('"+clave+"');";
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            int i = 0;
            while(resultado.next()){
                bandera = true;
            }
            resultado.close();
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
      }else{
          JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios!");
      }
        return bandera;
    }
    
    public DefaultTableModel getTablaPrincipal(){
      DefaultTableModel tablamodelo = new DefaultTableModel();
      int numregistros = 0;
      String[] NombreColumnas = {"No.","Descripcion","Tipo de reporte","Fecha revision", "Fecha de solucion", "Observaciones"};

      try{
         String sql = "SELECT ((SELECT count(*) FROM pqrsm) + (SELECT count(*) FROM plan_Accion) + (SELECT count(*) FROM segumiento)) AS Total;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         resultado.next();
         numregistros = resultado.getInt("Total");
         resultado.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][6];
      try{
         String sql = "Select * from pqrsm p, plan_Accion a, segumiento s where p.No=a.No and p.No=s.No;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
          try (ResultSet resultado = sentencia.executeQuery()) {
              int i = 0;
              while(resultado.next()){
                  datos[i][0] = resultado.getString("No");
                  datos[i][1] = resultado.getString("Descripcion");
                  datos[i][2] = resultado.getString("Tipo_Opinion");
                  datos[i][3] = resultado.getString("Fech_Revi");
                  datos[i][4] = resultado.getString("Fech_Solu");
                  datos[i][5] = resultado.getString("Observaciones");
                  i++;
              }
          resultado.close();
          }

         tablamodelo.setDataVector(datos, NombreColumnas);
         
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    private boolean valida_datos(String usuario, String clave){
        if(usuario.length() > 0 && clave.length() > 0){
            return true;
        }else 
            return false;
    }
    
    

}

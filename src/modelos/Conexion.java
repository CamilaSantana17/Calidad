package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Ricardo Palacio P.
 */

public class Conexion {

  private final String db = "calidad.sql";
  private final String user = "root";
  private final String clave = "";
  private final String url = "jdbc:mysql://localhost/"+db;
  private final String driver = "com.mysql.jdbc.Driver";
  private Connection conexion = null;

   public Conexion(){
      try{
         Class.forName(driver);
         conexion = DriverManager.getConnection(url, user , clave);         
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Error de SQL: "+e.getMessage());
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null, "Error con el driver: "+e.getMessage());
      }
   }

   public Connection getConexion(){
      return this.conexion;
   }
}
package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Palacio P.
 */
public class PrincipalModelo extends Conexion{

    public boolean NuevoProducto(String codigo, String nombre, String precio, 
            String cantidad){
        if(valida_datos(codigo, nombre, precio, cantidad)){
            precio = precio.replace(",", ".");

            String sql = "Insert into Productos "
                       +"values('"+codigo+"','"+nombre+"','"+precio+"','"+cantidad+"');";                       

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Producto ya existe!");
            }
            return false;
        }else
           return false;
    }

    public boolean EliminarProducto(String codigo){
        boolean bandera = false;

        String sql = "Delete from Productos where Codi_Prod = '"+codigo+"';" ;

         try {
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            bandera = true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
        return bandera;
    }

    private boolean valida_datos(String codigo, String nombre , String precio,
            String cantidad){
        if(codigo.equals(" - "))
            return false;
        else if(nombre.length() > 0 && precio.length() > 0 && cantidad.length() 
                > 0){
            return true;
        }else 
            return false;
    }
}

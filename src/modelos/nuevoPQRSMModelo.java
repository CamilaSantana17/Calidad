/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.FrmNuevoPQRSM;

/**
 *
 * @author Sala221
 */
public class nuevoPQRSMModelo extends Conexion{
    
    FrmNuevoPQRSM vtnnuevo = new FrmNuevoPQRSM();

    public void mostrarRegisuser(String documento){        

        String sql = "SELECT * FROM usuario WHERE docu = '"+documento+"';";
        try {
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            ResultSet resultado = st.executeQuery(sql);
            
            while(resultado.next()){
                vtnnuevo.Jtxtnombre.setText(resultado.getString("nombre"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("apellido"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("direccion"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("telefono"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("E_Mail"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("movil"));
                vtnnuevo.Jtxtnombre.setText(resultado.getString("tipo_usuario"));
            }
            resultado.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
           
    }
    
//    public boolean mostrarRegisuser(String documento){
//        boolean rta = false;
//  
//        try {
//            String sql = "SELECT * FROM usuario WHERE docu = '"+documento+"';";
//            
//            Statement st = getConexion().createStatement();
//            try (ResultSet rs = st.executeQuery(sql)) {
//                nuevo.Jtxtnombre.setText(rs.getString("nombre"));
//                nuevo.JTxtApellido.setText(rs.getString("apellido"));
//                nuevo.JtxtDirecc.setText(rs.getString("direccion"));
//                nuevo.JtxtTel.setText(rs.getString("telefono"));
//                nuevo.JtxtMail.setText(rs.getString("E_Mail"));
//                nuevo.JtxtCel.setText(rs.getString("movil"));
//                nuevo.JtxtTipousuario.setText(rs.getString("tipo_usuario"));
//                
//                rta = true;
//                
//                rs.close();                
//                st.close();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(nuevoPQRSMModelo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rta;
//    
//       
//    }
    
//    public String NuevoPQRSM(String No,String docu, String Fecha, String tipoqueja, String descripcionqueja, String anexo, 
//             String nomimagen, FileInputStream imagen, String Descripcionanexo, String Recibo, String Nombrerecibe, String cargo ){
//             String Mensaje = "";
//        
//        if(valida_datos( No, docu, Fecha, tipoqueja,  descripcionqueja,  anexo,  nomimagen, imagen,  Descripcionanexo,  Recibo,  Nombrerecibe,  cargo)){            
//           String insertar = "insert into pqrsm(No,docu,Fecha,Tipo_Opinion,Descripcion,Anexo_Docu,Nom_Recibe,Cargo_recibe,Cierre_Queja,Medio_recibo) values (?,?,?,?,?,?,?,?,?,?)";
//        try {
//               try (PreparedStatement pst = getConexion().prepareStatement(insertar)) {
//                   pst.setString(1, No);
//                   pst.setString(2, docu);
//                   pst.setString(3, Fecha);
//                   pst.setString(4, tipoqueja);
//                   pst.setString(5, descripcionqueja);
//                   pst.setString(6, anexo);
//                   pst.setString(7, Nombrerecibe);
//                   pst.setString(8, cargo);
//                   pst.setString(9, "null");
//                   pst.setString(10, Recibo);
//                   
//                   int i = pst.executeUpdate();
//                   if(i>0){
//                       
//                       Mensaje = "Se guardo correctamente !";
//                       
//                   }else{
//                       
//                       Mensaje = "El PQRSM no se puede crear, por favor verifique los datos";
//                       
//                   }
//                   
//                   pst.close();
//               }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "El Producto ya existe!");           
//            }
//     
//        }
//        return Mensaje;
//   
//    }
//    
//     private boolean valida_datos(String No,String docu, String Fecha, String tipoqueja, String descripcionqueja, String anexo, 
//             String nomimagen, FileInputStream imagen, String Descripcionanexo, String Recibo, String Nombrerecibe, String cargo ){
//         
//         
//        if(No.length() > 0  && docu.length() > 0  && Fecha.length() > 0  && tipoqueja.length() > 0 && descripcionqueja.length() > 0 && anexo.length() > 0 && nomimagen.length() > 0 && imagen != null
//                && Descripcionanexo.length() > 0 && Recibo.length() > 0 && Nombrerecibe.length() > 0 && cargo.length() > 0){
//            
//            return true;
//        }else 
//            return false;
//    }
    
}

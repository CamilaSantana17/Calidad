/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;
import vistas.FrmNuevoPQRSM;
/**
 *
 * @author Sala221
 */
public class PpalnuevoPQRSM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new nuevoPQRSMControlador(new FrmNuevoPQRSM()).iniciar();
//         java.awt.EventQueue.invokeLater(new nuevoPQRSMControlador(new NuevoPQRSM())::iniciar);
    }
    
}

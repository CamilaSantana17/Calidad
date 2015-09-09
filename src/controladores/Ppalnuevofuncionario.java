/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;
import vistas.nuevoFuncionario;
/**
 *
 * @author Sala221
 */
public class Ppalnuevofuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new nuevoFuncionarioocontrolador1(new nuevoFuncionario())::iniciar);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcjavacrud;
import modelo.*;
import vista.*;
import controlador.*;
/**
 *
 * @author alexander
 */
public class Mvcjavacrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    JFCrud vistaC = new JFCrud();
    UsuarioDAO modeloC = new UsuarioDAO();
    ControladorCrud controlaC = new ControladorCrud(vistaC,modeloC);
    
    vistaC.setVisible(true);
    vistaC.setLocationRelativeTo(null);
    
    }
    
}

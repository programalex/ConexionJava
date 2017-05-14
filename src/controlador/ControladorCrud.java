/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexander
 */
public class ControladorCrud implements ActionListener {
    
    JFCrud vistaCRUD = new JFCrud();
    UsuarioDAO modeloCRUD = new UsuarioDAO();
    
    public ControladorCrud(JFCrud vistaCRUD,UsuarioDAO modeloCRUD){
    this.modeloCRUD = modeloCRUD;
    this.vistaCRUD = vistaCRUD;
    this.vistaCRUD.btnguardar.addActionListener(this);
    this.vistaCRUD.btnlistar.addActionListener(this);
}
    public void InicializarCrud(){
        
    }
    public void LlenarTabla(JTable tablaD){
     DefaultTableModel modeloT = new  DefaultTableModel();  
     tablaD.setModel(modeloT);
     modeloT.addColumn("id");
     modeloT.addColumn("nombre");
     modeloT.addColumn("edad");
     
     Object[] columna = new Object[3];
     int numResultados = modeloCRUD.Listusuario().size();
     for (int i = 0; i < numResultados; i++){
         columna[0] = modeloCRUD.Listusuario().get(i).getId();
         columna[1] = modeloCRUD.Listusuario().get(i).getNombre();
         columna[2] = modeloCRUD.Listusuario().get(i).getEdad();
         modeloT.addRow(columna);
     }
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==vistaCRUD.btnguardar){
            String id = vistaCRUD.txtid.getText();
            String nombre = vistaCRUD.txtnombre.getText();
            String edad = vistaCRUD.txtedad.getText();
            
            String respuestaResultados = modeloCRUD.insertarUduario(id, nombre, edad);
            if (respuestaResultados !=null ){
                JOptionPane.showMessageDialog(null,respuestaResultados);
            }else{
              JOptionPane.showMessageDialog(null,"Registro Error");  
            }
        }
        if (e.getSource()== vistaCRUD.btnlistar){
           LlenarTabla(vistaCRUD.jtdatos);
        }
    }
}

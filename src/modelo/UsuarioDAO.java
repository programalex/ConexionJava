/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author alexander
 */
public class UsuarioDAO {
    Conexion conexion;
    public UsuarioDAO(){
    conexion = new Conexion();
    }
    public String insertarUduario(String id,String nombre,String edad){
        String respuestaRegistro = null;
        try{ 
            Connection accesoDB = conexion.getConnection();
            CallableStatement cs = accesoDB.prepareCall("{call sp_insertarUsuario(?,?,?)}");
            cs.setString(1,id);
            cs.setString(2, nombre);
            cs.setString(3, edad);
            
            int numFEjecutadas = cs.executeUpdate();
            if (numFEjecutadas>0){
                respuestaRegistro="Registro Exitoso...";
            }
        }catch (Exception e){
        
    }
        return respuestaRegistro;
   
}
    public ArrayList<Usuario> Listusuario(){
        ArrayList listaUsuario = new ArrayList();
        Usuario usuario;
        try{
        Connection accesDB = conexion.getConnection();
        PreparedStatement ps = accesDB.prepareStatement("select * from usuario");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario = new Usuario();
            usuario.setId((rs.getString(1)));
            usuario.setNombre(rs.getString(2));
            usuario.setEdad(rs.getString(3));
            listaUsuario.add(usuario);
        }
        }catch (Exception e){
            
        }
        return listaUsuario;
    }
}

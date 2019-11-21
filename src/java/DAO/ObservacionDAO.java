/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD;
import Modelo.Tarea;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Roger
 */
public class ObservacionDAO implements MetodosCRUD.Metodos<Tarea>{
     private static final String SQL_UPDATE = "{call sp_modificar_obs(?,?)}";
     
     private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Tarea generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Tarea generico) {
         PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_tarea());
            pre.setString(2, generico.getObservacion());
            
            if(pre.executeUpdate()>0){
                return true;
            }
        } catch (Exception e) {
                
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Tarea generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarea> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

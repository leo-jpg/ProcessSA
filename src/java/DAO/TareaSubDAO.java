/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.TareaSub;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author RepjA
 */
public class TareaSubDAO implements Metodos<TareaSub>{
    private static final String SQL_INSERT = "{call sp_insertar_tarsub(?,?)}";
    
    private static final Conexion conexion = Conexion.estado();


    @Override
    public boolean create(TareaSub generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getNombre());
            pre.setInt(2, generico.getTarea_id_tarea());
            
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            conexion.cerrarConexion();
        }finally{
            return false;
        }
    }

    @Override
    public boolean update(TareaSub generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(TareaSub generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TareaSub> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

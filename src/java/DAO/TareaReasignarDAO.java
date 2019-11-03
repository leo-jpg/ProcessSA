/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.Tarea;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author RepjA
 */
public class TareaReasignarDAO implements Metodos<Tarea>{
    private static final String SQL_UPDATE = "{call sp_modificar_tar_asig(?,?,?)}";
    
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Tarea generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Tarea generico) {
        PreparedStatement pre;
        try{
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_tarea());
            pre.setInt(2, generico.getId_usuario_asignado());
            pre.setInt(3, generico.getEstado_tarea_id_estado());

            if (pre.executeUpdate() > 0) {
                return true;
            }
        }catch(Exception e){
            conexion.cerrarConexion();
        }finally{
            return false;
        }
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

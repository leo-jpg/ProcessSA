/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.Justificativo;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author RepjA
 */
public class JustificativoDAO implements Metodos<Justificativo>{
    private static final String SQL_INSERT = "{sp_insertar_jus(?,?)}";
    
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Justificativo generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getMensaje());
            pre.setInt(2, generico.getTarea_id_tarea());
            
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
    public boolean update(Justificativo generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Justificativo generico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Justificativo> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

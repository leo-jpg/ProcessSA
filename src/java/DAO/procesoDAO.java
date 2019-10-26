/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD;
import Interface.MetodosCRUD.Metodos;
import Modelo.Proceso;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Roger
 */
public class procesoDAO implements Metodos<Proceso>{
    
      private static final String SQL_INSERT = "{call sp_insertar_proceso(?,?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_proceso(?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_proceso(?,?,?)}";
    private static final String SQL_READALL = "{call sp_listar_proceso(?)}";

    //{call sp_listar_jerar()}
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Proceso generico) {
          PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getNombre());
            pre.setInt(2, generico.getUsuario_id_usuario());

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Proceso generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_proceso());
            pre.setString(2, generico.getNombre());
            pre.setInt(3, generico.getUsuario_id_usuario());
           

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
   
    @Override
    public boolean delete(Proceso generico) {
           PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_proceso());

            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {

        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public Usuario read(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proceso> readAll() {
       PreparedStatement pre;
        CallableStatement cstmt;
        Connection cn = conexion.getConnection();
        List<Proceso> lista = new ArrayList<Proceso>();
        try {
            pre = conexion.getConnection().prepareStatement(SQL_READALL);
            String llamadaProcedimiento = "{ call sp_listar_proceso(?) }";
             CallableStatement cs = cn.prepareCall(llamadaProcedimiento);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            
            while(rs.next()){
                Proceso pro = new Proceso();
                pro.setId_proceso(rs.getInt("id_proceso"));
                pro.setNombre(rs.getString("nombre"));
                pro.setUsuario_id_usuario(rs.getInt("usuario_id_usuario"));
            
                lista.add(pro);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
    }
    
    
}

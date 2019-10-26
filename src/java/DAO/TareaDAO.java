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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author RepjA
 */
public class TareaDAO implements Metodos<Tarea>{
    private static final String SQL_INSERT = "{call sp_insertar_tar(?,?,?,?,?,?,?,?,?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_tar(?,?,?,?,?,?,?,?,?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_tar(?)}";
    private static final String SQL_READALL = "{call sp_listar_tar(?)}";
    
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Tarea generico) {
        PreparedStatement pre;
        try{
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getNombre());
            pre.setString(2, generico.getDescripcion());
            pre.setDate(3, generico.getPlazo());
            pre.setInt(4, generico.getCumplimiento());
            pre.setInt(5, generico.getId_usuario_asignado());
            pre.setInt(6, generico.getUsuario_id_usuario());
            pre.setInt(7, generico.getProceso_id_proceso());
            pre.setInt(8, generico.getEstado_tarea_id_estado());
            pre.setInt(9, generico.getIndicador_id_indicador());

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
    public boolean update(Tarea generico) {
        PreparedStatement pre;
        try{
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_tarea());
            pre.setString(2, generico.getNombre());
            pre.setString(3, generico.getDescripcion());
            pre.setDate(4, generico.getPlazo());
            pre.setInt(5, generico.getCumplimiento());
            pre.setInt(6, generico.getId_usuario_asignado());
            pre.setInt(7, generico.getProceso_id_proceso());
            pre.setInt(8, generico.getEstado_tarea_id_estado());
            pre.setInt(9, generico.getIndicador_id_indicador());

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
        PreparedStatement pre;
        try{
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_tarea());
        
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
    public Usuario read(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarea> readAll() {
        List<Tarea> lista = new ArrayList<Tarea>();
        try {
            Connection cn = conexion.getConnection();
            CallableStatement cs = cn.prepareCall(SQL_READALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Tarea tarea = new Tarea();

                tarea.setId_tarea(rs.getInt("id_tarea"));
                tarea.setNombre(rs.getString("nombre"));               
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setPlazo(rs.getDate("plazo"));
                tarea.setCumplimiento(rs.getInt("cumplimiento"));
                tarea.setId_usuario_asignado(rs.getInt("id_usuario_asignado"));
                tarea.setUsuario_id_usuario(rs.getInt("usuario_id_usuario"));
                tarea.setProceso_id_proceso(rs.getInt("proceso_id_proceso"));
                tarea.setIndicador_id_indicador(rs.getInt("estado_tarea_id_estado"));
                tarea.setIndicador_id_indicador(rs.getInt("indicador_id_indicador"));
                lista.add(tarea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
    }
    
}

package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.UnidadInterna;
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
public class UnidadInternaDAO implements Metodos<UnidadInterna>{
    private static final String SQL_INSERT = "{call sp_insertar_unidad(?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_unidad(?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_unidad(?,?)}";
    private static final String SQL_READALL = "{call sp_listar_unidad(?)}";
    private static final Conexion conexion = Conexion.estado();
    
    @Override
    public boolean create(UnidadInterna generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getDescripcion());

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
    public boolean update(UnidadInterna generico) {
       PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_unidad());
            pre.setString(2, generico.getDescripcion());

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
    public boolean delete(UnidadInterna generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_unidad());

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
    public List<UnidadInterna> readAll() {
            PreparedStatement pre;
        CallableStatement cstmt;
        Connection cn = conexion.getConnection();
        List<UnidadInterna> lista = new ArrayList<UnidadInterna>();
        try {
            pre = conexion.getConnection().prepareStatement(SQL_READALL);
            String llamadaProcedimiento = "{ call sp_listar_unidad(?) }";
             CallableStatement cs = cn.prepareCall(llamadaProcedimiento);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            
            while(rs.next()){
                UnidadInterna unidad = new UnidadInterna();
                
                unidad.setId_unidad(rs.getInt("id_unidad"));
                unidad.setDescripcion(rs.getString("descripcion"));
            
                lista.add(unidad);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
         }
}
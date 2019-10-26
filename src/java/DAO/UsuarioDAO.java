package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
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
public class UsuarioDAO implements Metodos<Usuario>{
    private static final String SQL_INSERT = "{call sp_insertar_usuario(?,?,?,?,?,?,?,?,?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_usuario(?,?,?,?,?,?,?,?,?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_usuario(?)}";
    private static final String SQL_READALL = "{call sp_listar_usuario(?)}";
    private static final String SQL_READ = "{call sp_login(?,?,?,?)}";
    
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Usuario generico) {
         PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getUsuario());
            pre.setString(2, generico.getContrasena());
            pre.setString(3, generico.getNombre());
            pre.setString(4, generico.getApellido());
            pre.setInt(5, generico.getRol_id_rol());
            pre.setString(6, generico.getDireccion());
            pre.setString(7, generico.getRut());
            pre.setString(8, generico.getEmail());
            pre.setInt(9, generico.getUnidad_interna_id_unidad());
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
    public boolean update(Usuario generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_usuario());
            pre.setString(2, generico.getUsuario());
            pre.setString(3, generico.getContrasena());
            pre.setString(4, generico.getNombre());
            pre.setString(5, generico.getApellido());
            pre.setInt(6, generico.getRol_id_rol());
            pre.setString(7, generico.getDireccion());
            pre.setString(8, generico.getEmail());
            pre.setInt(9, generico.getUnidad_interna_id_unidad());
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
    public boolean delete(Usuario generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_usuario());

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
        int resultado = 0;
        int resultadoRol = 0;
        try{
            Connection cn = conexion.getConnection();
            CallableStatement cs = cn.prepareCall(SQL_READ);
            cs.setString(1, usuario.getUsuario());
            cs.setString(2, usuario.getContrasena());
            cs.registerOutParameter(3, OracleTypes.NUMERIC);
            cs.registerOutParameter(4, OracleTypes.NUMERIC);
            cs.executeUpdate();
            resultado = cs.getInt(3);
            resultadoRol = cs.getInt(4);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            conexion.cerrarConexion();
            usuario.setId_usuario(resultado);
            usuario.setRol_id_rol(resultadoRol);
            return usuario;
           
        }
    }

    @Override
    public List<Usuario> readAll() {

        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            Connection cn = conexion.getConnection();
            CallableStatement cs = cn.prepareCall(SQL_READALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setRut(rs.getString("rut"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRoldes(rs.getString("roldes"));
                usuario.setUnides(rs.getString("unides"));
                lista.add(usuario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
    }
    
}
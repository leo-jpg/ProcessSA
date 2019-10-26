/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.Rol;
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
public class RolDAO implements Metodos<Rol> {

    private static final String SQL_INSERT = "{call sp_insertar_rol(?,?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_rol(?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_rol(?,?,?)}";
    private static final String SQL_READALL = "{call sp_listar_rol(?)}";
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Rol generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_INSERT);
            pre.setString(1, generico.getDescripcion());
            pre.setInt(2, generico.getId_jerarquia());
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
    public boolean update(Rol generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_rol());
            pre.setString(2, generico.getDescripcion());
            pre.setInt(3, generico.getId_jerarquia());
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
    public boolean delete(Rol generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_rol());

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
    public List<Rol> readAll() {
        PreparedStatement pre;
        CallableStatement cstmt;
        Connection cn = conexion.getConnection();
        List<Rol> lista = new ArrayList<Rol>();
        try {
            pre = conexion.getConnection().prepareStatement(SQL_READALL);
            String llamadaProcedimiento = "{ call sp_listar_rol(?) }";
            CallableStatement cs = cn.prepareCall(llamadaProcedimiento);
            cs.registerOutParameter(1, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Rol rol = new Rol();

                rol.setId_rol(rs.getInt("id_rol"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setJerdes(rs.getString("jerdes"));

                lista.add(rol);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
    }
}
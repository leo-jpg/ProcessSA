/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.MetodosCRUD.Metodos;
import Modelo.Jerarquia;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author RepjA
 */
public class JerarquiaDAO implements Metodos<Jerarquia> {

    private static final String SQL_INSERT = "{call sp_insertar_jerar(?)}";
    private static final String SQL_DELETE = "{call sp_eliminar_jerar(?)}";
    private static final String SQL_UPDATE = "{call sp_modificar_jerar(?,?)}";
    private static final String SQL_READALL = "{call sp_listar_jerar(?)}";

    //{call sp_listar_jerar()}
    private static final Conexion conexion = Conexion.estado();

    @Override
    public boolean create(Jerarquia generico) {
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
    public boolean update(Jerarquia generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_UPDATE);
            pre.setInt(1, generico.getId_jerarquia());
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
    public boolean delete(Jerarquia generico) {
        PreparedStatement pre;
        try {
            pre = conexion.getConnection().prepareCall(SQL_DELETE);
            pre.setInt(1, generico.getId_jerarquia());

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
//    public List<Jerarquia> readAll() {
//        PreparedStatement pre;
//        ResultSet rs;
//            
//            ArrayList<Jerarquia> jerarquia = new ArrayList<>();
//        try {      
//            pre = conexion.getConnection().prepareStatement(SQL_READALL);
//            
//            rs = pre.executeQuery();
//            
//            while( rs.next() ) {
//                jerarquia.add(new Jerarquia(rs.getInt(1),rs.getString(2)));
//            }   
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }finally{
//            conexion.cerrarConexion();
//        }
//        return jerarquia;
//    }
    
    
    public List<Jerarquia> readAll(){
        PreparedStatement pre;
        CallableStatement cstmt;
        Connection cn = conexion.getConnection();
        List<Jerarquia> lista = new ArrayList<Jerarquia>();
        try {
            pre = conexion.getConnection().prepareStatement(SQL_READALL);
            String llamadaProcedimiento = "{ call sp_listar_jerar(?) }";
             CallableStatement cs = cn.prepareCall(llamadaProcedimiento);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            
            while(rs.next()){
                Jerarquia jerarquia = new Jerarquia();
                
                jerarquia.setId_jerarquia(rs.getInt("id_jerarquia"));
                jerarquia.setDescripcion(rs.getString("descripcion"));
            
                lista.add(jerarquia);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarConexion();
            return lista;
        }
    }

//        PreparedStatement ps;
//        ResultSet rs;
//        ArrayList<Jerarquia> lista = new ArrayList<Jerarquia>();
//
//        try {
//
//            ps = conexion.getConnection().prepareCall(SQL_READALL);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                lista.add(new Jerarquia(rs.getInt(1), rs.getString(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Jerarquia.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            conexion.cerrarConexion();
//        }
//
//        return lista;
//        List<Jerarquia> lista = null;
//
//        String sql = "{call sp_listar_jerar()}";
//
//        Connection cn = conexion.getConnection();
//        if (cn != null) {
//            try {
//                CallableStatement cs = cn.prepareCall(sql);
//
//                ResultSet rs = cs.executeQuery();
//                lista = new LinkedList<Jerarquia>();
//                while (rs.next()) {
//                    Jerarquia jerarquia = new Jerarquia();
//                    jerarquia.setId_jerarquia(rs.getInt(1));
//                    jerarquia.setDescripcion(rs.getString(2));
//
//                    lista.add(jerarquia);
//                }
//
//            } catch (Exception e) {
//
//            } finally {
//                conexion.cerrarConexion();
//            }
//            return lista
//        }
    }

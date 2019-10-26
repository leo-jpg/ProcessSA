/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Interface.Validacion;
import Modelo.Login;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author RepjA
 */
public class LoginDAO implements Validacion {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override

    public int validar(Usuario us) {
        int r = 0;
        String sql = "SELECT * FROM usuario WHERE usuario=? AND contrasena=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getContrasena());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                us.setUsuario(rs.getString("usuario"));
                us.setContrasena(rs.getString("contrasena"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }

    public int buscar(Usuario us) {
        int r = 0;
        String sql = "SELECT * FROM usuario WHERE id_rol = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, us.getId_rol());
            rs = ps.executeQuery();
            while(rs.next()){
                r = r + 1;
                us.setId_rol(rs.getInt("id_rol"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
            }catch (Exception e){
            return 0;
        }
        }
    }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Roger
 */
public class Conexion  {
    

    public static Conexion instancia; // Nos servira para utilizar el singleton.
    Connection con;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "TASK", "admin");
        } catch (Exception e) {
        }
        return con;
    }

    public synchronized static Conexion estado() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public void cerrarConexion() {
        instancia = null;
    }
    
    public Connection conexion() {
        return con;
    }
}

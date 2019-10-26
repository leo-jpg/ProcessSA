/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

/**
 *
 * @author RepjA
 */
public class conectionDB {

    
    public static void main(String[] args) {
        SQLclass query = new SQLclass();
        
        String consulta = "SELECT * FROM usuario";
        
        LinkedList<String> resultado=query.query(consulta);
        
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println(resultado.get(i));
        }
    }
    
}
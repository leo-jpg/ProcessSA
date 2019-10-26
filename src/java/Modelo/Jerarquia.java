/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author RepjA
 */
public class Jerarquia {
    private int id_jerarquia;
    private String descripcion;

    public Jerarquia() {
    }

    public Jerarquia(int id_jerarquia) {
        this.id_jerarquia = id_jerarquia;
    }
    

    public Jerarquia(String descripcion) {
        this.descripcion = descripcion;
    }

    public Jerarquia(int id_jerarquia, String descripcion) {
        this.id_jerarquia = id_jerarquia;
        this.descripcion = descripcion;
    }

    public int getId_jerarquia() {
        return id_jerarquia;
    }

    public void setId_jerarquia(int id_jerarquia) {
        this.id_jerarquia = id_jerarquia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
    
}



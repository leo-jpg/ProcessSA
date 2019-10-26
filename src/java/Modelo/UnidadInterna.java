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
public class UnidadInterna {
    private int id_unidad;
    private String descripcion;

    public UnidadInterna() {
        
    }

    public UnidadInterna(int id_unidad) {
        this.id_unidad = id_unidad;
    }
    
    
    public UnidadInterna(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public UnidadInterna(int id_unidad, String descripcion) {
        this.id_unidad = id_unidad;
        this.descripcion = descripcion;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UnidadInterna{" + "id_unidad=" + id_unidad + ", descripcion=" + descripcion + '}';
    }
    
}

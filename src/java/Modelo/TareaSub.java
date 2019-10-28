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
public class TareaSub {
    private int id_tareasub;
    private String nombre;
    private int tarea_id_tarea;

    public TareaSub() {
    }

    public TareaSub(String nombre, int tarea_id_tarea) {
        this.nombre = nombre;
        this.tarea_id_tarea = tarea_id_tarea;
    }
    
    

    public TareaSub(int id_tareasub, String nombre, int tarea_id_tarea) {
        this.id_tareasub = id_tareasub;
        this.nombre = nombre;
        this.tarea_id_tarea = tarea_id_tarea;
    }

    public int getId_tareasub() {
        return id_tareasub;
    }

    public void setId_tareasub(int id_tareasub) {
        this.id_tareasub = id_tareasub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarea_id_tarea() {
        return tarea_id_tarea;
    }

    public void setTarea_id_tarea(int tarea_id_tarea) {
        this.tarea_id_tarea = tarea_id_tarea;
    }

    @Override
    public String toString() {
        return "TareaSub{" + "id_tareasub=" + id_tareasub + ", nombre=" + nombre + ", tarea_id_tarea=" + tarea_id_tarea + '}';
    }
    
    
}

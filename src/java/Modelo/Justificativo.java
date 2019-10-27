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
public class Justificativo {
    private int id_justificativo;
    private String mensaje;
    private int tarea_id_tarea;

    public Justificativo() {
    }

    public Justificativo(String mensaje, int tarea_id_tarea) {
        this.mensaje = mensaje;
        this.tarea_id_tarea = tarea_id_tarea;
    }
    
    

  
    public Justificativo(int id_justificativo, String mensaje, int tarea_id_tarea) {
        this.id_justificativo = id_justificativo;
        this.mensaje = mensaje;
        this.tarea_id_tarea = tarea_id_tarea;
    }

    public int getId_justificativo() {
        return id_justificativo;
    }

    public void setId_justificativo(int id_justificativo) {
        this.id_justificativo = id_justificativo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTarea_id_tarea() {
        return tarea_id_tarea;
    }

    public void setTarea_id_tarea(int tarea_id_tarea) {
        this.tarea_id_tarea = tarea_id_tarea;
    }

    @Override
    public String toString() {
        return "Justificativo{" + "id_justificativo=" + id_justificativo + ", mensaje=" + mensaje + ", tarea_id_tarea=" + tarea_id_tarea + '}';
    }
    
    
}

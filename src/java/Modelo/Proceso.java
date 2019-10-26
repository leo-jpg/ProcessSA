/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Roger
 */
public class Proceso {
    private int id_proceso;
    private String nombre;
    private int usuario_id_usuario;

    public Proceso() {
        
    }

    public Proceso(int id_proceso) {
        this.id_proceso = id_proceso;
    }

    public Proceso(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Proceso(int id_proceso, String nombre, int usuario_id_usuario) {
        this.id_proceso = id_proceso;
        this.nombre = nombre;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public Proceso(String nombre, int usuario_id_usuario) {
        this.nombre = nombre;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getId_proceso() {
        return id_proceso;
    }

    public void setId_proceso(int id_proceso) {
        this.id_proceso = id_proceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    @Override
    public String toString() {
        return "Proceso{" + "id_proceso=" + id_proceso + ", nombre=" + nombre + ", usuario_id_usuario=" + usuario_id_usuario + '}';
    }
    
    
}

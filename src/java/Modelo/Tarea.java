/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author RepjA
 */
public class Tarea {
    private int id_tarea;
    private String nombre;
    private String descripcion;
    private Date plazo;
    private int cumplimiento;
    private int id_usuario_asignado;
    private int usuario_id_usuario;
    private int proceso_id_proceso;
    private int estado_tarea_id_estado;
    private int indicador_id_indicador;


    public Tarea() {
    }

    public Tarea(int id_tarea, int estado_tarea_id_estado) {
        this.id_tarea = id_tarea;
        this.estado_tarea_id_estado = estado_tarea_id_estado;
    }
    
    

    public Tarea(int id_tarea, String nombre, String descripcion, Date plazo, int cumplimiento, int id_usuario_asignado, int proceso_id_proceso, int estado_tarea_id_estado, int indicador_id_indicador) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plazo = plazo;
        this.cumplimiento = cumplimiento;
        this.id_usuario_asignado = id_usuario_asignado;
        this.proceso_id_proceso = proceso_id_proceso;
        this.estado_tarea_id_estado = estado_tarea_id_estado;
        this.indicador_id_indicador = indicador_id_indicador;
    }
    
    
    

    public Tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Tarea(int id_tarea, String nombre, String descripcion, Date plazo, int cumplimiento, int id_usuario_asignado, int usuario_id_usuario, int proceso_id_proceso, int estado_tarea_id_estado, int indicador_id_indicador) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plazo = plazo;
        this.cumplimiento = cumplimiento;
        this.id_usuario_asignado = id_usuario_asignado;
        this.usuario_id_usuario = usuario_id_usuario;
        this.proceso_id_proceso = proceso_id_proceso;
        this.estado_tarea_id_estado = estado_tarea_id_estado;
        this.indicador_id_indicador = indicador_id_indicador;
    }

    public Tarea(String nombre, String descripcion, Date plazo, int cumplimiento, int id_usuario_asignado, int usuario_id_usuario, int proceso_id_proceso, int estado_tarea_id_estado, int indicador_id_indicador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plazo = plazo;
        this.cumplimiento = cumplimiento;
        this.id_usuario_asignado = id_usuario_asignado;
        this.usuario_id_usuario = usuario_id_usuario;
        this.proceso_id_proceso = proceso_id_proceso;
        this.estado_tarea_id_estado = estado_tarea_id_estado;
        this.indicador_id_indicador = indicador_id_indicador;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getPlazo() {
        return plazo;
    }

    public void setPlazo(Date plazo) {
        this.plazo = plazo;
    }

    public int getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(int cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public int getId_usuario_asignado() {
        return id_usuario_asignado;
    }

    public void setId_usuario_asignado(int id_usuario_asignado) {
        this.id_usuario_asignado = id_usuario_asignado;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getProceso_id_proceso() {
        return proceso_id_proceso;
    }

    public void setProceso_id_proceso(int proceso_id_proceso) {
        this.proceso_id_proceso = proceso_id_proceso;
    }

    public int getEstado_tarea_id_estado() {
        return estado_tarea_id_estado;
    }

    public void setEstado_tarea_id_estado(int estado_tarea_id_estado) {
        this.estado_tarea_id_estado = estado_tarea_id_estado;
    }

    public int getIndicador_id_indicador() {
        return indicador_id_indicador;
    }

    public void setIndicador_id_indicador(int indicador_id_indicador) {
        this.indicador_id_indicador = indicador_id_indicador;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id_tarea=" + id_tarea + ", nombre=" + nombre + ", descripcion=" + descripcion + ", plazo=" + plazo + ", cumplimiento=" + cumplimiento + ", id_usuario_asignado=" + id_usuario_asignado + ", usuario_id_usuario=" + usuario_id_usuario + ", proceso_id_proceso=" + proceso_id_proceso + ", estado_tarea_id_estado=" + estado_tarea_id_estado + ", indicador_id_indicador=" + indicador_id_indicador + '}';
    }


  


}

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
public class Login {
    private int id_usuario;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int rol_id_rol;
    private String direccion;
    private String rut;
    private String email;
    private int unidad_interna_id_unidad;

    public Login() {
    }

    public Login(int id_usuario, String usuario, String contrasena, String nombre, String apellido, int rol_id_rol, String direccion, String rut, String email, int unidad_interna_id_unidad) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol_id_rol = rol_id_rol;
        this.direccion = direccion;
        this.rut = rut;
        this.email = email;
        this.unidad_interna_id_unidad = unidad_interna_id_unidad;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getRol_id_rol() {
        return rol_id_rol;
    }

    public void setRol_id_rol(int rol_id_rol) {
        this.rol_id_rol = rol_id_rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUnidad_interna_id_unidad() {
        return unidad_interna_id_unidad;
    }

    public void setUnidad_interna_id_unidad(int unidad_interna_id_unidad) {
        this.unidad_interna_id_unidad = unidad_interna_id_unidad;
    }

    @Override
    public String toString() {
        return "Login{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", rol_id_rol=" + rol_id_rol + ", direccion=" + direccion + ", rut=" + rut + ", email=" + email + ", unidad_interna_id_unidad=" + unidad_interna_id_unidad + '}';
    }
    
    
    
}

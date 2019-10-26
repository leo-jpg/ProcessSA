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
public class Usuario {
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
    private int id_rol;
    private int id_unidad;
    private String roldes;
    private String unides;
    private Rol tipoRol;
    
    public int getId_usuario(){
        return id_usuario;
    }
    
    public void setId_usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String usuario, String contrasena, String nombre, String apellido, String direccion, String rut, String email, String roldes, String unides) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.rut = rut;
        this.email = email;
        this.roldes = roldes;
        this.unides = unides;
    }

    public Rol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(Rol tipoRol) {
        this.tipoRol = tipoRol;
    }
    
    

    public String getRoldes() {
        return roldes;
    }

    public void setRoldes(String roldes) {
        this.roldes = roldes;
    }

    public String getUnides() {
        return unides;
    }

    public void setUnides(String unides) {
        this.unides = unides;
    }
    
    
    
    public Usuario() {
    }

    public Usuario(String usuario, String contrasena, int rol_id_rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol_id_rol = rol_id_rol;
    }

   
    
    

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    

    public Usuario(String usuario, String contrasena, String nombre, String apellido, String direccion, String rut, String email, int id_rol, int id_unidad) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.rut = rut;
        this.email = email;
        this.id_rol = id_rol;
        this.id_unidad = id_unidad;
    }
    
    

    public Usuario(String usuario, String contrasena, String nombre, String apellido, int rol_id_rol, String direccion, String rut, String email, int unidad_interna_id_unidad) {
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
    
    

    public Usuario(int id_usuario, String usuario, String contrasena, String nombre, String apellido, int rol_id_rol, String direccion, String rut, String email, int unidad_interna_id_unidad) {
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

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", rol_id_rol=" + rol_id_rol + ", direccion=" + direccion + ", rut=" + rut + ", email=" + email + ", unidad_interna_id_unidad=" + unidad_interna_id_unidad + ", id_rol=" + id_rol + ", id_unidad=" + id_unidad + '}';
    }


}
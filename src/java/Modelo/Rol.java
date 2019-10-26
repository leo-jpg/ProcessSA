package Modelo;

/**
 *
 * @author RepjA
 */
public class Rol {
    private int id_rol;
    private String descripcion;
    private Jerarquia jerarquia;
    private int id_jerarquia;
    private String jerdes;

    public Rol() {
    }

    public Rol(int id_rol, String descripcion, String jerdes) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
        this.jerdes = jerdes;
    }
    
    
    public Rol(int id_rol){
        this.id_rol = id_rol;
    }

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol(Jerarquia jerarquia) {
        this.jerarquia = jerarquia;
    }
    
    
    public Rol(String descripcion, int id_jerarquia) {
        this.descripcion = descripcion;
        this.id_jerarquia = id_jerarquia;
    }
    
    

    public Rol(String descripcion, Jerarquia jerarquia) {
        this.descripcion = descripcion;
        this.jerarquia = jerarquia;
    }

    public Rol(int id_rol, String descripcion, Jerarquia jerarquia) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
        this.jerarquia = jerarquia;
    }

    public Rol(int id_rol, String descripcion, int id_jerarquia) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
        this.id_jerarquia = id_jerarquia;
    }

    
    
    

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Jerarquia getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(Jerarquia jerarquia) {
        this.jerarquia = jerarquia;
    }

    public int getId_jerarquia() {
        return id_jerarquia;
    }

    public void setId_jerarquia(int id_jerarquia) {
        this.id_jerarquia = id_jerarquia;
    }

    public String getJerdes() {
        return jerdes;
    }

    public void setJerdes(String jerdes) {
        this.jerdes = jerdes;
    }
    
    

    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", descripcion=" + descripcion + ", jerarquia=" + jerarquia + ", id_jerarquia=" + id_jerarquia + '}';
    }
    
   
    
    
}

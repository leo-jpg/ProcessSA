/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RepjA
 */
public interface MetodosCRUD {
    public interface Metodos<Generico> {
    public boolean create(Generico generico); //
    public boolean update(Generico generico);
    public boolean delete(Generico generico);
    public Usuario read(Usuario usuario);
    public List<Generico> readAll();
}
}

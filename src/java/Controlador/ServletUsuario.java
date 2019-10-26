/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RepjA
 */
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");

        if (opcion.equals("Agregar")) {
            agregar(request, response);
        }
        if (opcion.equals("Modificar")) {
            modificar(request, response);
        }
        if (opcion.equals("Eliminar")) {
            eliminar(request, response);
        }
    }

    protected void agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user = request.getParameter("txtUser");
            String contrasena = request.getParameter("txtPass");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int id_rol = Integer.parseInt(request.getParameter("cboRol"));
            String direccion = request.getParameter("txtDireccion");
            String rut = request.getParameter("txtRut");
            String email = request.getParameter("txtEmail");
            int id_unidad = Integer.parseInt(request.getParameter("cboUnidad"));

            Usuario usuario = new Usuario(user, contrasena, nombre, apellido, id_rol, direccion, rut, email, id_unidad);
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.create(usuario)) {
                request.setAttribute("msjOK", "Usuario agregado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al agregar Usuario");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/agregarUsuario.jsp");
        }
    }
    
    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_usuario = Integer.parseInt(request.getParameter("cboIdUsuario"));
            String user = request.getParameter("txtUser");
            String contrasena = request.getParameter("txtPass");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int id_rol = Integer.parseInt(request.getParameter("cboRol"));
            String direccion = request.getParameter("txtDireccion");
            String rut = request.getParameter("txtRut");
            String email = request.getParameter("txtEmail");
            int id_unidad = Integer.parseInt(request.getParameter("cboUnidad"));

            Usuario usuario = new Usuario(id_usuario,user, contrasena, nombre, apellido, id_rol, direccion, rut, email, id_unidad);
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.update(usuario)) {
                request.setAttribute("msjOK", "Usuario Modificado Correctamente");
            } else {
                request.setAttribute("msjNO", "Error al Modificar Usuario");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/modificarUsuario.jsp");
        }
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            try {
                int id_usuario = Integer.parseInt(request.getParameter("cboIdUsuario"));

                Usuario usuario = new Usuario(id_usuario);
                UsuarioDAO dao = new UsuarioDAO();

                if (dao.delete(usuario)) {
                    request.setAttribute("msjOK", "Usuario eliminado correctamente");
                } else {
                    request.setAttribute("msjNO", "Error al eliminar Usuario");
                }
            } catch (Exception e) {
                request.setAttribute("msjNO", "Error: " + e.getMessage());
            } finally {
                response.sendRedirect("administrador/eliminarUsuario.jsp");
            }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

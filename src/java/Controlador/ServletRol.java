/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.RolDAO;
import Modelo.Rol;
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
public class ServletRol extends HttpServlet {

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
            String descripcion = request.getParameter("txtDescripcion");
            int id_jerarquia = Integer.parseInt(request.getParameter("cboJerarquia"));

            Rol rol = new Rol(descripcion, id_jerarquia);
            RolDAO dao = new RolDAO();

            if (dao.create(rol)) {
                request.setAttribute("msjOK", "Rol agregado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al agregar Rol");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/agregarRol.jsp");
        }
    }

    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_rol = Integer.parseInt(request.getParameter("cboRol"));
            String descripcion = request.getParameter("txtDescripcion");
            int id_jerarquia = Integer.parseInt(request.getParameter("cboJerarquia"));

            Rol rol = new Rol(id_rol, descripcion, id_jerarquia);
            RolDAO dao = new RolDAO();

            if (dao.update(rol)) {
                request.setAttribute("msjOK", "Rol modificado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al modificar el Rol");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/modificarRol.jsp");
        }

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            try {
                int id_rol = Integer.parseInt(request.getParameter("cboRol"));

                Rol rol = new Rol(id_rol);
                RolDAO dao = new RolDAO();

                if (dao.delete(rol)) {
                    request.setAttribute("msjOK", "Rol eliminado correctamente");
                } else {
                    request.setAttribute("msjNO", "Error al eliminar Rol");
                }
            } catch (Exception e) {
                request.setAttribute("msjNO", "Error: " + e.getMessage());
            } finally {
                response.sendRedirect("administrador/eliminarRol.jsp");
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

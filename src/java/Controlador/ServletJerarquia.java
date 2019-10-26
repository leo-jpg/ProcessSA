/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.JerarquiaDAO;
import Modelo.Jerarquia;
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
public class ServletJerarquia extends HttpServlet {

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
        if (opcion.equals("Eliminar")) {
            eliminar(request, response);
        }
        if (opcion.equals("Modificar")) {
            modificar(request, response);
        }
//        if (opcion.equals("Listar")) {
//            listar(request, response);
//        }
    }

    protected void agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String descripcion = request.getParameter("txtDescripcion");

            Jerarquia jerarquia = new Jerarquia(descripcion);
            JerarquiaDAO dao = new JerarquiaDAO();

            if (dao.create(jerarquia)) {
                request.setAttribute("msjOK", "Jerarquia agregada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al agregar Jerarquia");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/agregarJerarquia.jsp");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_jerarquia = Integer.parseInt(request.getParameter("cboJerarquia"));

            Jerarquia jerarquia = new Jerarquia(id_jerarquia);
            JerarquiaDAO dao = new JerarquiaDAO();

            if (dao.delete(jerarquia)) {
                request.setAttribute("msjOK", "Jerarquia eliminada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al eliminar Jerarquia");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/eliminarJerarquia.jsp");
        }
    }

    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_jerarquia = Integer.parseInt(request.getParameter("cboJerarquia"));
            String descripcion = request.getParameter("txtDescripcion");

            Jerarquia jerarquia = new Jerarquia(id_jerarquia, descripcion);
            JerarquiaDAO dao = new JerarquiaDAO();

            if (dao.update(jerarquia)) {
                request.setAttribute("msjOK", "Jerarquia modificada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al modificar Jerarquia");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("administrador/modificarJerarquia.jsp");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.procesoDAO;
import Modelo.Proceso;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RepjA
 */
public class ServletProceso extends HttpServlet {

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

    protected void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String nombre = request.getParameter("txtNombreProceso");     
////        int usuario_id_usuario = Integer.parseInt(request.getParameter("cboUsuario"));
            
            HttpSession se = request.getSession();
            int id = (int) se.getAttribute("id");
     
            Proceso pro = new Proceso(nombre, id);
            
            procesoDAO dao = new procesoDAO();

            if (dao.create(pro)) {

                request.setAttribute("msjOK", "Proceso agregado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al agregar Proceso");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("disenador/agregarProceso.jsp");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id_proceso = Integer.parseInt(request.getParameter("cboProcesoEliminar"));
            Proceso pro = new Proceso(id_proceso);

            procesoDAO dao = new procesoDAO();
            if (dao.delete(pro)) {
                request.setAttribute("msjOK", "Proceso eliminado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al eliminar Proceso");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("disenador/eliminarProceso.jsp");
        }
    }

    protected void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id_proceso = Integer.parseInt(request.getParameter("cboProceso"));
            String nombre = request.getParameter("txtNombreProceso");
            int usuario_id_usuario = Integer.parseInt(request.getParameter("cboUsuario"));

            Proceso pro = new Proceso(id_proceso, nombre, usuario_id_usuario);

            procesoDAO dao = new procesoDAO();

            if (dao.update(pro)) {
                request.setAttribute("msjOK", "Proceso modificado correctamente");
            } else {
                request.setAttribute("msjNO", "Error al modificar el Proceso");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("disenador/modificarProceso.jsp");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.EstadoDAO;
import DAO.TareaDAO;
import Modelo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RepjA
 */
public class ServletTarea extends HttpServlet {

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
        if (opcion.equals("Aceptar")) {
            aceptar(request, response);
        }
        if (opcion.equals("Rechazar")) {
            rechazar(request, response);
        }
    }

    protected void agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession se = request.getSession();
            int id = (int) se.getAttribute("id");

            String nombre = request.getParameter("txtNombre");
            String descripcion = request.getParameter("txtDescripcion");

//            String plazo = request.getParameter("DtPlazo");
            String plazo = request.getParameter("DtPlazo");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date formato = sdf.parse(plazo);
            java.sql.Date fecha = new java.sql.Date(formato.getTime());

            int cumplimiento = 0;
            String observacion = "0";
            int id_usu_asig = Integer.parseInt(request.getParameter("cboUsuario"));

            int id_proceso = Integer.parseInt(request.getParameter("cboProceso"));
            int id_estado = 1;
            int id_indicador = 1;
            int checkeado = 1;
            // check = "1";
            //char checkeado = check.charAt(0);

            //Tarea tarea = new Tarea();
            Tarea tarea = new Tarea(nombre, descripcion, fecha, cumplimiento, observacion, id_usu_asig, id, id_proceso, id_estado, id_indicador, checkeado);
            
//            Tarea tarea = new Tarea(responsable, fecha, descripcion, cumplimiento, id_usu_asig, id_indicador, nombre, id_proceso);
            TareaDAO dao = new TareaDAO();

            HttpSession ses = request.getSession();
            ses.setAttribute("sesion", tarea);
            
            if (dao.create(tarea)) {
                request.getSession().setAttribute("idtarea", tarea.getId_tarea());
                request.getSession().setAttribute("nombretarea", tarea.getNombre());
                request.setAttribute("msjOK", "Tarea agregada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al agregar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("funcionario/agregarTarea.jsp");
        }
    }

    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_tarea = Integer.parseInt(request.getParameter("cboID"));
            String nombre = request.getParameter("txtNombre");
            String descripcion = request.getParameter("txtDescripcion");

            String plazo = request.getParameter("DtPlazo");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date formato = sdf.parse(plazo);
            java.sql.Date fecha = new java.sql.Date(formato.getTime());
            int cumplimiento = 0;
            int id_usu_asig = Integer.parseInt(request.getParameter("cboUsuario"));
            int id_proceso = Integer.parseInt(request.getParameter("cboProceso"));
            int id_estado = Integer.parseInt(request.getParameter("cboEstado"));
            int id_indicador = Integer.parseInt(request.getParameter("cboIndicador"));

            Tarea tarea = new Tarea(id_tarea, nombre, descripcion, fecha, cumplimiento, id_usu_asig, id_proceso, id_estado, id_indicador);
            TareaDAO dao = new TareaDAO();

            if (dao.update(tarea)) {
                request.setAttribute("msjOK", "Tarea modificada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al modificar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("funcionario/modificarTarea.jsp");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id_tarea = Integer.parseInt(request.getParameter("cboID"));

            Tarea tarea = new Tarea(id_tarea);
            TareaDAO dao = new TareaDAO();

            if (dao.delete(tarea)) {
                request.setAttribute("msjOK", "Tarea eliminada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al eliminar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            response.sendRedirect("funcionario/eliminarTarea.jsp");
        }
    }

    protected void aceptar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int id_tarea = Integer.parseInt(request.getParameter("id"));
            int id_estado = 2;

            Tarea tarea = new Tarea(id_tarea, id_estado);
            EstadoDAO dao = new EstadoDAO();

            if (dao.update(tarea)) {
                request.setAttribute("msjOK", "Tarea aceptada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al aceptar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("procesoListaTareaSub").forward(request, response);
        }
    }

    protected void rechazar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int id_tarea = Integer.parseInt(request.getParameter("id"));
            int id_estado = 3;

            Tarea tarea = new Tarea(id_tarea, id_estado);
            EstadoDAO dao = new EstadoDAO();

            if (dao.update(tarea)) {
                request.setAttribute("msjOK", "Tarea rechazada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al rechazar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("procesoListaTareaSub").forward(request, response);
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

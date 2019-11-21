/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ObservacionDAO;
import Modelo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roger
 */
@WebServlet(name = "ServletObservacion", urlPatterns = {"/procesoModificarObservacion"})
public class ServletObservacion extends HttpServlet {

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
    
       int id = Integer.parseInt(request.getParameter("id"));

        HttpSession se = request.getSession();
        se.setAttribute("idTarea", id);

        request.getSession().setAttribute("idTa", id);
        request.getRequestDispatcher("subFuncionario/problemaTarea.jsp").forward(request, response);
       
           String opcion = request.getParameter("btnAccion");
          
           if (opcion.equals("Guardar")) {
            guardar(request, response);
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

    private void guardar(HttpServletRequest request, HttpServletResponse response)
    
     throws ServletException, IOException {
        try{
         int id_tarea = Integer.parseInt(request.getParameter("id"));
         String observacion = request.getParameter("txtObservacion");
         
         Tarea tarea = new Tarea(id_tarea, observacion);
         ObservacionDAO dao = new ObservacionDAO();
         if (dao.update(tarea)) {
                request.setAttribute("msjOK", "Tarea Ejecutada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al ejecutar Tarea");
            }    
    } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("procesotListaCumplimiento").forward(request, response);
        }
        }
}

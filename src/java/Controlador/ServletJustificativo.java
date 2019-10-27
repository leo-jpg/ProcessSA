/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.EstadoDAO;
import DAO.JustificativoDAO;
import Modelo.Justificativo;
import Modelo.Tarea;
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
public class ServletJustificativo extends HttpServlet {

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

        if (opcion.equals("Enviar")) {
            enviar(request, response);
        }
    }

    protected void enviar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String mensaje = request.getParameter("txtMensaje");
            
//            HttpSession se = request.getSession();
//            int id = (int) se.getAttribute("id");
            int id_tarea = Integer.parseInt(request.getParameter("id"));
//            int id_estado = 3;

            Justificativo justificativo = new Justificativo(mensaje, id_tarea);
            JustificativoDAO dao = new JustificativoDAO();

            if (dao.create(justificativo)) {
                request.setAttribute("msjOK", "Tarea aceptada correctamente");
            } else {
                request.setAttribute("msjNO", "Error al aceptar Tarea");
            }
        } catch (Exception e) {
            request.setAttribute("msjNO", "Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("procesoListaTareaSub").forward(request, response);
        }

//        try {
//       
//            int id_tarea = Integer.parseInt(request.getParameter("id"));
//            int id_estado = 3;
//   
//
//            Tarea tarea = new Tarea(id_tarea, id_estado);
//            EstadoDAO dao = new EstadoDAO();
//
//            if (dao.update(tarea)) {
//                request.setAttribute("msjOK", "Tarea rechazada correctamente");
//            } else {
//                request.setAttribute("msjNO", "Error al rechazar Tarea");
//            }
//        } catch (Exception e) {
//            request.setAttribute("msjNO", "Error: " + e.getMessage());
//        } finally {
//            request.getRequestDispatcher("procesoListaTareaSub").forward(request, response);
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

}

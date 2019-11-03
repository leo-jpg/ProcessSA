/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioDAO;
import Modelo.Tarea;
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
public class ServletLogin extends HttpServlet {

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

        if (opcion.equals("Ingresar")) {
            ingresar(request, response);
        }
    }

    protected void ingresar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String usu = request.getParameter("txtUsuario");
            String pass = request.getParameter("txtPass");

            Usuario usuario = new Usuario(usu, pass);
            
            //VALIDAMOS EL USUARIO
            UsuarioDAO dao = new UsuarioDAO();  
            
            HttpSession se = request.getSession();
            se.setAttribute("sesion", usuario);


            if (dao.read(usuario).getId_usuario()==0) {
                request.setAttribute("msjNO", "Credenciales Incorrectas");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                
//                 response.sendRedirect("administrador/menuAdmin.jsp");
            } else {
                try{
                if (usuario.getRol_id_rol()==1) {
                    request.getSession().setAttribute("usuario", usuario.getUsuario());
                    request.getSession().setAttribute("nombre", usuario.getNombre());
                    request.getSession().setAttribute("tipo", usuario.getRol_id_rol());
                    response.sendRedirect("administrador/menuAdmin.jsp");
                } else if (usuario.getRol_id_rol()==2) {
                    request.getSession().setAttribute("usuario", usuario.getUsuario());
                    request.getSession().setAttribute("id", usuario.getId_usuario());
                    request.getSession().setAttribute("responsable", usuario.getNombre());
                    request.getSession().setAttribute("tipo", usuario.getRol_id_rol());
                    response.sendRedirect("funcionario/index.jsp");
                } else if (usuario.getRol_id_rol()==3) {
                    request.getSession().setAttribute("usuario", usuario.getUsuario());
                    request.getSession().setAttribute("id", usuario.getId_usuario());
                    request.getSession().setAttribute("tipo", usuario.getRol_id_rol());
                    response.sendRedirect("disenador/index.jsp");
                } else if (usuario.getRol_id_rol()==4) {
                    request.getSession().setAttribute("usuario", usuario.getUsuario());
                    request.getSession().setAttribute("id", usuario.getId_usuario());
                    request.getSession().setAttribute("tipo", usuario.getRol_id_rol());
                    response.sendRedirect("subFuncionario/index.jsp");
                }
                }catch(Exception e){
                     request.getSession().setAttribute("mensaje", "Error: " + e.getMessage());
                }finally{
                    
                }
            
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

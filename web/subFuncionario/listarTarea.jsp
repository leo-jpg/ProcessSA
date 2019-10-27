<%-- 
    Document   : listarTarea
    Created on : 24-oct-2019, 16:29:38
    Author     : RepjA
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista tareas</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/popup.js"></script>
        <link rel="stylesheet" href="css/popup.css">

    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre, descripcion, plazo, cumplimiento, id_usuario_asignado, proceso_id_proceso, estado_tarea_id_estado, indicador_id_indicador 
            FROM tarea where id_usuario_asignado=${id}
        </sql:query> 

        <h1>Lista de tareas</h1><a href="index.jsp"><button>Volver</button></a>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>PLAZO</th>         
                    <th>CUMPLIMIENTO</th>
                    <th>USUARIO ASIGNADO</th>
                    <th>PROCESO</th>
                    <th>ESTADO TAREA</th>
                    <th>INDICADOR</th>
                    <th colspan="2">ACCIONES</th>
                </tr>           
            </thead>
            <c:forEach var="aux" items="${tipo.rows}">
                <tbody>
                    <tr>
                        <td>${aux.id_tarea}</td>
                        <td>${aux.nombre}</td>
                        <td>${aux.descripcion}</td>
                        <td>${aux.plazo}</td>
                        <td>${aux.cumplimiento}</td>
                        <td>${aux.id_usuario_asignado}</td>
                        <td>${aux.proceso_id_proceso}</td>
                        <td>${aux.estado_tarea_id_estado}</td>
                        <td>${aux.indicador_id_indicador}</td>
                        <td>
                            <form action="procesoTarea" method="POST">
                                <input type="hidden" name="id" value="${aux.id_tarea}">
                                <input type="submit" name="btnAccion" value="Aceptar">
                            </form>


                            <a href="#" class="active">Rechazar</a>    
                            <!--OPEN MODAL-->

                            <div class="modal">
                                <div class="modal-content">
                                    <div class="close">&times;</div>
                                    <h2>Justificativo</h2>
                                    <form action="procesoJustificativo" method="POST">
                                        <input type="hidden" name="id" value="${aux.id_tarea}">
                                        <textarea style="width: 300px; height: 100px;" name="txtMensaje"></textarea>
                                        <div class="buttons">
                                            <input type="submit" name="btnAccion" value="Enviar">                                      
                                        </div>  
                                    </form>
                                </div>
                            </div>
                            <!--CLOSE MODAL-->

                        </td>
                    </tr>

                </tbody>

            </c:forEach>
        </table>    

        <!--</form>-->
    </body>
</html>

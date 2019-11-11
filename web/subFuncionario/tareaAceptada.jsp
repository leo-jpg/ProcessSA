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

        <link rel="stylesheet" href="subFuncionario/css/popup.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"

    </head>
    <body>
        
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre, descripcion, plazo, cumplimiento, id_usuario_asignado, proceso_id_proceso, estado_tarea_id_estado, indicador_id_indicador 
            FROM tarea where id_usuario_asignado=${id} and estado_tarea_id_estado=2
        </sql:query> 
        <form action="procesoEjecutarTarea" method="POST">
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h1>Tareas recibidas</h1>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>DESCRIPCION</th>
                                <th>PLAZO</th>         
                                <th>CUMPLIMIENTO</th>
                                <th>PROCESO</th>
                                <th>ESTADO TAREA</th>
                                <th>INDICADOR</th>
                                <th>ACCION</th>
                                <th>OBSERVACION</th>
                            </tr>
                        </thead>
                        <c:forEach var="aux" items="${tipo.rows}">
                            <tbody>
                                <tr>
                                    <td>${aux.id_tarea}</td>
                                    <td>${aux.nombre}</td>
                                    <td>${aux.descripcion}</td>
                                    <td>${aux.plazo}</td>
                                    <!--<td>${aux.cumplimiento}</td>-->
                                    <td><input type="number" name="txtCumplimiento" value="${aux.cumplimiento}" min="0" max="100"></td>
                                    <td>${aux.proceso_id_proceso}</td>
                                    <td>${aux.estado_tarea_id_estado}</td>
                                    <td>${aux.indicador_id_indicador}</td>
                                    <td>
                                        
                                            <input type="hidden" name="id" value="${aux.id_tarea}">
                                            <input type="submit" name="btnAccion" value="Guardar Avance" class="btn btn-primary">
                                    
                                    </td>
                                    <!--
                                    <td>
                                        <textarea></textarea>
                                    </td>
                                    -->
                                </tr>
                            </tbody>  
                        </c:forEach>
                    </table>
                   <!--
                    <form action="procesoJustificativo" method="POST">
                        <div class="overlay" id="overlay">
                            <div class="popup" id="popup">
                                <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                                <h3>Justificación Tarea: ${aux.id_tarea}</h3>
                                <div class="contenedor-inputs">
                                    <textarea placeholder="Escriba aqui su justificación" name="txtMensaje"></textarea>
                                </div>
                                <input type="submit" name="btnAccion" class="btn-submit" value="Enviar">
                            </div>
                        </div> 
                        <script src="subFuncionario/js/popup.js"></script>
                    </form>
                    -->
                </div>
            </div>
            <br>
            <div style="text-align: right">
                <a href="subFuncionario/index.jsp"<button class="btn btn-success">Volver</a>
            </div>
        </div>
    </form>
    </body>
    
</html>


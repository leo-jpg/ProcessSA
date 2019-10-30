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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
        <title>Lista tareas rechazadas</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
         <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre, descripcion, plazo, cumplimiento, id_usuario_asignado, proceso_id_proceso, estado_tarea_id_estado, indicador_id_indicador FROM tarea 
            WHERE usuario_id_usuario = ${id} AND estado_tarea_id_estado = 3
        </sql:query> 
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h1>Tareas rechazadas</h1>
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
                                <th>USUARIO ASIGNADO</th>
                                <th>PROCESO</th>
                                <th>INDICADOR</th>
                                <th>ACCION</th>
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
                                    <td>${aux.indicador_id_indicador}</td>
                                    <td>
                                        <form action="reasignarTarea.jsp" method="POST">
                                            <input type="hidden" name="id" value="${aux.id_tarea}">
                                            <input type="submit" value="Reasignar" class="btn btn-primary">
                                        </form>
                                    </td>
                                </tr>
                            </tbody>  
                        </c:forEach>
                    </table> 
                   
                </div>
            </div>
            <br>
            <div style="text-align: right">
                <a href="index.jsp"<button class="btn btn-success">Volver</a>
            </div>
        </div>
            
    </body>
</html>


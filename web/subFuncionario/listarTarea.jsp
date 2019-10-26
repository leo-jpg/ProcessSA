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
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
         <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre, descripcion, plazo, cumplimiento, id_usuario_asignado, proceso_id_proceso, estado_tarea_id_estado, indicador_id_indicador FROM tarea where id_usuario_asignado=${id}
        </sql:query> 
        <h1>Lista de tareas</h1>
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
                        </tr>
                    </tbody>
                </c:forEach>
        </table>
    </body>
</html>

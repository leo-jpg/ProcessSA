<%-- 
    Document   : reasignarTarea
    Created on : 27-oct-2019, 19:46:23
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
        <title>Reasignar tarea</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre from tarea WHERE usuario_id_usuario = ${id}
        </sql:query> 
        <sql:query dataSource="${dataSource}" var="tipo2">
            SELECT id_usuario, usuario from usuario WHERE rol_id_rol = 4
        </sql:query> 
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h1>Reasignar tarea</h1>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <tr>
                            <td>Tarea</td>
                            <td><input type="text" name="txtNombre" value="" readonly=""></td>
                        </tr>
                        <tr>
                            <td>Nuevo usuario</td>
                            <td>
                                <select id="category" name="cboUsuario" required="">
                                    <c:forEach var="tipos" items="${tipo2.rows}">
                                        <option value="${tipos.id_usuario}">${tipos.usuario}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <td>

                            <input type="hidden" name="id" value="${aux.id_tarea}">
                            <a href="reasignarTarea.jsp"<button class="btn btn-primary">Reasignar</a>

                        </td>
                        </tr>
                        </tbody>  
           
                </table> 

            </div>
        </div>
        <br>
        <div style="text-align: right">
            <a href="listaTareaRechazada.jsp"<button class="btn btn-success">Volver</a>
        </div>
    </div>
</body>
</html>

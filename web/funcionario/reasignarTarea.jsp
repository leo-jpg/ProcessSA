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
        <title>Reasignar tarea</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre from tarea where usuario_id_usuario = ${id}
        </sql:query> 
        <h1>Reasignar tarea</h1>
        <form>
            Tarea:<br>
            <input type="text" name="txtNombre" value="" readonly=""><br>
            Nuevo usuario asignado:<br>               
                <select id="category" name="cboUsuario" required="">
                    <c:forEach var="tipos" items="${tipo.rows}">
                        <option value="${tipos.id_usuario}">${tipos.usuario}</option>
                    </c:forEach>
                </select><br>
                <input type="hidden" name="txtId" value="">
                <input type="submit" name="btnAccion" value="Asignar"><br>
                <a href="listaTareaRechazada.jsp">Volver</a>
        </form>
    </body>
</html>

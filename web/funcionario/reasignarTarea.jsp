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
        
         <!-- Libreria de Bootstrap-->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Fin Libreria -->
        
        <title>Reasignar tarea</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre FROM tarea WHERE id_tarea = ${idTar}
        </sql:query> 
        <sql:query dataSource="${dataSource}" var="tipo2">
            SELECT id_usuario, usuario FROM usuario WHERE rol_id_rol = 4
        </sql:query> 
        <div class="container mt-4">
            <div class="card">
                <form action="procesoReasignarTarea" method="POST">
                    <div class="card-header">
                        <c:forEach var="tipos" items="${tipo.rows}">
                            <h1 >Reasignar: ${tipos.nombre}</h1>
                        </c:forEach>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <tr hidden="">
                                <td>Tarea</td>                           
                                <td><input type="number" name="nbID" value="${idTar}" readonly=""></td>                           
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
                                <input type="submit" name="btnAccion" value="Asignar" class="btn btn-primary">
                            </td>
                            </tr>
                            </tbody>  

                        </table> 

                    </div>
                </form>
                <c:if test="${msjOK != null}">
                            <div class="alert alert-success">
                                <strong>Correcto!</strong> ${msjOK}.
                            </div>
                        </c:if>
                        <c:if test="${msjNO != null}">
                            <div class="alert alert-danger">
                                <strong>Error!</strong> ${msjNO}.
                            </div>
                        </c:if>
                <br>
                <div style="text-align: right">
                    <a href="listaTareaRechazada.jsp"<button class="btn btn-success">Volver</a>
                </div>
            </div>
    </body>
</html>

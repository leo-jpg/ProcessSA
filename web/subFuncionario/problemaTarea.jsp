<%-- 
    Document   : problemaTarea
    Created on : 20-11-2019, 18:24:20
    Author     : Roger
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
        
        <title>Problema tarea.</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre FROM tarea WHERE id_tarea = ${idTa}
        </sql:query> 
        <div class="container mt-4">
            <div class="card">
                <form action="procesoModificarObservacion" method="POST">
                    <div class="card-header">
                        <c:forEach var="tipos" items="${tipo.rows}">
                            <h1 >Observacion: ${tipos.nombre}</h1>
                        </c:forEach>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <tr hidden="">
                                <td>Tarea</td>                           
                               <td><input type="number" name="id" value="${idTa}" readonly=""></td>                           
                            </tr>
                            <tr>
                                <td>Observacion</td>
                                <td>
                                    <textarea name="txtObservacion" required=""></textarea>
                                </td>
                            </tr>
                            <td>
                                <input type="submit" name="btnAccion" value="Guardar" class="btn btn-primary">
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
                    <a href="procesotListaCumplimiento"<button class="btn btn-success">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>

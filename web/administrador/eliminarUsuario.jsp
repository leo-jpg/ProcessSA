<!DOCTYPE html>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Eliminar Usuario</title>

        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="../css/local.css" />

        <script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>    

        <style>

            div {
                padding-bottom:20px;
            }

        </style>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_usuario, rut FROM usuario 
        </sql:query> 
        <form action="../procesoUsuario" method="POST" target="_parent">

            <div id="wrapper">
                <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="menuAdmin.jsp">Volver</a>
                    </div>
                </nav>

                <div>
                    <div class="row text-center">
                        <h2>Eliminar Usuario</h2>
                    </div>
                    <label for="firstname" class="col-md-2">
                            Seleccione el Rut del Usuario:
                        </label>
                    <div class="col-md-9">
                        <select name="cboIdUsuario" id="cboRol" class="form-control">
                            <c:forEach var="tipos" items="${tipo.rows}">
                                <option value="${tipos.id_usuario}">${tipos.rut}</option>
                            </c:forEach>
                        </select>
                    </div>             
                </div>

                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-9">
                        <input type="submit" name="btnAccion" value="Eliminar" class="btn btn-info"/>
                    </div>
                </div>
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
    </body>
</html>
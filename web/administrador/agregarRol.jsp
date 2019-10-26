<!DOCTYPE html>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Rol</title>

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
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASKTEST" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_jerarquia, descripcion FROM jerarquia 
        </sql:query> 
        <form action="../procesoRol" method="POST" target="_parent">

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
                        <h2>Agregar Rol</h2>
                    </div>
                    <div>
                        <label for="firstname" class="col-md-2">
                            Descripción:
                        </label>
                        <div class="col-md-9">
                            <input type="text" name="txtDescripcion" placeholder="Ej: Administrador" minlength="3" maxlength="15" required="" class="form-control"/>
                        </div>
                        <div class="col-md-1">
                            <i class="fa fa-lock fa-2x"></i>
                        </div>
                    </div>    
                    <label for="sex" class="col-md-2">
                        Jerarquia:
                    </label>
                    <div class="col-md-9">
                        <select name="cboJerarquia" id="cboJerarquia" class="form-control">
                            <c:forEach var="tipos" items="${tipo.rows}">
                                <option value="${tipos.id_jerarquia}">${tipos.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>             
                </div>

                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-9">
                        <input type="submit" name="btnAccion" value="Agregar" class="btn btn-info"/>
                        <input type="reset" name="btnAccion" value="Limpiar" class="btn btn-danger"/>
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
        </c:if>   
</body>
</html>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Modificar Tarea</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Simple Task Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <!-- js -->
        <script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <!-- //js -->
        <link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Poppins:400,300,500,600,700' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="TASK" password="admin"></sql:setDataSource>
        <sql:query dataSource="${dataSource}" var="tipo">
            SELECT id_tarea, nombre from tarea where usuario_id_usuario = ${id}
        </sql:query> 
             <sql:query dataSource="${dataSource}" var="tipo2">
            SELECT id_usuario, usuario from usuario where rol_id_rol = 4
        </sql:query> 
            <sql:query dataSource="${dataSource}" var="tipo3">
            SELECT id_proceso, nombre from proceso
        </sql:query> 
            <sql:query dataSource="${dataSource}" var="tipo4">
            SELECT id_estado, descripcion from estado_tarea
        </sql:query> 
            <sql:query dataSource="${dataSource}" var="tipo5">
            SELECT id_indicador, descripcion from indicador
        </sql:query> 
        <div class="main">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="icon-bar"> <a class="navbar-brand" href="index.jsp">Volver</a></span>
                    </button>
                </div>
            </nav>
            <h1 class="w3layouts_head">Modificar Tarea</h1>
            <div class="w3layouts_main_grid">
                <form action="../procesoTarea" method="POST" class="w3_form_post">
                    <div class="agileits_main_grid w3_agileits_main_grid">
                        <span class="wthree_grid">
                            <label>Tarea a modficar<i>:</i></label>
                            <select id="category" name="cboID" required="">
                                <c:forEach var="tipos" items="${tipo.rows}">
                                    <option value="${tipos.id_tarea}">${tipos.nombre}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                    <div class="w3_agileits_main_grid w3l_main_grid">
                        <span class="agileits_grid">
                            <label>Nombre<i>:</i></label>
                            <input type="text" name="txtNombre" placeholder="Tarea 1" required="">
                        </span>
                    </div>
                    <div class="w3_agileits_main_grid w3l_main_grid">
                        <span class="agileits_grid">
                            <label>Descripcion<i>:</i></label>
                            <input type="text" name="txtDescripcion" placeholder="Se creara ..." required="">
                        </span>
                    </div>
                    <div class="w3_agileits_main_grid w3l_main_grid">
                        <span class="agileits_grid">
                            <label>Plazo<i>:</i></label>
                            <input type="date" name="DtPlazo" required="">
                        </span>
                    </div>                
                    <div class="w3_agileits_main_grid w3l_main_grid">
                        <span class="agileits_grid">
                            <label>Cumplimiento<i>:</i></label>
                            <input type="number" name="nbCumplimiento"  required="">
                        </span>
                    </div>
                    <div class="agileits_main_grid w3_agileits_main_grid">
                        <span class="wthree_grid">
                            <label>Seleccione Usuario Asignado<i>:</i></label>
                            <select id="category" name="cboUsuario" required="">
                                <c:forEach var="tipos" items="${tipo2.rows}">
                                    <option value="${tipos.id_usuario}">${tipos.usuario}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                    <div class="agileits_main_grid w3_agileits_main_grid">
                            <span class="wthree_grid">
                                <label>Proceso<i>:</i></label>
                                <select id="category" name="cboProceso" required="">
                                    <c:forEach var="tipos" items="${tipo3.rows}">
                                        <option value="${tipos.id_proceso}">${tipos.nombre}</option>
                                    </c:forEach>
                                </select>
                            </span>
                        </div>
                    <div class="agileits_main_grid w3_agileits_main_grid">
                        <span class="wthree_grid">
                            <label>Estado<i>:</i></label>
                            <select id="category" name="cboEstado" required="">
                                <c:forEach var="tipos" items="${tipo4.rows}">
                                    <option value="${tipos.id_estado}">${tipos.descripcion}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                    <div class="agileits_main_grid w3_agileits_main_grid">
                        <span class="wthree_grid">
                            <label>Indicador<i>:</i></label>
                            <select id="category" name="cboIndicador" required="">
                                <c:forEach var="tipos" items="${tipo5.rows}">
                                    <option value="${tipos.id_indicador}">${tipos.descripcion}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                    <div class="w3_main_grid">
                        <div class="w3_main_grid_right">
                            <input type="submit" name="btnAccion" value="Modificar">
                        </div>
                    </div>
                </form>
            </div>
            <link rel="stylesheet" href="css/jquery-ui.css" />
            <script src="js/jquery-ui.js"></script>
            <script>
$(function () {
    $("#datepicker").datepicker();
});
            </script>
        </div>
    </body>
</html>
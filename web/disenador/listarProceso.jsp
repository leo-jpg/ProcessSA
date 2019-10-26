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
<title>Listar Proceso</title>
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
            SELECT id_proceso, nombre from proceso where usuario_id_usuario = ${id}
        </sql:query> 
	<div class="main">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="icon-bar"> <a class="navbar-brand" href="index.jsp">Volver</a></span>
                        </button>
                    </div>
                </nav>
		<h1 class="w3layouts_head">Listar Proceso</h1>
		<div class="w3layouts_main_grid">
                        <div class="input-group" style="color: white">    
                        <table border="2" style="width: 271px;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                    </tr>           
                </thead>            
                <c:forEach var="aux" items="${tipo.rows}">
                    <tbody>
                        <tr>
                            <td>${aux.id_proceso}</td>
                            <td>${aux.nombre}</td>
                        </tr>
                    </tbody>
                </c:forEach>


            </table>
                        </div>
				<div class="w3_agileits_main_grid w3l_main_grid">
                                    	<div class="agileits_main_grid w3_agileits_main_grid">
				</div>
				</div>
		</div>
			<link rel="stylesheet" href="css/jquery-ui.css" />
			<script src="js/jquery-ui.js"></script>
			  <script>
					  $(function() {
						$( "#datepicker" ).datepicker();
					  });
			  </script>
	</div>
</body>
</html>
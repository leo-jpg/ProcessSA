<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <!-- Required meta tags-->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Listar Datos</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
    <style type="text/css">
  .boton_personalizado{
    text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;
    color: #000;
  }
  .boton_personalizado:hover{
    color: #1883ba;
    background-color: #ffffff;
  }
</style>
</head>

<body>
  
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="icon-bar"><a class="navbar-brand" href="administrador/menuAdmin.jsp">Volver</a></span>
                        </button>
                    </div>
                </nav>
    <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
        <div class="wrapper wrapper--w780">
            <div class="card card-3">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Listado</h2>
                    <form method="">
                        <div class="input-group" style="color: white">
                                    
                            
                        <table border="2" style="width: 271px;">
        
               
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>USUARIO</th>
                        <th>CONTRASEÑA</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>DIRECCION</th>
                        <th>RUT</th>
                        <th>EMAIL</th>
                        <th>ROL</th>
                        <th>UNIDAD INTERNA</th>
                    </tr>           
                </thead>
                <c:forEach var="aux" items="${lista}">
                    <tbody>
                        <tr>
                            <td>${aux.getId_usuario()}</td>
                            <td>${aux.getUsuario()}</td>
                            <td>${aux.getContrasena()}</td>
                            <td>${aux.getNombre()}</td>
                            <td>${aux.getApellido()}</td>
                            <td>${aux.getDireccion()}</td>
                            <td>${aux.getRut()}</td>
                            <td>${aux.getEmail()}</td>
                            <td>${aux.getRoldes()}</td>
                            <td>${aux.getUnides()}</td>
                        </tr>
                    </tbody>
                </c:forEach>


            </table>
                        </div>
                        <div class="input-group">
                        </div>
                        <div class="input-group">
                        </div>
                        <div class="input-group" >
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

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


    </head>

    <body>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h1>Lista usuarios</h1>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
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
            </div>
            <br>
            <div style="text-align: right">
                <a href="administrador/index.jsp"<button class="btn btn-success">Volver</a>
            </div>
        </div>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
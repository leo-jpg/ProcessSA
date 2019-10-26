<!DOCTYPE html>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
      <link rel="stylesheet" href="css/style.css">
      
      <!-- Libreria de Bootstrap-->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Fin Libreria -->
</head>
<body>
    <form action="procesoLogin" method="POST" id="form" class="form">
  <div class="field email">
    <div class="icon"></div>
    <input class="input" id="email" name="txtUsuario" type="text" placeholder="Usuario" autocomplete="off" required=""/>
  </div>
  <div class="field password">
    <div class="icon"></div>
    <input class="input" id="password" name="txtPass" type="password" placeholder="Password" required=""/>
  </div>
        <input class="button" id="submit" type="submit" name="btnAccion" value="Ingresar">
    <div class="side-top-bottom"></div>
    <div class="side-left-right"></div>
    </form>
    <c:if test="${msjNO != null}">
        <div class="alert alert-danger">
            <strong>Error!</strong> ${msjNO}.
        </c:if>   
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script  src="js/index.js"></script>
   
</body>
</html>

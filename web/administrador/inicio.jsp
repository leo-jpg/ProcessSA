<%-- 
    Document   : unidadInterna
    Created on : 03-oct-2019, 23:45:51
    Author     : RepjA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Jerarquia</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="../assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../assets/css/custom.css" rel="stylesheet" />
    </head>
    <body>
        <form action="../procesoJerarquia" method="POST">
            <div class="form-group">
                <label>Descripción:</label>
                <input type="text" name="txtDescripcion" placeholder="Ej: Nivel 1" minlength="3" maxlength="15" required="" class="form-control"/>
            </div>

            <div class="form-group text-center">
                <input type="submit" name="btnAccion" value="Agregar" class="btn btn-primary"/>
                <input type="reset" name="btnAccion" value="Limpiar" class="btn btn-danger"/>
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
</table>
</body>
</html>

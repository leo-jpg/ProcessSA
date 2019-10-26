<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Task Control</title>
<link rel="stylesheet" href="css/styleIndex.css">
<link rel="stylesheet" href="css/stylePopup.css">
<link href="https://fonts.googleapis.com/css?family=Quicksan:500" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popupScript.js"></script>
<!--SCRIPT DE EFECTO NAVBAR-->
<script type="text/javascript">
	$(window).on('scroll', function(){
		if($(window).scrollTop()){
			$('nav').addClass('black');	
		}
		else{
			$('nav').removeClass('black');	
		}
	})
</script>
<!-- CIERRE SCRIPT EFECTO NAVBAR-->
</head>


<body>
	<div class="wrapper">
    	<nav>
            <div class="logo"></div>
                <ul>
                    <li><a href="inicio.jsp" target="centro">Inicio</a></li>
                    <li><a href="GUI/QuienesSomos.php" target="centro">Quienes Somos</a></li>
                    <li><a href="GUI/Ubicacion.php" target="centro">Ubicación</a></li>
                    <li><a href="login.jsp" class="active">Login</a></li>
                    <!--<li><a href="#" class="active">Login</a></li>-->
                </ul>
        </nav>        
        <section class="sec1">
            <iframe name="centro" frameborder="0" scrolling="no"></iframe>
        </section>
        <section class="content">
        	<p>La empresa "Process SA" se dedica a asesorar a empresas de distintos rubros de ordenamiento y control de sus procesos y tareas.</p>
                
        </section>

        <!--OPEN MODAL-->
        <!--
        <div class="modal">
        	<div class="modal-content">
            	<div class="close">&times;</div>
                <div class="buttons">
            	<h1>¿Que sesión desea inciar?</h1>
                <a href="login.jsp" target="_parent"><button>Administrador</button></a>
                   <a href="loginFuncionario.jsp" target="_parent"><button>Funcionario</button></a>
                   <a href="loginDisenador.jsp" target="_parent"><button>Diseñador</button></a>
                </div>                   
            </div>
        </div>
        -->
        <!--CLOSE MODAL-->
  
      	<div class="footer">
    		TASK CONTROL 2019 &reg;
    	</div>    
    </div>
</body>
</html>
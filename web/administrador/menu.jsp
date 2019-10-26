<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Task Control</title>
<link rel="stylesheet" href="../css/styleIndex.css">
<link rel="stylesheet" href="../css/stylePopup.css">
<link href="https://fonts.googleapis.com/css?family=Quicksan:500" rel="stylesheet">
<script src="../js/jquery-3.3.1.js"></script>
<script src="../js/popupScript.js"></script>
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
                    <li><a href="GUI/Inicio.php" target="centro">Usuario</a></li>
                    <li><a href="#" class="activeRol">Rol</a></li>
                    <li><a href="GUI/Ubicacion.php" target="centro">Jerarquía</a></li>
                    <li><a href="GUI/Ubicacion.php" target="centro">Unidad Interna</a></li>
                    <li><a href="#" class="active">Sign Out</a></li>
                </ul>
        </nav>        
        <section class="sec1">
        	<iframe name="centro" frameborder="0" scrolling="no"></iframe> 
        </section>
        <!--OPEN MODAL-->
        <div class="modal">
        	<div class="modal-content">
            	<div class="close">&times;</div>
                <div class="buttons">
            	<h1>¿Está seguro que desea salir?</h1>
                <a href="../index.jsp" target="_parent"><button>Sí</button></a>
                <a href="menu.jsp" target="_parent"><button>No</button></a>
                </div>                   
            </div>
        </div>
        <!--CLOSE MODAL-->
        <!--OPEN MODAL USUARIO-->
        <div class="modalRol">
        	<div class="modal-content">
            	<div class="closeRol">&times;</div>
                <div class="buttonsRol">
            	<h1>¿Que acción desea realizar?</h1>
                <a href="register.jsp" target="centro"><button>Agregar</button></a>
                <a href="menu.jsp" target="_parent"><button>Modificar</button></a>
                <a href="menu.jsp" target="_parent"><button>Eliminar</button></a>
                <a href="menu.jsp" target="_parent"><button>Listar</button></a>
                </div>                   
            </div>
        <!--CLOSE MODAL USUARIO-->
        <!--OPEN MODAL ROL-->
        <div class="modalRol">
        	<div class="modal-content">
            	<div class="closeRol">&times;</div>
                <div class="buttonsRol">
            	<h1>¿Que acción desea realizar?</h1>
                <a href="agregarRol.jsp" target="centro"><button>Agregar</button></a>
                <a href="menu.jsp" target="_parent"><button>Modificar</button></a>
                <a href="menu.jsp" target="_parent"><button>Eliminar</button></a>
                <a href="menu.jsp" target="_parent"><button>Listar</button></a>
                </div>                   
            </div>
        </div>
        <!--CLOSE MODAL ROL-->
      	<div class="footer">
    		TASK CONTROL 2019 &reg;
    	</div>    
    </div>
</body>
</html>
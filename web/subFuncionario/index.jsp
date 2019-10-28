<!DOCTYPE html>
<html lang="en">
<head>
  <title>Process SA</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="HTML5 website template">
  <meta name="keywords" content="global, template, html, sass, jquery">
  <meta name="author" content="Bucky Maler">
  <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>

<!-- notification for small viewports and landscape oriented smartphones -->
<div class="device-notification">
  <a class="device-notification--logo" href="#0">
    <img src="assets/img/logo.png" alt="Global">
    <p>PROCESS SA</p>
  </a>
</div>
<div class="perspective effect-rotate-left">
  <div class="container"><div class="outer-nav--return"></div>
    <div id="viewport" class="l-viewport">
      <div class="l-wrapper">
        <header class="header">
          <a class="header--logo" href="#0">
            <img src="assets/img/logo.png" alt="Global">
            <p>PROCESS SAAAAA</p>
          </a>
          <div class="header--nav-toggle">
            <span></span>
          </div>
        </header>
        <nav class="l-side-nav">
          <ul class="side-nav">
            <li class="is-active"><span>Inicio</span></li>
            <li><span>Tarea</span></li>
            <li><span>Tarea Subordinada</span></li>
            <li><span>Panel de control</span></li>
            <li><span>Lista Funcionarios</span></li>
            <li><span>Reportar Problema</span></li>
            <li><span>Ejecutar Flujo</span></li>
          </ul>
        </nav>
        <ul class="l-main-content main-content">
          <li class="l-section section section--is-active">
            <div class="intro">
                  <h1>Bienvenido: ${usuario}</h1>
                  <img src="assets/img/funcionario1-680x365_c.jpg" alt="">       
            </div>
          </li>
          <li class="l-section section">
            <div class="work">
              <h2>Selecciones tarea</h2>
              <div class="work--lockup">
                <ul class="slider">
                  <li class="slider--item slider--item-left">
                      <a href="desglosarTarea.jsp">
                      <div class="slider--item-image">
                          <img src="assets/img/modificarTarea.jpg" alt="">
                      </div>
                      <p class="slider--item-title">Desglorasar Tarea</p>
                    </a>
                  </li>
                  <li class="slider--item slider--item-center">
                    <a href="../procesoListaTareaSub">
                      <div class="slider--item-image">
                      <img src="assets/img/visualizarEstado.jpg" alt="">
                      </div>
                      <p class="slider--item-title">Listar Tareas</p>
                    </a>
                  </li>
                  <li class="slider--item slider--item-right">
                    <a href="#0">
                      <div class="slider--item-image">
                          <img src="assets/img/agregarTarea.jpg" alt="">
                      </div>
                      <p class="slider--item-title">Visualizar Estado</p>
                    </a>
                  </li>
                     <li class="slider--item">
                    <a href="#0">
                      <div class="slider--item-image">
                          <img src="assets/img/reasignar.jpg" alt="">
                      </div>
                      <p class="slider--item-title">Reasignar</p>
                    </a>
                  </li>
                       <li class="slider--item">
                    <a href="#0">
                      <div class="slider--item-image">
                          <img src="assets/img/devolver.jpg" alt="">
                      </div>
                      <p class="slider--item-title">Devolver</p>
                    </a>
                  </li>
                </ul>
                <div class="slider--prev">
                  <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                  viewBox="0 0 150 118" style="enable-background:new 0 0 150 118;" xml:space="preserve">
                  <g transform="translate(0.000000,118.000000) scale(0.100000,-0.100000)">
                    <path d="M561,1169C525,1155,10,640,3,612c-3-13,1-36,8-52c8-15,134-145,281-289C527,41,562,10,590,10c22,0,41,9,61,29
                    c55,55,49,64-163,278L296,510h575c564,0,576,0,597,20c46,43,37,109-18,137c-19,10-159,13-590,13l-565,1l182,180
                    c101,99,187,188,193,199c16,30,12,57-12,84C631,1174,595,1183,561,1169z"/>
                  </g>
                  </svg>
                </div>
                <div class="slider--next">
                  <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 150 118" style="enable-background:new 0 0 150 118;" xml:space="preserve">
                  <g transform="translate(0.000000,118.000000) scale(0.100000,-0.100000)">
                    <path d="M870,1167c-34-17-55-57-46-90c3-15,81-100,194-211l187-185l-565-1c-431,0-571-3-590-13c-55-28-64-94-18-137c21-20,33-20,597-20h575l-192-193C800,103,794,94,849,39c20-20,39-29,61-29c28,0,63,30,298,262c147,144,272,271,279,282c30,51,23,60-219,304C947,1180,926,1196,870,1167z"/>
                  </g>
                  </svg>
                </div>
              </div>
            </div>
          </li>
      <li class="l-section section">
            <div class="about">
              <div class="about--banner">
                <h2 style="line-height: 0px ">Tarea Subordinada</h2>           
              </div>
              <div class="about--options">
                  <a href="../administrador/listarUnidadInterna.jsp">
                    <img src="assets/img/agregarTareaSubordinada.jpg" alt="" width="200px;;" height="110px;"/>
                  <h3>Agregar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/modificarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Modificar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/eliminarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Eliminar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/listarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Listar</h3>
                </a>
              </div>
            </div>
          </li>
        <li class="l-section section">
            <div class="about">
              <div class="about--banner">
                <h2 style="line-height: 0px ">Panel de control</h2>           
              </div>
            <!--  <div class="about--options">
                <a href="#0">
                    <img src="assets/img/agregarTareaSubordinada.jpg" alt="" width="200px;;" height="110px;"/>
                  <h3>Agregar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/modificarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Modificar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/eliminarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Eliminar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/listarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Listar</h3>
                </a>
              </div>
            </div>-->
          </li>
        <li class="l-section section">
            <div class="about">
              <div class="about--banner">
                <h2 style="line-height: 0px ">Lista Funcionarios</h2>           
              </div>
              <!--<div class="about--options">
                <a href="#0">
                    <img src="assets/img/agregarTareaSubordinada.jpg" alt="" width="200px;;" height="110px;"/>
                  <h3>Agregar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/modificarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Modificar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/eliminarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Eliminar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/listarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Listar</h3>
                </a>
              </div>-->
            </div>
          </li>
          <li class="l-section section">
            <div class="about">
              <div class="about--banner">
                <h2 style="line-height: 0px ">Reportar Problema</h2>           
              </div>
            <!--  <div class="about--options">
                <a href="#0">
                    <img src="assets/img/agregarTareaSubordinada.jpg" alt="" width="200px;;" height="110px;"/>
                  <h3>Agregar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/modificarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Modificar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/eliminarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Eliminar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/listarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Listar</h3>
                </a>
              </div>-->
            </div>
          </li>
          <li class="l-section section">
            <div class="about">
              <div class="about--banner">
                <h2 style="line-height: 0px ">Ejecutar Flujo</h2>           
              </div>
           <!--   <div class="about--options">
                <a href="#0">
                    <img src="assets/img/agregarTareaSubordinada.jpg" alt="" width="200px;;" height="110px;"/>
                  <h3>Agregar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/modificarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Modificar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/eliminarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Eliminar</h3>
                </a>
                <a href="#0">
                    <img src="assets/img/listarTareaSubordinada.jpg" alt="" width="200px;" height="110px;"/>
                  <h3>Listar</h3>
                </a>
              </div>-->
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <ul class="outer-nav">
    <li class="is-active">Inicio</li>
    <li>Tarea</li>
    <li>Tarea Subordinada</li>
    <li>Panel de control</li>
    <li>Lista Funcionarios</li>
     <li>Reportar Problema</li>
     <li>Ejecutar Flujo</li>
     <h1><a href="../procesoCerrarSesion"> Cerrar Sesion</a></h1>
  </ul>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="assets/js/vendor/jquery-2.2.4.min.js"><\/script>')</script>
<script src="assets/js/functions-min.js"></script>
</body>
</html>

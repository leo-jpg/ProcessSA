var btnAbrirPopup = document.getElementById('btn-abrir-popup'), 
    overlay = document.getElementById('overlay'),
    popup = document.getElementById('popup'),
    btnCerrarPopup = document.getElementById('btn-cerrar-popup');

btnAbrirPopup.addEventListener('click', function(){
    overlay.classList.add('active'); 
});

btnCerrarPopup.addEventListener('click', function(){
    overlay.classList.remove('active');
});


//$(".add_product").click(function(e){
//    e.preventDefault();
//    var producto = $(this).attr('value'),
//    
//});

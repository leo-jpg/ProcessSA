$(document).ready(function(){
		//--MODAL 1--
		$(".active").on('click', function(){
			$(".modal").fadeIn('slow');			
		});
		
		$(".close").on('click', function(){
			$(".modal").fadeOut('slow');
		});
		
		$(".buttons").on('click', function(){
			$(".modal").fadeOut('slow');
		});
		//--MODAL 1--
		
                //--MODAL USUARIO--
		$(".activeUser").on('click', function(){
			$(".modalUser").fadeIn('slow');			
		});
		
		$(".closeUser").on('click', function(){
			$(".modalUser").fadeOut('slow');
		});
		
		$(".buttonsUser").on('click', function(){
			$(".modalUser").fadeOut('slow');
		});
		//--MODAL USUARIO--
                
                //--MODAL ROL--
		$(".activeRol").on('click', function(){
			$(".modalRol").fadeIn('slow');			
		});
		
		$(".closeRol").on('click', function(){
			$(".modalRol").fadeOut('slow');
		});
		
		$(".buttonsRol").on('click', function(){
			$(".modalRol").fadeOut('slow');
		});
		//--MODAL ROL--
		
		
});

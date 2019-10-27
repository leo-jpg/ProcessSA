$(document).ready(function(){
		$(".active").on('click', function(){
			$(".modal").fadeIn('slow');			
		});
		
		$(".close").on('click', function(){
			$(".modal").fadeOut('slow');
		});
		
		$(".buttons").on('click', function(){
			$(".modal").fadeOut('slow');
		});		
});


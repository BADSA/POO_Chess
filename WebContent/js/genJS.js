$( document ).ready(function() {
	var cont = 1;
	
	$(".escaque").click(function(){
		if (jQuery.data( document.body, "cnt")!=null){
			cont = jQuery.data( document.body, "cnt");
		}
		if (cont==2){
			cont = 0;
			window.location= "?accion=hacerJugada&origen="+jQuery.data( document.body, "pos1") + "&destino=" + $(this).attr('id');
		}
		cont = cont + 1; 
		jQuery.data( document.body, "cnt", cont );
		jQuery.data( document.body, "pos1",  $(this).attr('id') );
		
	 });
	
	
});



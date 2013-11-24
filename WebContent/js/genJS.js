/*jQuery('#droppable').droppable(
{
    accept: '#draggable',
    drop: function(event, ui)
    {
        ui.draggable.data('dropped', true);
        // awesome code that works and handles successful drops...
    }
});

$('img').draggable(
{
    revert: false,
    start: function(event, ui) {
        ui.helper.data('dropped', false);
    },
    stop: function(event, ui)
    {
        alert('stop: dropped=' + ui.helper.data('dropped'));
        // Check value of ui.helper.data('dropped') and handle accordingly...
    }
}); 

*/
$(function() {
	  $( "img" ).draggable({ snap: ".escaque" }); //{ revert: true }
 });


 $( document ).ready(function() {
	var cont = 1;
	
	//$( "td" ).mouseup(function() {
	//	alert(" Pieza "+ $(this).attr('id'));
	//});
	
	 //Sirve
	$("td").click(function(){
		// alert(" Pieza "+ $(this).attr('id'));
		if (jQuery.data( document.body, "cnt")!=null){
			cont = jQuery.data( document.body, "cnt");
		}
		if (cont==2){
			cont = 0;
			window.location= "?origen="+jQuery.data( document.body, "pos1") + "&destino=" + $(this).attr('id');
		}
		cont = cont + 1; 
		jQuery.data( document.body, "cnt", cont );
		jQuery.data( document.body, "pos1",  $(this).attr('id') );
		
	 });
	
	
});



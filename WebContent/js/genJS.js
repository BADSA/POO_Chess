
$( document ).ready(function() {
	  // Handler for .ready() called.
	$("img").click(function(){
		var pos = $(this).attr("id");
		alert("Ha presionado "+pos);
	});
});
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page  import="cr.tec.programada.poo.modelo.Tablero"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	   <title>Juego de Ajedrez</title>
	   <link href='css/genStyles.css' rel='stylesheet' rev='stylesheet' type='text/css'/>
	</head>
	<body background='img/Chess.jpg' >
	<c:if test="${empty sessionScope.nomJug1}" >
		<div id="ingreso">
	        <form action="JuegoDeAjedrez" method="get" style="text-align:center;">
	            <input type="hidden" name="accion" value="crearSesion" />
	            <table align="center" width="400px">
	            	<tr>
	            		<td colspan="2" align="center"> <h2><FONT COLOR="#33cccc"> Juego de Ajedrez </FONT> </h2> </td>
	            	</tr><tr>
			            <td > <FONT COLOR="#ffffff">Jugador de blancas: </FONT> </td> 
			            <td> <input type="text" name="nomJug1"/></td>
			        </tr><tr>
			            <td > <FONT COLOR="#ffffff"> Jugador de negras: </FONT></td>  
			            <td><input type="text" name="nomJug2"/></td>
			        </tr>
		        </table><br>
	            <input type="submit" value="Definir Sesion">
	        </form>           
       	</div>          
    </c:if>

    <c:if test="${!empty sessionScope.nomJug1}" >
		<div id="header">    
    	 	<center><h1><FONT COLOR="#33cccc"> Juego de Ajedrez </FONT> </h1></center>
    	</div>
    	<div id="content">
	    	<div id="informacion">
	    		<br><br>
	    		<center>
				 <b><FONT COLOR="#ffffff">Jugador de blancas: </FONT></b> 
			     <b><FONT COLOR="#ffffff"><c:out value="${sessionScope.nomJug1}" /></FONT></b><br>
			     <b><FONT COLOR="#ffffff"> Jugador de  negras: </FONT></b>
			     <b><FONT COLOR="#ffffff"><c:out value="${sessionScope.nomJug2}" /></FONT></b><br><br>
			    <form action="JuegoDeAjedrez" method="get">
			        <input type="hidden" name="accion" value="destruirSesion" />
			        <input type="submit" value="Finalizar Sesion">
			    </form><br>
			    </center>
	        </div>
	        <div id="tablero">  
	      	<br><br>
	        
		        <!-- Recorre dinamicamente la matriz tablero y la dibuja en pantalla -->      
		        <%
		        Tablero tAjedrez = (Tablero)request.getSession().getAttribute("tablero");
		        request.getSession().removeAttribute("tablero");
		        String colorFondo = "#ffffff";
		        out.println("<table style='border:1px solid #757575;' bgcolor='#000000'>");
				for (int i =0; i<8; i++){
					out.println("<tr align='center'>");
					for (int j =0; j<8; j++){
						out.println("<td id='"+i+","+j+"' class='escaque' bgcolor='"+colorFondo+"' ><img  src='"+tAjedrez.getTRutaPieza(i, j)+"'></td>");
						if (colorFondo=="#ffffff"){ colorFondo = "#787878"; }else{ colorFondo = "#ffffff"; }
					}
					if (colorFondo=="#ffffff"){ colorFondo = "#787878"; }else{ colorFondo = "#ffffff"; }
					out.println("</tr>");	
				}
				out.println("</table>");
		        %>
	        </div>
        </div>
        <div id="footer">
        	<center><h3><font color="#3cc">Copyright © | BADSA 2013</font></h3></center>
        </div>
    </c:if>
       
</body>                      
</html>
        
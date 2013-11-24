package cr.tec.programada.poo.modelo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class ajedrez
 */
@WebServlet("/Ajedrez")
public class Ajedrez extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajedrez() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> .:: Ajedrez ::. </title>");
		
		// Se importan los archivos css y js necesarios.
		out.println("		<link href='css/genStyles.css' rel='stylesheet' rev='stylesheet' type='text/css'/>");
		out.println("	<script src='http://code.jquery.com/jquery-1.9.1.js'></script> ");
		out.println("		<script src='js/genJS.js' language='javascript' type='text/javascript'></script>");
		out.println("<script src='http://code.jquery.com/ui/1.10.3/jquery-ui.js'></script>"); // Make the draggable posible.

		out.println("	</head>");
		out.println("	<body background='img/Chess.jpg'>");
		out.println("<p> Nombre de los jugadores</p>");
		out.println("<hr>");
		out.println("<table align='center' style='border:1px solid #757575;' bgcolor='#ffffff'>");
		
		out.println("<tr align='center'>");
		out.println("	<td id='0,0' class='escaque'><img  src='img/torreNegro.png'></td>");
		out.println("	<td id='0,1' class='escaque' bgcolor='#787878'><img src='img/caballoNegro.png'></td>");
		out.println("	<td id='0,2' class='escaque' ><img id='0,2' src='img/alfilNegro.png'></td>");
		out.println("	<td id='0,3' class='escaque' bgcolor='#787878'><img src='img/reyNegro.png'></td>");
		out.println("	<td id='0,4' class='escaque'><img  src='img/reinaNegro.png'></td>");
		out.println("	<td id='0,5' class='escaque' bgcolor='#787878'><img src='img/alfilNegro.png'></td>");
		out.println("	<td id='0,6' class='escaque'><img src='img/caballoNegro.png'></td>");
		out.println("	<td id='0,7' class='escaque' bgcolor='#787878'><img src='img/torreNegro.png'></td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td id='1,0' class='escaque' bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td id='1,1' class='escaque'><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td id='1,2' class='escaque' bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td id='1,3' class='escaque'><font color='787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td id='1,4' class='escaque' bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td id='1,5' class='escaque'><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td id='1,6' class='escaque' bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td id='1,7' class='escaque'><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td id='2,0' class='escaque'> </td>");
		out.println("	<td id='2,1' class='escaque' bgcolor='#787878'></td>");
		out.println("	<td id='2,2' class='escaque'></td>");
		out.println("	<td id='2,3' class='escaque' bgcolor='#787878'></td>");
		out.println("	<td id='2,4' class='escaque'></td>");
		out.println("	<td id='2,5' class='escaque' bgcolor='#787878'></td>");
		out.println("	<td id='2,6' class='escaque'></td>");
		out.println("	<td id='2,7' class='escaque' bgcolor='#787878'></td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td id='3,0' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='3,1' class='escaque'> </td>");
		out.println("	<td id='3,2' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='3,3' class='escaque'> </td>");
		out.println("	<td id='3,4' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='3,5' class='escaque'> </td>");
		out.println("	<td id='3,6' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='3,7' class='escaque'> </td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td id='4,0' class='escaque'>   </td>");
		out.println("	<td id='4,1' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='4,2' class='escaque'> </td>");
		out.println("	<td id='4,3' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='4,4' class='escaque'> </td>");
		out.println("	<td id='4,5' class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td id='4,6' class='escaque'> </td>");
		out.println("	<td id='4,7' class='escaque' bgcolor='#787878'> </td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td class='escaque'> </td>");
		out.println("	<td class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td class='escaque'> </td>");
		out.println("	<td class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td class='escaque'> </td>");
		out.println("	<td class='escaque' bgcolor='#787878'> </td>");
		out.println("	<td class='escaque'> </td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("	<td class='escaque'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque' bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque' bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque' bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque'><img src='img/peonBlanco.png'></td>");
		out.println("	<td class='escaque' bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("</tr>  <tr align='center'>");
		
		out.println("	<td bgcolor='#787878'><img src='img/torreBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/caballoBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/alfilBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/reyBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/reinaBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/alfilBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/caballoBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/torreBlanco.png'></font></td>");
		out.println("</tr>");
		out.println("</table>");
		
		if (request.getParameter("origen")!= null){
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			
			ExpertoEnAjedrez eA = new ExpertoEnAjedrez();
			boolean valido = eA.validarMovimiento( origen , destino);
			out.println("<script> alert ('"+valido+"') </script>");
		}
		
		Tablero t1 = new Tablero();
		
		out.println("	</body>");
		out.println("	</html>");

	}

}

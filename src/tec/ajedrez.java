package tec;

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

		out.println("	</head>");
		out.println("	<body>");
		out.println("<p> Nombre de los jugadores</p>");
		out.println("<hr>");
		out.println("<table align='center' width='500' height='500' style='border:1px solid #757575;' bgcolor='#ffffff'>");
		out.println("<tr align='center'>");
		out.println("	<td><img id='0,0' src='img/torreNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img id='0,1' src='img/caballoNegro.png'></td>");
		out.println("	<td><img id='0,2' src='img/alfilNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img id='0,3' src='img/reyNegro.png'></td>");
		out.println("	<td><img id='0,4' src='img/reinaNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img id='0,5' src='img/alfilNegro.png'></td>");
		out.println("	<td><img id='0,6' src='img/caballoNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img id='0,7' src='img/torreNegro.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td><font color='787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonNegro.png'></font></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td> <img src='img/transparent.png'> </td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td> <img src='img/transparent.png'> </td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='img/transparent.png'></td>");
		out.println("	<td><img src='img/transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td><font color='#787878'><img src='img/peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='img/peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='img/peonBlanco.png'></td>");
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
		
		out.println("	</body>");
		out.println("	</html>");

	}

}

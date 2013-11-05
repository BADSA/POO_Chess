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
		out.println("		<script src='js/genJS.js' language='javascript' type='text/javascript'></script>");
		out.println("		<link href='css/jquery-ui-1.8.4.custom.css' rel='stylesheet' rev='stylesheet' type='text/css'/>" +
				"		<script src='js/jquery-1.4.4.min.js' language='javascript' type='text/javascript'></script>"+
				"		<script src='js/jquery-ui-1.8.10.custom.min.js' language='javascript' type='text/javascript'></script>");
		
		out.println("	</head>");
		out.println("	<body>");
		out.println("<p> Nombre de los jugadores</p>");
		out.println("<hr>");
		out.println("<table align='center' width='500' height='500' style='border:1px solid #757575;' bgcolor='#ffffff'>");
		out.println("<tr align='center'>");
		out.println("	<td><img src='torreNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='caballoNegro.png'></td>");
		out.println("	<td><img src='alfilNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='reyNegro.png'></td>");
		out.println("	<td><img src='reinaNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='alfilNegro.png'></td>");
		out.println("	<td><img src='caballoNegro.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='torreNegro.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("	<td><font color='787878'><img src='peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonNegro.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonNegro.png'></font></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td> <img src='transparent.png'> </td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td> <img src='transparent.png'> </td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("	<td bgcolor='#787878'><img src='transparent.png'></td>");
		out.println("	<td><img src='transparent.png'></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("	<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='peonBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='peonBlanco.png'></td>");
		out.println("</tr>  <tr align='center'>");
		out.println("	<td bgcolor='#787878'><img src='torreBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='caballoBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='alfilBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='reyBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='reinaBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='alfilBlanco.png'></font></td>");
		out.println("	<td bgcolor='#787878'><img src='caballoBlanco.png'></td>");
		out.println("	<td><font color='#787878'><img src='torreBlanco.png'></font></td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("	</body>");
		out.println("	</html>");

	}

}

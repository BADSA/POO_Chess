package cr.tec.programada.poo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//import cr.tec.ejemplos.poo.modelo.Numero;

/**
 * Servlet implementation class JuegoDeAjedrez
 */
public class JuegoDeAjedrez extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, ComandoAplicacionWeb> comandos;
	
    @Override
	public void init() throws ServletException {
		// Inicializar todos los objetos comando
		comandos = new HashMap<String, ComandoAplicacionWeb>();
		comandos.put("crearSesion", new ComandoCrearSesion());
		comandos.put("destruirSesion", new ComandoDestruirSesion());
		comandos.put("hacerJugada", new ComandoHacerJugada());
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public JuegoDeAjedrez() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener el comando a ejecutar
		String strComando = request.getParameter("accion");
		ComandoAplicacionWeb comando = comandos.get(strComando);
		if (comando != null) {
			// Ejecutar el comando
			comando.ejecutar(request, response);
		}
		
		// Redirigir a la vista (JSP)
		try {
			ServletConfig sc = getServletConfig();
			sc.getServletContext().getRequestDispatcher("/juegoAjedrez.jsp").forward(request,response);
		} catch (Exception e) {
			      e.printStackTrace();
		};		
		
	}
}

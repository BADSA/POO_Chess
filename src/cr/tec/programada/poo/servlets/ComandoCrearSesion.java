package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cr.tec.programada.poo.modelo.Tablero;

public class ComandoCrearSesion implements ComandoAplicacionWeb {

	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		// Crear una sesión
		HttpSession session = request.getSession(true);
		
		// Se inicializa un tablero.
		Tablero tA = new Tablero();
		// Se guarda el estado del tablero como atributo de la sesion.
		request.getSession().setAttribute("tablero",tA);
		
		// Guardar dentro de la sesión el nombre de los jugadores, que se reciben como parametro.
		session.setAttribute("nomJugBlancas", request.getParameter("nomJugBlancas"));
		session.setAttribute("nomJugNegras", request.getParameter("nomJugNegras"));
		// Se guarda un atributo para ver el turno actual.
		session.setAttribute("turno", "blanca");
		session.setAttribute("jaque", "false");
	}

}

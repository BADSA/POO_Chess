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

		Tablero tA = new Tablero();
		request.getSession().setAttribute("tablero",tA);
		// Guardar dentro de la sesión el nombre de los jugadores, que se recibe como parametro
		session.setAttribute("nomJug1", request.getParameter("nomJug1"));
		session.setAttribute("nomJug2", request.getParameter("nomJug2"));
	}

}

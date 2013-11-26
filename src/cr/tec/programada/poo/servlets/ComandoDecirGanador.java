package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cr.tec.programada.poo.modelo.Tablero;

public class ComandoDecirGanador implements ComandoAplicacionWeb {

	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		// Se obtiene el parametro del jugador que gano.
		String jugador = request.getParameter("jug");
		
		// Se obtiene la sesion.
		HttpSession session = request.getSession();
		
		// Se establece un atributo ganador en la sesion
		// para acabar el juego dependiendo de el valor de
		// jugador.
		if(jugador.equals( "negras")){
			session.setAttribute("ganador", (String)request.getSession().getAttribute("nomJugNegras"));
		}else if(jugador.equals( "blancas")){
			session.setAttribute("ganador", (String)request.getSession().getAttribute("nomJugBlancas"));
		}else{
			// Si no es igual a negras ni a blancas, entonces hubo un empate.
			session.setAttribute("ganador", "XempateX");
		}
		
	}

}

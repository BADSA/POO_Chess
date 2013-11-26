package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cr.tec.programada.poo.modelo.Tablero;

public class ComandoDecirGanador implements ComandoAplicacionWeb {

	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		String jugador = request.getParameter("jug");
		HttpSession session = request.getSession();
		if(jugador.equals( "negras")){
			session.setAttribute("ganador", (String)request.getSession().getAttribute("nomJugNegras"));
		}else if(jugador.equals( "blancas")){
			session.setAttribute("ganador", (String)request.getSession().getAttribute("nomJugBlancas"));
		}else{
			session.setAttribute("ganador", "XempateX");
		}
		
	}

}

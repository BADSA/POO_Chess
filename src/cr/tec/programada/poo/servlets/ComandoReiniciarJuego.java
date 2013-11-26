package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cr.tec.programada.poo.modelo.ExpertoEnAjedrez;
import cr.tec.programada.poo.modelo.Tablero;
import java.io.PrintWriter;

public class ComandoReiniciarJuego implements ComandoAplicacionWeb {
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().removeAttribute("ganador");
		request.getSession().removeAttribute("jaque");
		Tablero tAjedrez = new Tablero();
		request.getSession().setAttribute("tablero",tAjedrez);
		request.getSession().setAttribute("turno", "blanca");
	}

}

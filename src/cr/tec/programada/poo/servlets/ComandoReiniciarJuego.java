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
		
		// Reinicia el estado del tablero y de los atributos mas importantes de la sesion
		
		// Elimina el ganador
		request.getSession().removeAttribute("ganador");
		// Resetea el estado de jaque
		request.getSession().setAttribute("jaque", "false");
		Tablero tAjedrez = new Tablero();
		request.getSession().setAttribute("tablero",tAjedrez);
		// Establece el primer turno de nuevo.
		request.getSession().setAttribute("turno", "blanca");
	}

}

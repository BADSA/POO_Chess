package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComandoDestruirSesion implements ComandoAplicacionWeb {

	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		// Obtener la sesión
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

	}

}

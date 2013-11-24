package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface ComandoAplicacionWeb {
	
	void ejecutar(HttpServletRequest request, HttpServletResponse response);

}

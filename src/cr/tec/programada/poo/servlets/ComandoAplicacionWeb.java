package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Interfaz que define el metodo ejecutar de los comandos
interface ComandoAplicacionWeb {
	
	void ejecutar(HttpServletRequest request, HttpServletResponse response);

}

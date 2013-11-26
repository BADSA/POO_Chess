package cr.tec.programada.poo.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cr.tec.programada.poo.modelo.ExpertoEnAjedrez;
import cr.tec.programada.poo.modelo.Tablero;
import java.io.PrintWriter;

public class ComandoHacerJugada implements ComandoAplicacionWeb {
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		
		int parOrigen[] = parAEntero(origen);
		int parDestino[] = parAEntero(destino);
		
		Tablero tAjedrez = (Tablero)request.getSession().getAttribute("tablero");
		ExpertoEnAjedrez eA = new ExpertoEnAjedrez(tAjedrez);
		
		boolean valido = false;
		String turnoActual = (String)request.getSession().getAttribute("turno");
		

		String colorContrario;
		if (turnoActual.equals("negra")){
			colorContrario = "blanca";
		}else{colorContrario = "negra"; }
		
		if (!eA.revisarJaque(colorContrario)){
			if (!eA.poneElMovimientoJugEnJaque(colorContrario,parOrigen[0],parOrigen[1],parDestino[0],parDestino[1] ) ){
				if (turnoActual == tAjedrez.getTColorPieza(parOrigen[0],parOrigen[1]) ){
					valido = eA.validarMovimiento(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
				}
				if (valido){
					tAjedrez.cambiarPiezas(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
					if (request.getSession().getAttribute("turno")=="blanca"){
						request.getSession().setAttribute("turno","negra");
					}else{
						request.getSession().setAttribute("turno","blanca");
					}
					request.getSession().setAttribute("jaque","false");
				}
			}else{ System.out.println("No puede realizar este movimiento, ya que deja a su rey en jaque");}
		}else{
			request.getSession().setAttribute("jaque","true");
			if (!eA.poneElMovimientoJugEnJaque(colorContrario,parOrigen[0],parOrigen[1],parDestino[0],parDestino[1] ) ){
				if (turnoActual == tAjedrez.getTColorPieza(parOrigen[0],parOrigen[1]) ){
					valido = eA.validarMovimiento(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
				}
				if (valido){
					tAjedrez.cambiarPiezas(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
					if (request.getSession().getAttribute("turno")=="blanca"){
						request.getSession().setAttribute("turno","negra");
					}else{
						request.getSession().setAttribute("turno","blanca");
					}
					request.getSession().setAttribute("jaque","false");
				}
			}else{ 
				System.out.println("Se encuentra en haque, su movimiento debe evitar el haque.");
			}
		}
				
		request.getSession().setAttribute("tablero",tAjedrez);
		
	}
	
	protected int[] parAEntero(String parOrdenado){
		int par[]=new int[2]; //arreglos para almacenar x y y del par ordenado
		int i=0;
		String orig[] = parOrdenado.split("\\,");
		for (String s :orig){
		        par[i]= Integer.parseInt(s);
		        i++;
		}	            
		return par;
	}


}

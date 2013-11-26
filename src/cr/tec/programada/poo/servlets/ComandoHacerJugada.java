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
		
		// Se obtienen las posiciones de origen y destino de la jugada.
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		
		// Se convierten a enteros y se almacenan en arreglos.
		int parOrigen[] = parAEntero(origen);
		int parDestino[] = parAEntero(destino);
		
		// Se obtiene el atributo tablero de la sesion.
		Tablero tAjedrez = (Tablero)request.getSession().getAttribute("tablero");
		
		// Se instancia un experto en Ajedrez.
		ExpertoEnAjedrez eA = new ExpertoEnAjedrez(tAjedrez);
		
		boolean valido = false;
		String turnoActual = (String)request.getSession().getAttribute("turno");
		

		String colorContrario;
		if (turnoActual.equals("negra")){
			colorContrario = "blanca";
		}else{colorContrario = "negra"; }
		
		// Si no se esta en jaque, se procede.
		if (!eA.revisarJaque(colorContrario)){
			// Si el movimiento no pone al rey en jaque, se procede.
			if (!eA.poneElMovimientoJugEnJaque(colorContrario,parOrigen[0],parOrigen[1],parDestino[0],parDestino[1] ) ){
				// Se verifica que el turno sea el del jugador actual.
				if (turnoActual == tAjedrez.getTColorPieza(parOrigen[0],parOrigen[1]) ){
					// Se procede a validar el movimiento.
					valido = eA.validarMovimiento(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
				}
				if (valido){
					// Se intercambian las piezas en el tablero
					tAjedrez.cambiarPiezas(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
					// Se cambia el turno.
					if (request.getSession().getAttribute("turno")=="blanca"){
						request.getSession().setAttribute("turno","negra");
					}else{
						request.getSession().setAttribute("turno","blanca");
					}
					// Se pone falso el estado de jaque.
					request.getSession().setAttribute("jaque","false");
				}
			// Advierte que se esta en jaque!
			}else{ System.out.println("No puede realizar este movimiento, ya que deja a su rey en jaque");}
		}else{
			// Se pone verdadero el estado de jaque.
			request.getSession().setAttribute("jaque","true");
			// Si el movimiento no pone al rey en jaque, se procede.
			if (!eA.poneElMovimientoJugEnJaque(colorContrario,parOrigen[0],parOrigen[1],parDestino[0],parDestino[1] ) ){
				// Se verifica que el turno sea el del jugador actual.
				if (turnoActual == tAjedrez.getTColorPieza(parOrigen[0],parOrigen[1]) ){
					valido = eA.validarMovimiento(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
				}
				if (valido){
					// Se intercambian las piezas en el tablero
					tAjedrez.cambiarPiezas(parOrigen[0],parOrigen[1],parDestino[0],parDestino[1]);
					// Se cambia el turno.
					if (request.getSession().getAttribute("turno")=="blanca"){
						request.getSession().setAttribute("turno","negra");
					}else{
						request.getSession().setAttribute("turno","blanca");
					}
					// Se pone falso el estado de jaque.
					request.getSession().setAttribute("jaque","false");
				}
			}else{ 
				// Advierte que se esta en jaque!
				System.out.println("Se encuentra en haque, su movimiento debe evitar el haque.");
			}
		}
	
		// Se guarda de nuevo el estado del tablero en la sesion HTTP
		request.getSession().setAttribute("tablero",tAjedrez);
		
	}
	
	// Funcion que convierte un par ordenado de String a int y lo devuelve en un arreglo de 2 espacios.
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

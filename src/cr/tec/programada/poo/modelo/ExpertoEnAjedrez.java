package cr.tec.programada.poo.modelo;

/*Clase que verifica todas las posibles jugadas en el juego dependiendo del tablero Logico
 * Contiene un atributo de tipo Tablero(objeto)
 * dentro del metodo que valida la jugada realiza la opcion de "comer" una pieza
 * NOTA:Las referencias tomadas en esta clase son segun x1,y1,x2,y2 las cuales corresponden a pares ordenados segun una matriz
 * donde el (0,0) corresponde a la torre negra derecha el tablero respectivamente. Tomese esa referencia para encontrar las 
 * demas ubicaciones de las piezas.
*/
public class ExpertoEnAjedrez {
    private Tablero tLogico; //Tablero de clase tablero, inicializa el tablero listo para empezar la partida piezas blancas y negras
    
    public ExpertoEnAjedrez(Tablero tActual){//constructor de la clase
            tLogico=tActual;//actualiza el tablero con un tablero proporcionado por el servelet para conservar los cambios cuando se 

    
    public boolean revisarJaque(String colorContrario){
    	String turnoActual;
    	if (colorContrario.equals("blanca")){
    		turnoActual = "negra";
    	}else {turnoActual = "blanca"; }
    	
    	int posReyMiColor[] = new int[2];
    	posReyMiColor = tLogico.getPosRey(turnoActual);
    	
	    for (int x=0;x<8;x++){
	        for (int y=0;y<8;y++){
	            if (tLogico.getTColorPieza(x, y) == colorContrario){
	            	Pieza tmp = tLogico.getPieza(posReyMiColor[0],posReyMiColor[1]);	       
	            	if (validarMovimiento(x,y,posReyMiColor[0],posReyMiColor[1])){
	            		tLogico.setPieza(posReyMiColor[0],posReyMiColor[1],tmp);
	            		System.out.println("se esta en jaque..");
	            		return true;
	            	}
	            }
	        }
	    }
	    return false;
    }
    
    /*
	public boolean revisarMate(String color){
		String myColor;
		String enemyColor;
		Pieza pieza;
		if (color == "negra"){
			myColor = "n";
			enemyColor = "b";
		}else{
			myColor = "b";
			enemyColor = "n";

		int [] myColorValidMoves;
		for (int i = 0; i<8 ; i++){
			for (int j=0;j<8;j++){
				pieza = tLogico[i][j];
				if (pieza.getColor() == color){
					myColorValidMoves += (getListOfValidMoves(i,j));
				}
		}
		if (myColorValidMoves.lenght == 0){
			return true;
		}else{
			return false;
		}
		
	public int[] getListOfValidMoves(int x , int y){
		int []legalDestinationSpaces;
		for (int i = 0 ;i<8 ; i++){
			for (int j =0 ; j<8 ; j++){
				d = (i,j);
				if (validarMovimiento(x,y,i,j){
					if (!poneElMovimientoEnJaque(x,y,i,j) ){
						legalDestinationSpaces += d;
				}
			}
		}
		return legalDestinationSpaces;
	}
	
	*/
	public boolean poneElMovimientoJugEnJaque(String color, int xOrigen,int yOrigen,int xDestino,int yDestino){
		Pieza desdePieza = tLogico.getPieza(xOrigen,yOrigen);
		Pieza hastaPieza = tLogico.getPieza(xDestino,yDestino);

		tLogico.cambiarPiezas(xOrigen, yOrigen, xDestino, yDestino);

		boolean valor = revisarJaque(color);

		tLogico.setPieza(xDestino, yDestino,hastaPieza);
		tLogico.setPieza(xOrigen,yOrigen,desdePieza);

		return valor;
	}
    
}
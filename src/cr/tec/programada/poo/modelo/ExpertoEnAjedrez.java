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
                                            //se refresca la pagina
    }
   
    //Funcion principal de la clase, la cual verifica por medio de las coordenadas como de matriz
    //las posiciones y posibles movimiento dependiendo del tipo de pieza en el tablero logico
    //para despues mostrarlo en el tablero visual en el explorador.
    public boolean validarMovimiento(int x1,int y1,int x2,int y2){
                boolean isFicha=false;//variable necesaria para ver si es alguna ficha valida
        String tipo= tLogico.getTTipoPieza(x1, y1);//te obtiene el tipo de la pieza de origen(primer click)
        String color= tLogico.getTColorPieza(x1, y1);//te obtiene el color de la pieza de origen(primer click)
        //validaciones segun el tipo de ficha
        if (tipo == "peon"){
                isFicha=true;
                String colorContrario=this.getColorContario(x1, y1);//se obtiene el color contario para una validacion mas adelante
            if (color == "negra"){
                if (x1 < x2){//si x1 es menor quiere decir que la pieza se mueve hacia abajo en el tablero
                    if ((x1 == 1) && (x2 - x1 == 2) && (y2 == y1)){//validacion para saber si es la primera vez que el peon se mueve 
                        return true;
                    }
                    if (x2 - x1 == 1 && Math.abs(y1 - y2) <= 1){ //validaciones para saber si el peon solo se mueve un espacio adelante
                        if (color == tLogico.getTColorPieza(x2, y2)){//si hay una ficha del mismo color adelante el peon no se mueve
                                return false;
                        }else if (y1!=y2 && (tLogico.getTTipoPieza(x2, y2)=="vacia" || tLogico.getTColorPieza(x2, y2)==color)){
                                //esta validacion es necesaria para que el peon no se mueva a una casilla vacia como si tuviese que comer
                                        return false;
                                }
                    //se retorna falso si no se cumplen ninguna de las condiciones anteriores
                    }else{
                            return false;
                            }
                }else{
                        return false;
                }

            }
            else if (color == "blanca"){
                if (x1 > x2){//mismas validaciones que el peon negro.
                    if ((x1 == 6) && (x1 - x2 == 2) && (y2 == y1)){
                        return true;
                    }
                    if (x1 - x2 == 1 && Math.abs(y1 - y2) <= 1){
                        if (color==tLogico.getTTipoPieza(x2, y2)){
                                return false;
                        }
                        if (y1!=y2 && (tLogico.getTTipoPieza(x2, y2)=="vacia" || tLogico.getTColorPieza(x2, y2)==color)){
                                        return false;
                                }
                    }else{
                            return false;
                            }
                }else{return false;}
            }
            if (y1==y2 && colorContrario==tLogico.getTColorPieza(x2, y2) && x1!=x2){
                    return false;
            }
        }
    if (tipo == "torre"){
            isFicha=true;
        if ((x1 == x2) || (y1 == y2)){//moviemtos validos para la torre vertical u horizontal
            if (x1==x2){//si los x's son iguales se mueve horizontalmente
                if(validarMovimientoHorizontal(x1,y1,x2,y2)==false){//se usa una funcion auxiliar para verificar los movimientos horizontales
                        return false;
                }        
            }else{//si no se mueve de forma vertica;
                    if(validarMovimientoVertical(x1,y1,x2,y2)==false){//se usa una funcion auxiliar para verificar los movimientos verticales
                        return false;
                }
            }
        }else{
                return false;
        }
    }
    if (tipo == "alfil"){
            isFicha=true;
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)){//alfil se mueve en caso que los movimientos por las diagonales relativas sean equivalentes
            if (x2<x1){//se mueve para arriba 
                    if( this.validarDiagonalArriba(x1,y1,x2,y2)==false){//funcion auxiliar para validar el movimiento dialgonal hacia abajo segun x,y
                            return false;
                    }
            }else{//se mueve para abajo
                if(this.validarDiagonalAbajo(x1,y1,x2,y2)==false){//funcion auxiliar para validar el movimiento dialgonal hacia arriba segun x,y
                        return false;
                }
            }
            }else{
                    return false;
            }
    }
    if (tipo == "reina"){
            isFicha=true;
        if ((x1 == x2 || y1 == y2) || (Math.abs(x1 - x2) == Math.abs(y1 - y2))){//movimientos de la reina si son en linea recta o en diagonal unicamente
            if (x1==x2){//si se mueve en horizontal
                 if (this.validarMovimientoHorizontal(x1, y1, x2, y2)==false){
                         return false;
                 }
            }
            else if (y1==y2){//si se mueve en vertical
                if(this.validarMovimientoVertical(x1, y1, x2, y2)==false){
                        return false;
                }         
            }
            else if (x1!=x2 && y1!=y2){//si se mueve en diagonal
                if (x2<x1){//diagonal para arriba 
                        if(this.validarDiagonalArriba(x1, y1, x2, y2)==false){
                            return false;
                    }
                }
            }else{//diagonal para abajo
                if(this.validarDiagonalAbajo(x1, y1, x2, y2)==false){
                        return false;
                }
            }
        }else{
                return false;
        }
    }
    if (tipo == "rey"){
            isFicha=true;
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1){//rey puede mover cualquier cuadro a 1 de distancia
            if(tLogico.getTColorPieza(x2, y2)==color){//se verifica que la ficha donde se va a mover no contenga una ficha del mismo color
                    return false;
            }
        }else{
                return false;
        }
    }
    if (tipo == "caballo"){
            isFicha=true;
        if ((Math.abs(x1 - x2) + Math.abs(y1 - y2) == 3) && (Math.abs(x1-x2) >= 1) && (Math.abs(x1-x2) >= 1)){//validacion para movimiento del caballo
            if (tLogico.getTColorPieza(x2, y2)==color){//se verifica que la ficha donde se va a mover no contenga una ficha del mismo color
                    return false;
            }
        }else{
                return false;
        }
    }
    if (x1==x2 && y1==y2){//si el destino es el mismo que el origen se retorna que la jugada no es valida
            return false;
    }
    if (isFicha && color!=tLogico.getTColorPieza(x2, y2)){//si la ficha es de diferente color y es una ficha valida entonces se come la ficha y se retorna true
            this.comerFicha(x2,y2);
            return true;
    }
    return false;
    }
    
    //funcion que verifica los movimientos horizontales 
    //pisitivos a la derecha , negativos a la izquierda        
    //recibe los pares ordenados y con estos compara si el movimiento es valido por medio de un ciclo
    //que se incrementa o drecrementa segun los valores de y1 y y2.
    
    private boolean validarMovimientoHorizontal(int x1,int y1,int x2,int y2){
            String color=tLogico.getTColorPieza(x1, y1);
                String colorContrario=this.getColorContario(x1, y1);
                int saltaColor=0;        
        if (y2<y1){//si es y2 es menor entonces se mueve hacia la izquierda
            for (int j=y1;j!=y2;j--){//se conserva el y1 hasta llegar a y2 se disminuye el j
                if(tLogico.getTColorPieza(x1, j-1)==color){//se verifica si no es del mismo color
                        return false;
                }else if(tLogico.getTColorPieza(x1, j-1)==colorContrario){//si brinca alguna pieza de diferente color se incrementa el contador en 1
                        saltaColor++;
                }
            }
        }else{//misma tecinca anterior pero si va para la derecha se incrementa el contador
            for (int j=y1;j!=y2;j++){
                if(tLogico.getTColorPieza(x1, j+1)==color){//se verifica si no es del mismo color
                        return false;
                }else if(tLogico.getTColorPieza(x1, j+1)==colorContrario){
                        saltaColor++;
                }
            }
        }
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
                //si la posicion es vacia y se binca alguna ficha del color contrario se retorna false
                return false;
        }
        //si todo esta despejado se retorna true para realizar el movimiento
        return true;
    }
    //funcion que verifica los movimientos verticales 
    //pisitivos a la abajo , negativos a la arriba        
    //recibe los pares ordenados y con estos compara si el movimiento es valido por medio de un ciclo
    //que se incrementa o drecrementa segun los valores de x1 y x2.
    //esta funcion sigue el mismo esquema que la de verificaHorizontal
    private boolean validarMovimientoVertical(int x1,int y1,int x2,int y2){
            String color=tLogico.getTColorPieza(x1, y1);
                String colorContrario=this.getColorContario(x1, y1);
                int saltaColor=0;
        if (x2<x1){//se verifica si se mueve hacia arriba
            for (int j=x1;j!=x2;j--){
                if(tLogico.getTColorPieza(j-1,y1)==color){
                    return false;
                }else if(tLogico.getTColorPieza(j-1, y1)==colorContrario){
                        saltaColor++;
                }
            }                
        }else{//si no entonces se mueve hacia abajo
            for (int j=x1;j!=x2;j++){
                if(tLogico.getTColorPieza(j+1, y1)==color){
                        return false;
                }else if(tLogico.getTColorPieza(j+1, y1)==colorContrario){
                        saltaColor++;
                }
            }
        }
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
                //si la posicion es vacia y se binca alguna ficha del color contrario se retorna false
                return false;
        }
        return true;
    }
    
    //Recibe dos pares ordenados de cordenadas segun la matriz;
    //se recorre la matriz para arriba segun los Y se define si es para la derecha o para la izquierda
    //en este metodo se consideran los casos para los incremtentos
    //arriba a la izquierda significa un decremento en "x" y en "y"
    //arriba a la derecha significa un decremtento en "x" y un aumento en "y"
    
    private boolean validarDiagonalArriba(int x1,int y1,int x2,int y2){
            String color=tLogico.getTColorPieza(x1, y1);
                String colorContrario=this.getColorContario(x1, y1);
                int saltaColor=0;
                int contador=1;
        if (y2<y1){//va para la izquierda
            for(int j=y1;j!=y2;j--){
                    if (tLogico.getTColorPieza(x1-contador, j-1)==color){
                            return false;
                    }else if(tLogico.getTColorPieza(x1-contador, j-1)==colorContrario){
                            saltaColor++;
                    }
                    contador++;//contador para hacer la resta a la posicion relativa a consultar
            }
        }else{//va para la derecha
        for(int j=y1;j!=y2;j++){
                if (tLogico.getTColorPieza(x1-contador, j+1)==color){
                        return false;
                }else if(tLogico.getTColorPieza(x1-contador, j-1)==colorContrario){
                        saltaColor++;//contador para hacer la resta a la posicion relativa a consultar
                }
                contador++;
            }
        }
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
                return false;
        }
        return true;
    }
    //Recibe dos pares ordenados de cordenadas segun la matriz;
    //se recorre la matriz para abajo segun los Y se define si es para la derecha o para la izquierda
    //en este metodo se consideran los casos para los incremtentos
    //abajo a la izquierda significa un incremento en "x" y un decremento en "y"
    //abajo a la derecha significa un incremento en "x" y en "y"    
    private boolean validarDiagonalAbajo(int x1,int y1,int x2,int y2){
                    String color=tLogico.getTColorPieza(x1, y1);
                    String colorContrario=this.getColorContario(x1, y1);
                    int saltaColor=0;
                    int contador=1;
            if (y2<y1){//va para la izquierda 
                    for(int j=y1;j!=y2;j--){
                            if (tLogico.getTColorPieza(x1+contador, j-1)==color){
                                    return false;
                            }else if(tLogico.getTColorPieza(x1+contador, j+1)==colorContrario){
                                    saltaColor++;
                            }
                            contador++;//contador para hacer la resta a la posicion relativa a consultar
                    }
            }else{//va para la derecha
                    for(int j=y1;j!=y2;j++){
                            if (tLogico.getTColorPieza(x1+contador, j+1)==color){
                                    return false;
                            }else if(tLogico.getTColorPieza(x1+contador, j+1)==colorContrario){
                                    saltaColor++;
                            }
                            contador++;//contador para hacer la resta a la posicion relativa a consultar
                    }
            }
            if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
                    return false;
            }
            return true;
    }
    //se pasa por parametro la ficha que se va a remover del tablero
    private void comerFicha(int x2,int y2){
            tLogico.ponerFichaVacia(x2, y2);
            
    }
    //retirna un str con el color contrio de la pieza que se dio la primer eleccion
    private String getColorContario(int x1,int y1){
            String color=tLogico.getTColorPieza(x1, y1);
                String colorContrario;
                if (color=="negra"){
                        colorContrario="blanca";
                }else{colorContrario="negra";}
                return colorContrario;
    }
    
    
    
    public int[] getPosRey(String Color){
    	int posRey[] = new int[2];
	    for (int x=0;x<8;x++){
	        for (int y=0;y<8;y++){
	        	if (tLogico.getTColorPieza(x, y)=="rey"){
		        	if (tLogico.getTColorPieza(x, y)==Color){
		        		posRey[0] = x;
		        		posRey[1] = y;
		        		break;
		        	}
	        	}
	        }
	    }
    	return posRey;
    }
    
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
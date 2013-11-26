package cr.tec.programada.poo.modelo;


public class Tablero {
	// Tablero logico de 8x8 de Piezas
	private Pieza tLogico[][]= new Pieza[8][8];
	
	// Constructor del tablero, lo inicializa con las piezas en sus posiciones 
	// corresponientes al inicio.
	public Tablero(){
		Pieza peonBlanco=new Pieza("blanca","peon","img/peonBlanco.png");
		Pieza peonNegro=new Pieza("negra","peon","img/peonNegro.png");
		tLogico = new Pieza[8][8];
		// Inicializa los espacios vacios.
		for (int i=0; i<8;i++){
			for(int j=0;j<8;j++){
					tLogico[i][j]= new Pieza();
					tLogico[i][j]= new Pieza();
			}
		}
		// Inicializa los espacios con peones.
		for (int i=0; i<8;i++){
				tLogico[1][i]=  peonNegro;
				tLogico[6][i]=  peonBlanco;
		}
		// Se define manualmente la ubicacion de las piezas en el tablero logico
		// para dar inicio al juego.
		tLogico[0][0].definePieza("negra","torre", "img/torreNegro.png");
		tLogico[0][7].definePieza("negra","torre", "img/torreNegro.png");
		tLogico[7][0].definePieza("blanca","torre", "img/torreBlanco.png");
		tLogico[7][7].definePieza("blanca","torre", "img/torreBlanco.png");
		tLogico[0][1].definePieza("negra","caballo", "img/caballoNegro.png");
		tLogico[0][6].definePieza("negra","caballo", "img/caballoNegro.png");
		tLogico[7][1].definePieza("blanca","caballo", "img/caballoBlanco.png");
		tLogico[7][6].definePieza("blanca","caballo", "img/caballoBlanco.png");
		tLogico[0][2].definePieza("negra","alfil", "img/alfilNegro.png");
		tLogico[0][5].definePieza("negra","alfil", "img/alfilNegro.png");
		tLogico[7][2].definePieza("blanca","alfil", "img/alfilBlanco.png");
		tLogico[7][5].definePieza("blanca","alfil", "img/alfilBlanco.png");
		tLogico[0][3].definePieza("negra","reina", "img/reinaNegro.png");
		tLogico[0][4].definePieza("negra","rey", "img/reyNegro.png");
		tLogico[7][4].definePieza("blanca","rey", "img/reyBlanco.png");
		tLogico[7][3].definePieza("blanca","reina", "img/reinaBlanco.png");
	}
	
	// Intercambia dos piezas en el tablero.
	public void cambiarPiezas(int x1,int y1, int x2, int y2){
		Pieza temp = getPieza(x1,y1);//tLogico[x1][y1]; 
		setPieza(x1,y1,getPieza(x2,y2));//tLogico[x2][y2]; 
		setPieza(x2,y2 ,temp);
	}
	
	// Devuelve el tipo de una pieza
	public String getTTipoPieza(int x,int y){
		return tLogico[x][y].getTipoPieza();
	}
	
	//Devuelve el color de una pieza
	public String getTColorPieza(int x,int y){
		return tLogico[x][y].getColor();
	}
	
	// Devuelve la ruta de una pieza
	public String getTRutaPieza(int x,int y){
		return tLogico[x][y].getRuta();
	}
	
	// Devuelve un vector con la posicion del rey del color actual.
	public int[] getPosRey(String color){
		int pos[] = new int[2];
	    for (int x=0;x<8;x++){
	        for (int y=0;y<8;y++){
	        	// Si se encuentra un rey en el tablero, se procede a verificar si es 
	        	// el color que andamos buscando
	            if (this.getTTipoPieza(x, y) == "rey"){
	            	// Si es el color buscado, se guarda su posicion en el vector para retornarlo. 
	                if (this.getTColorPieza(x, y) == color){
	                    pos[0] = x;
	                    pos[1] = y;
	                }
	            }
	        }
	    }
		return pos;
	}
	
	// Pone una ficha vacia en un espacio, para cuando se come.
	public void ponerFichaVacia(int x,int y){
		tLogico[x][y]= new Pieza();
	}
	
	// Devuelve una pieza del tablero.
	public Pieza getPieza(int x,int y){
		return tLogico[x][y];
	}
	
	// Setea una pieza del tablero.
	public void setPieza(int x,int y, Pieza p){
		tLogico[x][y]=p;
	}
};

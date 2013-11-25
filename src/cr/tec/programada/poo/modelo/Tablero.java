package cr.tec.programada.poo.modelo;


public class Tablero {
	private Pieza tLogico[][]= new Pieza[8][8];
	public Tablero(){
		Pieza peonBlanco=new Pieza("blanca","peon","img/peonBlanco.png");
		Pieza peonNegro=new Pieza("negra","peon","img/peonNegro.png");
		tLogico = new Pieza[8][8];
		for (int i=0; i<8;i++){
			for(int j=0;j<8;j++){
					tLogico[i][j]= new Pieza();
					tLogico[i][j]= new Pieza();
			}
		}
		for (int i=0; i<8;i++){
				tLogico[1][i]=  peonNegro;
				tLogico[6][i]=  peonBlanco;
		}
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
	
	public void cambiarPiezas(int x1,int y1, int x2, int y2){
		Pieza temp = tLogico[x1][y1]; 
		tLogico[x1][y1] = tLogico[x2][y2]; 
		tLogico[x2][y2] = temp;
	}
	
	public String getTTipoPieza(int x,int y){
		return tLogico[x][y].getTipoPieza();
	}
	public String getTColorPieza(int x,int y){
		return tLogico[x][y].getColor();
	}
	
	public String getTRutaPieza(int x,int y){
		return tLogico[x][y].getRuta();
	}
};

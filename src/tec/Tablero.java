package tec;

public class Tablero {
	private Pieza tLogico[][]= new Pieza[5][5];
	public Tablero(){
		for (int i=2; i<6;i++){
			for (int j=0; j<8;j++){
				tLogico[i][j]= new Pieza();
			}
		}	
	}

public static void main(String []args){
	Tablero tableroJuego = new Tablero();
	}

};

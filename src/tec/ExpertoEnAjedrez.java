package tec;

public class ExpertoEnAjedrez {
	static private Pieza tLogico[][];
	public ExpertoEnAjedrez(){
		Pieza peonBlanco=new Pieza("blanca","peon","/img/peonBlanco.png");
		Pieza peonNegro=new Pieza("negra","peon","/img/peonNegro.png");
		
		tLogico = new Pieza[8][8];
		
		for (int i=0; i<8;i++){
				tLogico[1][i]= (Pieza) peonNegro;
				tLogico[6][i]=peonBlanco;
			}
		tLogico[0][0].definePieza("negra","torre", "/img/torreNegro.png");
		tLogico[0][7].definePieza("negra","torre", "/img/torreNegro.png");
		tLogico[7][0].definePieza("blanca","torre", "/img/torreBlanco.png");
		tLogico[7][7].definePieza("blanca","torre", "/img/torreBlanco.png");
		tLogico[0][1].definePieza("negro","caballo", "/img/caballoNegro.png");
		tLogico[0][6].definePieza("negro","caballo", "/img/caballoNegro.png");
		tLogico[7][1].definePieza("blanca","caballo", "/img/caballoBlanco.png");
		tLogico[7][6].definePieza("blanca","caballo", "/img/caballoBlanco.png");
		tLogico[0][2].definePieza("negro","alfil", "/img/alfilNegro.png");
		tLogico[0][5].definePieza("negro","alfil", "/img/alfilNegro.png");
		tLogico[7][2].definePieza("blanco","alfil", "/img/alfilBlanco.png");
		tLogico[7][5].definePieza("blanco","alfil", "/img/alfilBlanco.png");
		tLogico[0][3].definePieza("negro","reina", "/img/reinaNegro.png");
		tLogico[0][4].definePieza("negro","rey", "/img/reyNegro.png");
		tLogico[7][4].definePieza("blanco","rey", "/img/reyBlanco.png");
		tLogico[7][3].definePieza("blanco","reina", "/img/reinaBlanco.png");
		
	}
	
	

	/*
	 * 
	// metodo Validar
    public boolean Validar(int x1, int y1, int x2, int y2){
        if (tipo == "peon"){
            if (color == "negro"){
                if (y1 < y2){
                    if ((y1 == 1) && (y2 - y1 == 2) && (x2 == x1))
                        return true;
                    if (y2 - y1 == 1 && Math.abs(x1 - x2) <= 1)
                        return true;
                }
			}
            else if (color == "blanco"){
                if (y1 > y2){
                    if ((y1 == 6) && (y1 - y2 == 2) && (x2 == x1))
                        return true;
                    if (y1 - y2 == 1 && Math.abs(x1 - x2) <= 1)
                        return true;
                }
			}
        }

    if (tipo == "torre")
    	if ((x1 == x2) || (y1 == y2))
            return true;
    if (tipo == "alfil")
    	if (Math.abs(x1 - x2) == Math.abs(y1 - y2))
            return true;
    if (tipo == "reina")
        if ((x1 == x2 || y1 == y2) || (Math.abs(x1 - x2) == Math.abs(y1 - y2)))
            return true;
    if (tipo == "rey")
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1)
            return true;
    if (tipo == "caballo")
        if ((Math.abs(x1 - x2) + Math.abs(y1 - y2) == 3) && (Math.abs(x1-x2) >= 1) && (Math.abs(x1-x2) >= 1))
            return true;
    return false;
}
    
    */
    
}

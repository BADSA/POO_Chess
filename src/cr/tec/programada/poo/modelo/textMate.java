	public boolean isMate(String color){
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
					if (!doesMovePutPlayerInCheck(x,y,i,j) ){
						legalDestinationSpaces += d;
				}
			}
		}
		return legalDestinationSpaces;
	}
		
	public boolean doesMovePutPlayerInCheck(color,fromTuple,toTuple){
		xOrigen = fromTuple[0];
		yOrigen = fromTuple[1];
		xDestino = toTuple[0];
		yDestino = toTuple[1];
		Pieza desdePieza = tLogico[xOrigen][yOrigen];
		Pieza hastaPieza = tLogico[xDestino][yDestino];

		tLogico[xDestino][yDestino] = desdePieza;
		tLogico[xOrigen][xDestino] = new Pieza();

		boolean valor = isInJaque(color);

		tLogico[xDestino][yDestino] = hastaPieza;
		tLogico[xOrigen][yOrigen] = desdePieza;

		return valor;
	}
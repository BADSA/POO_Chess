package cr.tec.programada.poo.modelo;

public class ExpertoEnAjedrez {
        private Tablero tLogico;
        
        public ExpertoEnAjedrez(Tablero tActual){
                tLogico=tActual;
        }
        
   
    public boolean validarMovimiento(int x1,int y1,int x2,int y2){
    		boolean isFicha=false;
            String tipo= tLogico.getTTipoPieza(x1, y1);
            String color= tLogico.getTColorPieza(x1, y1);
        System.out.println(tipo+ " "+color );
        if (tipo == "peon"){
        	isFicha=true;
        	String colorContrario="";
            if (color == "negra"){
               colorContrario="blanca";
                if (x1 < x2){
                    if ((x1 == 1) && (x2 - x1 == 2) && (y2 == y1)){
                        return true;
                    }
                    if (x2 - x1 == 1 && Math.abs(y1 - y2) <= 1){ 
                        if (color == tLogico.getTColorPieza(x2, y2)){
                        	return false;
                        }else if (y1!=y2 && (tLogico.getTTipoPieza(x2, y2)=="vacia" || tLogico.getTColorPieza(x2, y2)==color)){
                			return false;
                		}
                    }else{
                    	return false;
                    	}
                }else{
                	return false;
                }

            }
            else if (color == "blanca"){
            	colorContrario="negra";
                if (x1 > x2){
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
        if ((x1 == x2) || (y1 == y2)){
            if (x1==x2){
            	System.out.println("aqui toree"+validarMovimientoHorizontal(x1,y1,x2,y2) );
                if(validarMovimientoHorizontal(x1,y1,x2,y2)==false){
                	return false;
                }	
            }else{
            	System.out.println("aqui toree"+validarMovimientoHorizontal(x1,y1,x2,y2) );
            	if(validarMovimientoVertical(x1,y1,x2,y2)==false){
                	return false;
                }
            }
        }else{
        	return false;
        }
    }
    if (tipo == "alfil"){
    	isFicha=true;
    	if (Math.abs(x1 - x2) == Math.abs(y1 - y2)){
            if (x2<x1){//va para arriba 
                    if( this.validarDiagonalArriba(x1,y1,x2,y2)==false){
                    	return false;
                    }
            }else{//va para abajo
                if(this.validarDiagonalAbajo(x1,y1,x2,y2)==false){
                	return false;
                }
            }
    	}else{
    		return false;
    	}
    }
    if (tipo == "reina"){
    	isFicha=true;
        if ((x1 == x2 || y1 == y2) || (Math.abs(x1 - x2) == Math.abs(y1 - y2))){
            if (x1==x2){
                 if (this.validarMovimientoHorizontal(x1, y1, x2, y2)==false){
                	 return false;
                 }
            }
            else if (y1==y2){
                if(this.validarMovimientoVertical(x1, y1, x2, y2)==false){
                	return false;
                } 	
            }
            else if (x1!=x2 && y1!=y2){
                if (x2<x1){//va para arriba 
                	if(this.validarDiagonalArriba(x1, y1, x2, y2)==false){
                    	return false;
                    }
                }
            }else{//va para abajo
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
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1){
            if(tLogico.getTColorPieza(x2, y2)==color){
                    return false;
            }
        }else{
        	return false;
        }
    }
    if (tipo == "caballo"){
    	isFicha=true;
        if ((Math.abs(x1 - x2) + Math.abs(y1 - y2) == 3) && (Math.abs(x1-x2) >= 1) && (Math.abs(x1-x2) >= 1)){
                System.out.println(tLogico.getTColorPieza(x2, y2));
            if (tLogico.getTColorPieza(x2, y2)==color){
                    return false;
            }
        }else{
        	return false;
        }
    }
    if (x1==x2 && y1==y2){
    	return false;
    }
    if (isFicha && color!=tLogico.getTColorPieza(x2, y2)){
    	this.comerFicha(x2,y2);
    	return true;
    }
    return false;
    }
    
    private boolean validarMovimientoHorizontal(int x1,int y1,int x2,int y2){
    	String color=tLogico.getTColorPieza(x1, y1);
		String colorContrario=this.getColorContario(x1, y1);
		int saltaColor=0;	
        if (y2<y1){
            for (int j=y1;j!=y2;j--){
                if(tLogico.getTColorPieza(x1, j-1)==color){
                        return false;
                }else if(tLogico.getTColorPieza(x1, j-1)==colorContrario){
                	saltaColor++;
                }
            }
        }else{
            for (int j=y1;j!=y2;j++){
                if(tLogico.getTColorPieza(x1, j+1)==color){
                        return false;
                }else if(tLogico.getTColorPieza(x1, j+1)==colorContrario){
                	saltaColor++;
                }
            }
        }
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
        	return false;
        }
        return true;
    }
    		// 0,0 - 4,0
    private boolean validarMovimientoVertical(int x1,int y1,int x2,int y2){
    	String color=tLogico.getTColorPieza(x1, y1);
		String colorContrario=this.getColorContario(x1, y1);
		int saltaColor=0;
        if (x2<x1){
            for (int j=x1;j!=x2;j--){
                if(tLogico.getTColorPieza(j-1,y1)==color){
                    return false;
                }else if(tLogico.getTColorPieza(j-1, y1)==colorContrario){
                	saltaColor++;
                }
            }                
        }else{
            for (int j=x1;j!=x2;j++){
                if(tLogico.getTColorPieza(j+1, y1)==color){
                	return false;
                }else if(tLogico.getTColorPieza(j+1, y1)==colorContrario){
                	saltaColor++;
                }
            }
        }
        System.out.println(saltaColor);
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
        	return false;
        }
        return true;
    }
    
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
                    contador++;
                    System.out.println(j);
            }
        }else{//va para la derecha
        for(int j=y1;j!=y2;j++){
                if (tLogico.getTColorPieza(x1-contador, j+1)==color){
                        return false;
                }else if(tLogico.getTColorPieza(x1-contador, j-1)==colorContrario){
                	saltaColor++;
                }
                contador++;
                System.out.println(j);
            }
        }
        if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
        	return false;
        }
        return true;
    }
    
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
                            contador++;
                            System.out.println(j);
                    }
            }else{//va para la derecha
                    for(int j=y1;j!=y2;j++){
                            if (tLogico.getTColorPieza(x1+contador, j+1)==color){
                                    return false;
                            }else if(tLogico.getTColorPieza(x1+contador, j+1)==colorContrario){
                            	saltaColor++;
                            }
                            contador++;
                            System.out.println(j);
                    }
            }
            if (saltaColor>1 || (saltaColor>=1 && tLogico.getTTipoPieza(x2, y2)=="vacia")){
            	return false;
            }
            return true;
    }
    private void comerFicha(int x2,int y2){
    	tLogico.ponerFichaVacia(x2, y2);
    	
    }
    private String getColorContario(int x1,int y1){
    	String color=tLogico.getTColorPieza(x1, y1);
		String colorContrario;
		if (color=="negra"){
			colorContrario="blanca";
		}else{colorContrario="negra";}
		return colorContrario;
    }
  /*  
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
    

        
        
        //metodo Jaque
                public String Jaque(Piezas[][] matrizPiezas, int[] Reyblanco, int[] Reynegro){
                        int negro = 0;
                        int blanco = 0;
                        for (int x=0;x<8;x++){
                                for (int y=0;y<8;y++){
                                        if (matrizPiezas[y][x] != null){
                                                if (matrizPiezas[y][x].getColor().equals("negro")) {
                                                        if (matrizPiezas[y][x].Validar(x, y, Reyblanco[0], Reyblanco[1]) && Verificar (x, y, Reyblanco[0], Reyblanco[1]) && Comer (x, y, Reyblanco[0], Reyblanco[1]))
                                                                blanco = 1;
                            }
                                                if (matrizPiezas[y][x].getColor().equals("blanco"))
                                                        if (matrizPiezas[y][x].Validar(x, y, Reynegro[0], Reynegro[1]) && Verificar (x, y, Reynegro[0], Reynegro[1]) && Comer (x, y, Reynegro[0], Reynegro[1]))
                                                                negro = 1;                
                                        }
                                }
                        }
                        if (negro == blanco){
                                if (negro == 1)
                                        return "ambos";
                                else
                                        return "no";
                        }
                        else if (negro > blanco){
                                return "negro";
                        }
                        else
                                return "blanco";
                }        
                
                //metodo JaqueMate
            public boolean JaqueMate(){
                        int[][] pieza;
                        int[] coor = new int[2];
                        int[] Reyb = new int[2];
                        int[] Reyn = new int[2];
                        System.arraycopy(Reyblanco,0,Reyb,0,2);
                        System.arraycopy(Reynegro,0,Reyn,0,2);
                        Piezas[][] tablero = new Piezas[8][8];
                        for (int x=0;x<8;x++){
                                for (int y=0;y<8;y++){
                                        tablero[y][x] = matrizPiezas[y][x];
                                }
                        }
                        Piezas temp1, temp2;
                    for (int x=0;x<8;x++){
                                for (int y=0;y<8;y++){
                                        if (matrizPiezas[y][x] != null){
                                                if (matrizPiezas[y][x].getColor().equals(Jaque(matrizPiezas, Reyblanco, Reynegro))) {
                                                        pieza = Movimientos(x,y);
                                                        for(int i=0; i<pieza[50][0]; i++){
                                                                System.arraycopy(pieza[i],0,coor,0,2);
                                                                coor = pieza[i];
                                                                temp1 = tablero[y][x];
                                                                temp2 = tablero[coor[1]][coor[0]];
                                                                tablero[y][x] = null;
                                                                tablero[coor[1]][coor[0]] = temp1;
                                                                //Guarda las coordenadas de cada rey
                                                                if (tablero[y][x].getTipo().equals("rey")){
                                                                        switch (tablero[y][x].getColor()) {
                                                                                case "blanco":
                                                                                        Reyb[0] = x;
                                                                                        Reyb[1] = y;
                                                                                        break;
                                                                                case "negro":
                                                                                        Reyn[0] = x;
                                                                                        Reyn[1] = y; 
                                                                                        break;
                                                                        }
                                                                }
                                                                if (Jaque(tablero, Reyb, Reyn).equals("no"))
                                                                        return false;
                                                                tablero[y][x] = temp1;
                                                                tablero[coor[1]][coor[0]] = temp2;
                                                        }
                            }
                                        }
                                }
                        }
                    return true;
            }
        
        
        //metodo Verificar
    public boolean Verificar(int x1, int y1, int x2, int y2){
        if (matrizPiezas[y1][x1].getTipo().equals("peon")){
            if (matrizPiezas[y2][x2] == null && x1 != x2)
                return false;
            if (matrizPiezas[y2][x2] != null && x1 == x2)
                return false;
        }
        else if (!matrizPiezas[y1][x1].getTipo().equals("caballo")){
            int x = x1;
            int y = y1;
            while (y != y2 || x != x2){
                                if (matrizPiezas[y][x] != agujero)
                                        if (matrizPiezas[y][x] != null && !(x1 == x && y1 == y))
                                                        return false;
                                        if (x < x2)
                                                x ++;
                                        if (x > x2)
                                                x --;
                                        if (y < y2)
                                                y ++;
                                        if (y > y2)
                                                y --;
            }
        }
                return true;
    }
*/
    
}
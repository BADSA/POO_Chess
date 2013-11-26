package cr.tec.programada.poo.modelo;

public class ExpertoEnAjedrez {
	private Tablero tLogico;
	public ExpertoEnAjedrez(){
		tLogico=new Tablero();
	}
	
    public boolean validarMovimiento(String origen, String  destino){
<<<<<<< HEAD:src/cr/tec/programada/poo/modelo/ExpertoEnAjedrez.java
        int parOrigen[]=new int[2]; //arreglos para almacenar los dos numeros de origen y destino
        int parDestino[]=new int[2];
        int i=0;
        String orig[] = origen.split("\\,");
        String dest[] = destino.split("\\,");
        for (String s :orig){
                parOrigen[i]= Integer.parseInt(s);
                i++;
        }
        i=0;
        for (String s : dest){
                parDestino[i]= Integer.parseInt(s);
                i++;
        }
        
        int x1=parOrigen[1];
        int y1=parOrigen[0];
        
        int x2=parDestino[1];
        int y2=parDestino[0];
        
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
    	String tipo= tLogico.getTTipoPieza(y1, x1);
    	String color= tLogico.getTColorPieza(y1, x1);
    	System.out.println("Tipo es:"+tipo+" color pieza:"+color);
=======
    	int parOrigen[]=new int[2]; //arreglos para almacenar los dos numeros de origen y destino
    	int parDestino[]=new int[2];
    	int i=0;
    	String[] oring=origen.split("\\,");
    	String[] dest=destino.split("\\,");
    	for (String s : oring){
    		parOrigen[i]= Integer.parseInt(s);
    		i++;
    	}
    	i=0;
    	for (String s : dest){
    		parDestino[i]= Integer.parseInt(s);
    		i++;
    	}
    	int x1=parOrigen[0];
    	int y1=parOrigen[1];
    	int x2=parDestino[0];
    	int y2=parDestino[1];
    	String tipo= tLogico.getTTipoPieza(x1, y1);
    	String color= tLogico.getTColorPieza(x1, y1);
>>>>>>> bd2994efce33947ef72a726a2ef1022a8dcc3bcb:src/tec/ExpertoEnAjedrez.java
        if (tipo == "peon"){
            if (color == "negra"){
                if (y1 < y2){
                    if ((y1 == 1) && (y2 - y1 == 2) && (x2 == x1)){
                        return true;
                    }
                    if (y2 - y1 == 1 && Math.abs(x1 - x2) <= 1){
                    	if (color==tLogico.getTColorPieza(x2, y2)){
                    		return false;
                    	}
                        return true;
                    }
                }
			}
            else if (color == "blanca"){
                if (y1 > y2){
                    if ((y1 == 6) && (y1 - y2 == 2) && (x2 == x1)){
                        return true;
                    }
                    if (y1 - y2 == 1 && Math.abs(x1 - x2) <= 1){
                    	if (color==tLogico.getTColorPieza(x2, y2)){
                    		return false;
                    	}
                        return true;
                    }
                }
			}
        }
    if (tipo == "torre"){
    	if ((x1 == x2) || (y1 == y2)){
    		if (x1==x2){
    			if (y2<y1){
    				for (int j=y1;j!=y2;j--){
    					if(tLogico.getTTipoPieza(x1, j-1)!="vacia"){
    						return false;
    					}
    				}
    			}else{
    				for (int j=y1;j!=y2;j++){
    					if(tLogico.getTTipoPieza(x1, j+1)!="vacia"){
    						return false;
    					}
    				}
    			}
    		}else{
    			if (x2<x1){
    				for (int j=x1;j!=x2;j--){
    					if(tLogico.getTTipoPieza(j-1,y1)!="vacia"){
    						return false;
    					}
    				}
    				
    			}else{
    				for (int j=y2;j!=y1;j++){
    					if(tLogico.getTTipoPieza(j+1, y1)!="vacia"){
    						return false;
    					}
    				}
    			}
    		}
    	}
        return true;
    }
    if (tipo == "alfil")
    	if (Math.abs(x1 - x2) == Math.abs(y1 - y2)){
            if (x2<x1){//va para arriba 
            	if (y2<y1){//va para la izquierda
            		for(int j=y1;j!=y2;j--){
            			if (tLogico.getTTipoPieza(x1+((j-y1)-1), j-1)!="vacia"){
            				return false;
            			}
            		}
            	}else{//va para la derecha
            		for(int j=y1;j!=y2;j++){
            			if (tLogico.getTTipoPieza(x1+((j-y1)-1), j+1)!="vacia"){
            				return false;
            			}
            		}
            	}
            	
            }else{//va para abajo
            	if (y2<y1){//va para la izquierda 
            		for(int j=y1;j!=y2;j--){
            			if (tLogico.getTTipoPieza(x1+((y1-j)+1), j-1)!="vacia"){
            				return false;
            			}
            		}
            	}else{//va para la derecha
            		for(int j=y1;j!=y2;j++){
            			if (tLogico.getTTipoPieza(x1-((j-y1)-1), j+1)!="vacia"){
            				return false;
            			}
            		}
            	}
            }
    		return true;
        }
    if (tipo == "reina")
        if ((x1 == x2 || y1 == y2) || (Math.abs(x1 - x2) == Math.abs(y1 - y2))){
        	if (x1==x2){
        		if (y2<y1){
    				for (int j=y1;j!=y2;j--){
    					if(tLogico.getTTipoPieza(x1, j-1)!="vacia"){
    						return false;
    					}
    				}
    			}else{
    				for (int j=y1;j!=y2;j++){
    					if(tLogico.getTTipoPieza(x1, j+1)!="vacia"){
    						return false;
    					}
    				}
    			}
        	}
        	else if (y1==y2){
        		if (x2<x1){
    				for (int j=x1;j!=x2;j--){
    					if(tLogico.getTTipoPieza(j-1, y1)!="vacia"){
    						return false;
    					}
    				}
    			}else{
    				for (int j=x1;j!=x2;j++){
    					if(tLogico.getTTipoPieza(j+1, y1)!="vacia"){
    						return false;
    					}
    				}
    			}
        	}
        	else if (x1!=x2 && y1!=y2){
        		if (x2<x1){//va para arriba 
                	if (y2<y1){//va para la izquierda
                		for(int j=y1;j!=y2;j--){
                			if (tLogico.getTTipoPieza(x1+((j-y1)-1), j-1)!="vacia"){
                				return false;
                			}
                		}
                	}else{//va para la derecha
                		for(int j=y1;j!=y2;j++){
                			if (tLogico.getTTipoPieza(x1+((j-y1)-1), j+1)!="vacia"){
                				return false;
                			}
                		}
                	}
                	
                }else{//va para abajo
                	if (y2<y1){//va para la izquierda 
                		for(int j=y1;j!=y2;j--){
                			if (tLogico.getTTipoPieza(x1+((y1-j)+1), j-1)!="vacia"){
                				return false;
                			}
                		}
                	}else{//va para la derecha
                		for(int j=y1;j!=y2;j++){
                			if (tLogico.getTTipoPieza(x1-((j-y1)-1), j+1)!="vacia"){
                				return false;
                			}
                		}
                	}
                }
        	}
            return true;
        }
    if (tipo == "rey")
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1){
        	if(tLogico.getTColorPieza(x2, y2)==color){
        		return false;
        	}
        	return true;
        }      
    if (tipo == "caballo")
        if ((Math.abs(x1 - x2) + Math.abs(y1 - y2) == 3) && (Math.abs(x1-x2) >= 1) && (Math.abs(x1-x2) >= 1)){
            if (tLogico.getTColorPieza(x2, y2)==color){
            	return false;
            }
        	return true;
        }
    return false;
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


    
}

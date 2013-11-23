package tec;

public class ExpertoEnAjedrez {
	private Tablero tLogico;
	public ExpertoEnAjedrez(){
		tLogico=new Tablero();
	}
	
    public boolean validarMovimiento(String origen, String  destino){
    	int parOrigen[]=new int[2]; //arreglos para almacenar los dos numeros de origen y destino
    	int parDestino[]=new int[2];
    	int i=0;
    	origen.split("\\,");
    	destino.split("\\,");
    	for (String s : origen){
    		parOrigen[i]= Integer.parseInt(s);
    		i++
    	}
    	i=0;
    	for (String s : destino){
    		parDestino[i]= Integer.parseInt(s);
    		i++
    	}
    	int x1=parOrigen[0];
    	int y1=parOrigen[1];
    	int x2=parDestino[0];
    	int y2=parDestino[1];
    	
    	String tipo= tLogico.getTTipoPieza(x1, y1);
    	String color= tLogico.getTColorPieza(x1, y1);
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
}
    
      


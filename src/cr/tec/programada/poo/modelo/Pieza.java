package cr.tec.programada.poo.modelo;

public class Pieza{
	String color;
	private String tipoPieza;
	private int x,y;
	private String rutaImagen;
	
	// Inicializa una pieza vacia
	public Pieza(){
		this.tipoPieza = "vacia";
		this.color = "Transparente"; 
		this.rutaImagen="img/transparente.png";
	}
	
	public Pieza(String color,String tipoPieza){
		this.color=color;
		this.tipoPieza=tipoPieza;
	}
	
	public Pieza(String color,String tipoPieza,String ruta){
		this.color=color;
		this.tipoPieza=tipoPieza;
		this.rutaImagen=ruta;
	}
	
	void definePieza(String color,String tipoPieza,String ruta){
		this.color=color;
		this.tipoPieza=tipoPieza;
		this.rutaImagen=ruta;
	}
	
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return tipoPieza;
	}

	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
		
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
	public String getColor(){
		return this.color;
	}
	public void setRuta(String ruta){
		this.rutaImagen=ruta;
	}
	public String getRuta(){
		return this.rutaImagen;
	}
}

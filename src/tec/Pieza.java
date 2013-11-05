package tec;

public class Pieza{
	String color;
	private String tipoPieza;
	private int x,y;
	private String rutaImagen;
	
	public Pieza(){
		this.tipoPieza = "Vacia";
		this.color = "Transparente"; 
		this.rutaImagen="/img/Transparente.png";
	}
	
	public Pieza(String color){
		this.color=color;
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

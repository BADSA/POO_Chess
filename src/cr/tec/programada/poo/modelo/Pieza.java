package cr.tec.programada.poo.modelo;

public class Pieza{
	String color;
	private String tipoPieza;
	private String rutaImagen;
	
	// Inicializa una pieza vacia
	public Pieza(){
		this.tipoPieza = "vacia";
		this.color = "Transparente"; 
		this.rutaImagen="img/transparente.png";
	}
	
	// Inicializa una pieza con el color y el tipo de pieza
	public Pieza(String color,String tipoPieza){
		this.color=color;
		this.tipoPieza=tipoPieza;
	}
	
	// Inicializa una pieza con el color, tipo de pieza y la ruta de su imagen.
	public Pieza(String color,String tipoPieza,String ruta){
		this.color=color;
		this.tipoPieza=tipoPieza;
		this.rutaImagen=ruta;
	}
	
	// Define una pieza con los parametros recibidos.
	void definePieza(String color,String tipoPieza,String ruta){
		this.color=color;
		this.tipoPieza=tipoPieza;
		this.rutaImagen=ruta;
	}
	
	// Devuelve el tipo de una pieza
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return tipoPieza;
	}

	// Setea el tipo de una pieza
	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
		
	}

	// Devuelve el color de una pieza
	public String getColor(){
		return this.color;
	}
	// Setea la ruta de una pieza
	public void setRuta(String ruta){
		this.rutaImagen=ruta;
	}
	
	// Obtiene la ruta de una pieza.
	public String getRuta(){
		return this.rutaImagen;
	}
}

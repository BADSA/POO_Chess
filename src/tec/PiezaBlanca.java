package tec;

public class PiezaBlanca implements Pieza {
	private String tipoPieza;
	private int x,y;
	
	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return tipoPieza;
	}

	@Override
	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
}

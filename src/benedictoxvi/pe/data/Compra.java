package benedictoxvi.pe.data;

public class Compra extends Movimiento{

	
	public boolean isAnulada(){
		if (getEstado().equals("ANULADA"))
			return true;
		return false;
	}
	
	public boolean isNueva(){
		if (getEstado().equals("NUEVA"))
			return true;
		return false;
	}
	
	public boolean isCancelada(){
		if (getEstado().equals("CANCELADA"))
			return true;
		return false;
	}
	
	public void pagar(){
		setEstado("CANCELADA");
	}
	
	public void anular(){
		setEstado("ANULADA");
	}
	
}

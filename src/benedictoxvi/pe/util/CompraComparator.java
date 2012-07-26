package benedictoxvi.pe.util;

import java.util.Comparator;

import benedictoxvi.pe.data.Compra;

public class CompraComparator implements Comparator<Compra> {

	Validaciones objValidaciones = new Validaciones();
	@Override
	public int compare(Compra o1, Compra o2) {
		// TODO Auto-generated method stub
		return (-1*(objValidaciones.dateToInt(o1.getFecVencim()) - objValidaciones.dateToInt(o2.getFecVencim())));
	}
	 
}
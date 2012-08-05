package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Cliente;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;

public class AdmCliente {

	ArrayList<Cliente> arrCli = new ArrayList<Cliente>();
	DataBD bd = new DataBD();
	
	public AdmCliente() {
		// TODO Auto-generated constructor stub
		arrCli = bd.getDataCliente();
	}
	
	public Cliente getClienteByCod(String cod_cli){
		for(Cliente cli : arrCli){
			if (cli.getCodCliente().equals(cod_cli)){
				return cli;
			}
		}
		new ProcessException("El Codigo de Cliente '"+cod_cli+"' no se encuentra registrado.").printStackTrace();
		return null;
	}
	
}

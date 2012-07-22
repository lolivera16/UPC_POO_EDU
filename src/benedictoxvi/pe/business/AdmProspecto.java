package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Prospecto;

public class AdmProspecto {

	public ArrayList<Prospecto> findProspecto(ArrayList<Prospecto> data,String nombs, String apepat,
			String apemat, String mail, String dni, String tel_cel, String fecha) {
		// TODO Auto-generated method stub
		 ArrayList<Prospecto> filtro = new ArrayList<Prospecto>();
		 for(Prospecto objPro : data){
			 if (objPro.getNombes().contains(nombs) &&
				 objPro.getApePaterno().contains(apepat) &&
				 objPro.getApeMaterno().contains(apemat) &&
				 objPro.getCorreo().contains(mail) &&
				 objPro.getNroDNI().contains(dni) &&
				 ( objPro.getTelefono().contains(tel_cel) || objPro.getCelular().contains(tel_cel)) &&
				 objPro.getFecProspecto().contains(fecha)){
				 filtro.add(objPro);
			 }
		 }
		//return null;
		 return filtro;
	}

	
	
}

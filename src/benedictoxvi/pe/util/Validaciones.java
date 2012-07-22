package benedictoxvi.pe.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public boolean isSet(String cad){
		boolean ret = true ;
		if  (cad.trim().isEmpty() || cad == null)
			ret = false;
		else
			ret = true ;
		
		return ret;
	}
	
	public boolean isDigits(String digs){
		//return true;
		digs = digs.trim();
		for(char a : digs.toCharArray()){
			if (!Character.isDigit(a))
			return false;
		}
		return true;
	}
	
	public boolean isDNI(String dni){
		if(!isDigits(dni)) 
			return false;
		if (dni.trim().length()==8){
			return true;
		}
		else {
			return false;
		}
	}
	
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
           // System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isDate(String date) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(date);
            fecha.after(fecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    

    
    public Date stringToDate(String s_fecha){
    	Date  fecha = null;
    	try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formatoFecha.parse(s_fecha);
        } catch (Exception e) {
            fecha = null ;
        }
        return fecha;
    }
    
     public static void main(String[] args) {
    	 Validaciones objVal = new Validaciones();
    	 String var = ("23427343");
    	 for(char a : var.toCharArray()){
    		 System.out.println(Character.isDigit(a));
    	 }
    	 System.out.println("\n"+objVal.isDigits(var));
	}
	
}

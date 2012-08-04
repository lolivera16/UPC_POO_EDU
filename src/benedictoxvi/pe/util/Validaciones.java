package benedictoxvi.pe.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.awt.AWTCharset.Decoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Validaciones {

	public void printMsg(String msg,String prev){
		StackTraceElement[] trace = (StackTraceElement[])Thread.currentThread().getStackTrace();
		String method1 = trace[2].getMethodName();
		String method2 = trace[3].getMethodName();
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(prev+" "+method2 + "["+ method1+"]" +" : " + msg);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public void printMsg(String msg){
		printMsg(msg, "");
	}
		
	public boolean isSet(String cad){
		boolean ret = true ;
		if ( cad == null ) {
			return false;
		}
		if  (cad.trim().isEmpty())
			ret = false;
		else
			ret = true ;
		
		return ret;
	}
	
	public boolean isValidKey(String key){
		if ( !isSet(key))
		return false;
		if (key.trim().length()<8){
			return false;
		}
		return true;
	}
	
	public boolean isSet(String[] a_objs){
		boolean ret = true ;
		for(String obj:a_objs){
			if (!isSet(obj)){
				ret = false;
				break;
			}
		}
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
        	String[] parts ;
        	parts= date.split("/");
        	int year = Integer.parseInt(parts[2]);
        	int mes = Integer.parseInt(parts[1]);
        	int dia = Integer.parseInt(parts[0]);
        	if (!(dia >=1 && dia<= 31))
        		return false;
        	if (!(mes>=1 && mes <= 12 ))
        		return false;
        	if (!(year>=1000 && year<=9999))
        		return false;
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(date);
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
//    	 Validaciones objVal = new Validaciones();
//    	 String var = ("23427343");
//    	 for(char a : var.toCharArray()){
//    		 System.out.println(Character.isDigit(a));
//    	 }
//    	 System.out.println("\n"+objVal.isDigits(var));

	}
	
     public int dateToInt(String fecha){
    	 String[] parts ;
    	 int val = 0;
    	 if (isDate(fecha)){
    	 	 parts = fecha.split("/");
    	 	 if (parts.length==3){
    	 		 val = Integer.parseInt(parts[2]+parts[1]+parts[0]);
    	 	 }
    	 	 else {
    	 		 new FormatException("El formato de Fecha '" + fecha + "' es incorrecto se esperaba dd/mm/aaaa").printStackTrace();
    	 	 }
    	 }
    	 else{
    		 new FormatException("El formato de Fecha '" + fecha + "' es incorrecto se esperaba dd/mm/aaaa").printStackTrace();
    	 }
    	 return val;
     }
     
     
     //Max romero
     public boolean isRUC(String pRuc){
 		if(!isDigits(pRuc)) 
 			return false;
 		if (pRuc.trim().length() == 11)
 		{
 			return true;
 		} 
		else 
 		{
 			return false;
 		}
 	}
     
}

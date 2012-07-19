package benedictoxvi.pe.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isDate(String date) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public ArrayList<String[]> getDataTxt(String path){
    	ArrayList<String[]> c_file = new ArrayList<String[]>();
    	 try{
    		  FileInputStream fstream = new FileInputStream("textfile.txt");
    		  DataInputStream in = new DataInputStream(fstream);
    		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		  String strLine;
    		  while ((strLine = br.readLine()) != null)   {    			  
    			  c_file.add(strLine.split("\t"));
    		  }
    		  in.close();
    		    }catch (Exception e){//Catch exception if any
    		  System.err.println("Error: " + e.getMessage());
    		  }
    	return c_file;
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
    
	
}

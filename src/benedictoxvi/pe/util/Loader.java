package benedictoxvi.pe.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {

    public ArrayList<String[]> getDataTxt(String path){
    	ArrayList<String[]> c_file = new ArrayList<String[]>();
    	 try{
    		  FileInputStream fstream = new FileInputStream(path);
    		  DataInputStream in = new DataInputStream(fstream);
    		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		  String strLine;
    		  while ((strLine = br.readLine()) != null)   {    			  
    			  c_file.add(strLine.split("\t"));
    		  }
    		  in.close();
    		    }catch (Exception e){//Catch exception if any
    		  //System.err.println("Error: " + e.getMessage());
    		    	e.printStackTrace();
    		  }
    	return c_file;
    }
	
}

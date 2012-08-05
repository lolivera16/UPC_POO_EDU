package benedictoxvi.pe.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Security {
    BASE64Encoder enc=new BASE64Encoder();
    BASE64Decoder dec=new BASE64Decoder();
	 public final String DEFAULT_ENCODING="UTF-8"; 

    public String base64encode(String text){
       try {
          String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
          return rez;         
       }
       catch (Exception e ) {
          return null;
       }
    }//base64encode

    public String base64decode(String text){

          try {
             return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
          }
          catch (Exception e ) {
            return null;
          }

       }//base64decode
}

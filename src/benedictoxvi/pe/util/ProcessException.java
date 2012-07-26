package benedictoxvi.pe.util;

public class ProcessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7086572473114990528L;

	public ProcessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		//super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProcessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProcessException(String message) {
		//System.out.println("-----");
		super(message);
		
		// TODO Auto-generated constructor stub
	}

	public ProcessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("");
		super.printStackTrace();
		System.out.println("");
	}
	
	
	

}

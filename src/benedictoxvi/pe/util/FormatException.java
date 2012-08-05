package benedictoxvi.pe.util;

public class FormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7086572473114990528L;

	public FormatException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormatException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		//super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FormatException(String message, Throwable cause) {
		super(message, cause);
		System.out.println("-----");
		// TODO Auto-generated constructor stub
	}

	public FormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	 
	@Override
	public void printStackTrace() {
		String method1 = ((StackTraceElement)this.getStackTrace()[0]).getMethodName();
		String method2 = ((StackTraceElement)this.getStackTrace()[1]).getMethodName();
		//super.printStackTrace();
		System.err.println("\n"+method2 + "["+ method1+"]" +" : " + this.getMessage());
	}

	
	
	

}

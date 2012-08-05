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
		String method1 = ((StackTraceElement)this.getStackTrace()[0]).getMethodName();
		String method2 = ((StackTraceElement)this.getStackTrace()[1]).getMethodName();
		//super.printStackTrace();
		System.err.println("\n"+method2 + "["+ method1+"]" +" : " + this.getMessage());
	}
	
	public static void main(String[] args) {
		//String h = "\x1B[1mBOLD\x1B[0m\t\x1B[31mRED\x1B[0m";
		System.out.println();
	}
	
	

}

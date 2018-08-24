package Myexception;

public class myexception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public myexception() {
		
	}
	
	public myexception(String msg) {
		super(msg);
	}
}

package project.app.util;


/**
 * 
 *	Returns an object and a pass/fail boolean.
 */
public class JSONResponse {


	
	private boolean pass;
	private Object item;

	public JSONResponse(Boolean pass, Object item) {
		this.setIsPassed(pass);
		this.setItem(item);
	}
	
	
	public boolean getIsPassed() {
		return pass;
	}

	public void setIsPassed(boolean pass) {
		this.pass = pass;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}



}

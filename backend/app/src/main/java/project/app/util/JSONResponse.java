package project.app.util;


/**
 * 
 *	Returns an object and a pass/fail boolean.
 */
public class JSONResponse {


	
	private boolean success;
	private Object item;

	public JSONResponse(Boolean success, Object item) {
		this.setSuccessStatus(success);
		this.setItem(item);
	}
	
	public boolean getSuccessStatus() {
		return success;
	}

	public void setSuccessStatus(boolean success) {
		this.success = success;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}



}

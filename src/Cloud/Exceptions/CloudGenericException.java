package Cloud.Exceptions;

@SuppressWarnings("serial")
public class CloudGenericException extends Exception {

	public CloudGenericException(String message){
		super(message);
	}
	
	public CloudGenericException(){
		super();
	}
}

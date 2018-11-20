/**
 * 
 */
package robot.util;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
@SuppressWarnings("serial")
public class Plott3rException extends Exception{

	/**
	 * 
	 */
	public Plott3rException(){
		super();
	}

	/**
	 * @param message the exception message
	 */
	public Plott3rException(String message){
		super(message);
	}

	/**
	 * @param message   the exception message
	 * @param throwable a Throwable
	 */
	public Plott3rException(String message, Throwable throwable){
		super(message, throwable);
	}

	/**
	 * @param message            the exception message
	 * @param cause              the cause as Throwable
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public Plott3rException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

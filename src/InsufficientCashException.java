/**
 * An exception is thrown when the cash register cannot withdraw the specified amount of money because it does not 
 * have the cash to do so.
 * @author David Harmeyer
 *
 */
public class InsufficientCashException extends Exception {
	//I am not multithreading, but Eclipse really wants this just in case, and I guess it doesn't really hurt anyone
	private static final long serialVersionUID = 1L;
	
}

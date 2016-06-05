/*
 *This class contains the user defined exceptions.  
 *@author Abhishek Sirohi
 * @Student Id 727644
 */

public class UserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UserException(String a)
	{
		System.out.println("'"+a+"' is not a valid command.");
		System.out.println();
		System.out.print(">");
	}
	public UserException(){
		System.out.println("Incorrect number of arguments supplied to command.");
		System.out.println();
		System.out.print(">");
	}
}

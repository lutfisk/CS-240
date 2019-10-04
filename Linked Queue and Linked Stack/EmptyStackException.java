/**
  	Thrown error when stack is empty
 
	@author Lutfi Haji-Cheteh
 
 */

public class EmptyStackException extends RuntimeException {
	public EmptyStackException()
    {
        super("The stack is empty!");
    }
}

/**
  	Thrown error when queue is empty
 
	@author Lutfi Haji-Cheteh
 
 */
public class EmptyQueueException extends RuntimeException{
	public EmptyQueueException(){
		super("The queue is empty!");
	}

}

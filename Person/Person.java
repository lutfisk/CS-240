/*************************************************************************
  Winter 2017 CS 240 Programming Exam : Person

 Author: Lutfi Haji-Cheteh      

 Dependencies: Stack, Queue, Dictionary

 Description:  Models a person, a list of messages that they can
               read, and a list of their friends, so that when you
               post a message, all your friends can read it too.

**************************************************************************/
import java.lang.Iterable;

public class Person{ 
	
	private String name;
	private QueueFixedArray<Person> friends;
	private StackFixedArray<String> messages;
	
    // Create a new Person with this name.
    public Person(String name){
        this.name = name;
        this.friends = new QueueFixedArray<Person>();
        this.messages = new StackFixedArray<String>();
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson){
        if (otherPerson == this){
        	throw new RuntimeException("You can't meet yoursel!");
        }
        else{
        	friends.enqueue(otherPerson);
        	otherPerson.friends.enqueue(this);
        }	
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson){
       if (otherPerson == this){
    	   throw new RuntimeException("You already know yourself!");
       }
       else{
    	   while (!friends.isEmpty()){
    		   Person f = friends.dequeue();
    		   for (int i=0; i<friends.getSize(); i++){
    			   if (f == otherPerson){
    				   return true;
    			   }
    		   }  
           }
    	   return false;
       }
    } 

    // Post a message to my list and the lists of all my friends
    public void post(String message){
        messages.push(message);
        while (!friends.isEmpty()){
        	Person f = friends.dequeue();
        	for (int i=0; i<friends.getSize(); i++){
        		f.messages.push(message);
        	}
        }
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
       System.out.println("==Wall of " + name + "==");

       while (!friends.isEmpty()){
    	   Person f = friends.dequeue();
    	   for (int i=0; i<friends.getSize(); i++){
    		   System.out.println(f);
    	   }
       }
    } 
}
    
public interface Stack<E>
{
	void push(E item); //adds an item to the top
	
	E pop(); //removes the top item
	
	E peek(); //returns the top item
	
	boolean isEmpty(); //returns whether the stack is empty of not
}
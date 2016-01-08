public interface Queue<E>
{
	void offer(E item); //adds item to queue
	
	E poll(); //removes first item in queue
	
	E peek(); //returns first item in queue
	
	boolean isEmpty();
}
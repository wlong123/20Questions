import java.util.Iterator;
import java.util.NoSuchElementException;
/**
	Linked List Iterator class to create an iterator for Linked List
	@version 11/24/15
	@author Will Long
*/
public class LinkedListIterator<E> implements Iterator<E>
{
	/**current item in the linked list*/
	private ListNode<E> curr;
	
	/**
	constructor for linked list iterator
	@param head first list node in the linked list
	*/
	public LinkedListIterator(ListNode<E> head)
	{
		curr = head;
	}
	
	/**
	returns whether there is another item in the linked list
	@return boolean returns true if there is another item in the linked list, false if not
	*/
	public boolean hasNext()
	{
		return curr != null;
	}
	
	/**
	gets the next value in the iteration of the linked list
	@return the next value in the iteration of the linked list
	*/
	public E next()
	{
		if(hasNext() == false)
			throw new NoSuchElementException("no more items left in the linked list");
		E output = curr.getItem();
		curr = curr.getNext();
		return output;
	}
}
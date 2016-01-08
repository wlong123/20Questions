/**
	List Node class that is used to create a linked list
	@version 11/24/15
	@author Will Long
*/
public class ListNode<E>
{
	/**item stored in the list node*/
	private E item;
	
	/**item that this list node points to*/
	private ListNode<E> next;
		
	/**
	constructor that only takes in an object
	@param i object that is assigned to the class field item
	*/
	public ListNode(E i)
	{
		item = i;
		next = null;
	}
	
	/**
	constructor that takes in an object and another list node
	@param i object that is assigned to the class field item
	@param n list node that is set to the pointer for this list node
	*/
	public ListNode(E i, ListNode n)
	{
		item = i;
		next = n;
	}
	
	/**
	accessor for the class field item
	@return E returns item
	*/
	public E getItem()
	{
		return item;
	}
	
	/**
	accessor for the class field next
	@return ListNode<E> returns the list node that this list node points to
	*/
	public ListNode<E> getNext()
	{
		return next;
	}
	
	/**
	modifier for the class field item
	@param i new value for item
	*/
	public void setItem(E i)
	{
		item = i;
	}
	
	/**
	modifier for the class field next
	@param n new list node for next
	*/
	public void setNext(ListNode n)
	{
		next = n;
	}
	
	/**
	returns a string representation of the list node
	@return String string representation of the list node
	*/
	public String toString()
	{
		String s = "";
		s += item;
		return s;
	}
}
/**
	Linked List Class
	@version 11/24/15
	@author Will Long
*/
import java.util.Iterator; 
import java.util.NoSuchElementException;
public class LinkedList<E> implements Iterable<E>, Stack<E>, Queue<E>
{
	/**head pointer*/
	private ListNode<E> head;
	
	/**tail pointer*/
	private ListNode<E> tail;
	
	/**size of linked list*/
	private int size;
	
	/**
	default constructor
	*/
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	constructor that takes in a listNode
	@param h listNode which is to be initial object in linked list
	*/
	public LinkedList(ListNode<E> h)
	{
		head = h;
		tail = h;
		size = 1;
	}
	
	/**
	copy constructor
	@param another linked list which is to be copied
	*/
	public LinkedList(LinkedList<E> other)
	{
		this(); //calls default constructor in case other is empty
		if(other.isEmpty() == false)
		{
			for(int i = 0; i < other.size(); i++)
			{
				add(other.get(i));
			}
			size = other.size();
		}
	}
	
	/**
	accessor for the field size
	@return int size of the linked list
	*/
	public int size()
	{
		return size;
	}
	
	/**
	adds an item the end of the linked list
	@param E item that is going to be added to the end of the linked list
	*/
	public void add(E item)
	{
		addLast(item);
	}
	
	/**
	adds an item to the top of a stack
	@param item item that is going to be added to the stack
	*/
	public void push(E item)
	{
		addFirst(item);
	}
	
	/**
	adds an item to a queue
	@param item item that is going to be added to the queue
	*/
	public void offer(E item)
	{
		addLast(item);
	}
	
	/**
	removes an inputted item from the linked list
	@param item item that is going to be removed
	@return boolean returns true if item was removed successfully, false if not
	*/
	@SuppressWarnings("unchecked")
	public boolean remove(E item)
	{
		//called indexOf so I could then call the other remove method
		int i = indexOf(item);
		if(i >= 0)
		{
			remove(i);
			return true;
		}
		return false;
	}
	
	/**
	removes an item at an inputted index
	@param index index that is going to be removed
	@return E item that was removed
	*/
	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		if((index >= size) || (index < 0))
			throw new IndexOutOfBoundsException("size of linked list is: " + size + ", tried to remove an item at index: " + index); 
		//checks if index was first or last spot in linked list to see if removeFirst or removeLast could be called
		if(index == 0)
			return removeFirst();
		if(index == size - 1)
			return removeLast();
		int count = 0;
		//loop that finds the spot before index and sets the pointer of that listNode to the listNode after the one at index 
		for(ListNode<E> curr = head; curr.getNext() != null; curr = curr.getNext())
		{
			if(count == index - 1)
			{
				ListNode<E> temp = curr.getNext();
				curr.setNext(curr.getNext().getNext());
				size--;
				return temp.getItem();
			}
			count++;
		}
		throw new Error("fatal error"); //should never get to this statement
	}
	
	/**
	removes the first item in the linked list
	@return E item the was removed
	*/
	public E removeFirst()
	{
		if(isEmpty())
			throw new NoSuchElementException("cannot remove an item from an empty linked list");
		ListNode<E> temp = head;
		head = head.getNext();
		size--;
		return temp.getItem();
	}
	
	/**
	removes the last item in the linked list
	@return E item that was removed
	*/
	public E removeLast()
	{
		if(isEmpty())
			throw new NoSuchElementException("cannot remove an item from an empty linked list");
		//looks for the spot before tail and sets it to tail and sets its pointer to null 
		ListNode<E> temp = tail;		
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(curr.getNext().getItem().equals(tail.getItem()))
			{
				curr.setNext(null);
				tail = curr;
				size--;
			}
		}
		return temp.getItem();
	}
	
	/**
	adds an inputted item to the first spot in the linked list
	@param item item that is going to be added to the linked list
	*/
	public void addFirst(E item)
	{
		ListNode<E> toAdd = new ListNode<E>(item, head);
		head = toAdd;
		if(tail == null)
			tail = toAdd;
		size++;
	}
	
	/**
	adds an inputted item to the end of the linked list
	@param item item that is going to be added to the linked list
	*/
	public void addLast(E item)
	{
		ListNode<E> toAdd = new ListNode<E>(item);
		if(head == null)
			head = tail = toAdd;
		else
		{
			tail.setNext(toAdd);
			tail = toAdd;
		}
		size++;
	}
	
	/**
	checks if an inputted object is in the linked list
	@param o item that is going to be checked whether it is in the linked list or not
	@return boolean returns true if the item is in the linked list, false if not
	*/
	public boolean contains(E o)
	{
		//since my indexOf returns -1 if the object isn't in the linked list, I can call it for contains
		if(indexOf(o) >= 0)
			return true;
		return false;
	}
	
	/**
	clears the linked list
	*/
	public void clear()
	{
		head = tail = null;
		size = 0;
	}
	
	/**
	gets the item at an inputted index of the linked list
	@param i index of the item that is going to be returned
	@return E item at the inputted index
	*/
	public E get(int i)
	{
	if((i >= size) || (i < 0))
		throw new IndexOutOfBoundsException("size of linked list is: " + size + ", tried to get an item at index: " + i);
		int count = 0;
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(count == i)
				return curr.getItem();
			count++;
		}
		throw new Error("fatal error"); //should never get to this statement
	}
	
	/**
	set the item at an inputted index to an inputted item
	@param index index where new item is to be placed
	@param o item that is going to be placed into the Linked List
	@return E item that was removed from the linked list
	*/
	public E set(int index, E o)
	{
		if((index >= size) || (index < 0))
			throw new IndexOutOfBoundsException("size of linked list is: " + size + ", tried to set an item to index: " + index);
		int count = 0;
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(count == index)
			{
				E temp = curr.getItem();
				curr.setItem(o);
				return temp;
			}
			count++;
		}
		throw new Error("fatal error"); //should never get to this statement
	}
	
	/**
	returns the index of an inputted object
	@param o object whose index is to be returned
	@return int index of the inputted item, returns -1 if the object isn't in the linked list
	*/
	public int indexOf(E o)
	{
		int count = 0;
		if(o == null)
		{
			for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
			{
				if(curr.getItem() == null)
					return count;
				count++;
			}
		}
		else
		{
			for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
			{
				if(curr.getItem().equals(o))
					return count;
				count++;
			}
		}
		return -1;
	}
	
	/**
	adds an inputted item to an inputted index in the linked list
	@param index spot at which the item it going to be added
	@param item item that is going to be added to the linked list
	*/
	public void add(int index, E item)
	{
		if((index > size) || (index < 0))
			throw new IndexOutOfBoundsException("size of linked list is: " + size + ", tried to add an item at index: " + index);
		//checks if the index is the first or last spot in the linked list
		if(index == 0)
			addFirst(item);
		else if(index == size)
		{
			addLast(item);
		}
		else
		{
			//finds the spot before index and sets that listNodes pointer to the inputted item, the inputted item pointer is set to the next listNode
			int count = 0;
			ListNode<E> toAdd = new ListNode<E>(item);
			for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
			{
				if(count == index - 1)
				{
					ListNode<E> temp = curr.getNext();
					curr.setNext(toAdd);
					toAdd.setNext(temp);
					count += size;
				}
				count++;
			}
			size++;
		}
	}
	
	/**
	removes the first item in a queue
	@return E object that was removed from the queue
	*/
	public E poll()
	{
		return removeFirst();
	}
	
	/**
	removes the top item in a stack
	@return E object that was removed from the stack
	*/
	public E pop()
	{
		return removeFirst();
	}
	
	/**
	returns the head item
	@return E the head item
	*/
	public E peek()
	{
		if(head == null)
			return null;
		return head.getItem();	
	}
	
	/**
	returns whether the linked list is empty or not
	@return boolean return true if the linked list is empty and false if not
	*/
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		return false;
	}
	
	/**
	returns string representation of the linked list
	@return String string representation of the linked list
	*/
	public String toString()
	{
		String s = "";
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			s += curr.toString() + ", ";
		}
		return s;
	}
	
	/**
	iterator for linked list
	@return iterator for linked list
	*/
	public Iterator<E> iterator()
	{
		return new LinkedListIterator<E>(head);
	}
}
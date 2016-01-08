import java.util.Iterator;
import java.util.NoSuchElementException;
/**
	in order iterator for binary tree class
	@version 12/18/15
	@author Will Long
*/
public class preorderIterator<E> implements Iterator<E>
{
	/**queue that contains the values in the iteration*/
	private Queue<E> values;
	
	/**
	constructor that takes in a binary tree
	@param head binary tree that is going to be iterated through
	*/
	public preorderIterator(BinaryTree<E> head)
	{
		values = new LinkedList<E>();
		populateQueue(head);
	}
	
	/**
	populates the queue with the values in the iteration
	@param tree tree that is going to be iterated through
	*/
	public void populateQueue(BinaryTree<E> tree)
	{
		if(tree.isLeaf())  //adds the value if it is a leaf
			values.offer(tree.value());
		else
		{
			if((tree.left() != null) && (tree.right() == null)) //only left side is null, add root then recursive call on left
			{
				values.offer(tree.value());
				populateQueue(tree.left());
			}
			else if((tree.right() != null) && (tree.left() == null)) //only right side is null
			{
				values.offer(tree.value());
				populateQueue(tree.right());
			}
			else //both sides aren't null, adds root then recursive call on left then recursive call on right
			{
				values.offer(tree.value());
				populateQueue(tree.left());
				populateQueue(tree.right());
			}
		}
	}
	
	/**
	returns whether there is another value in the iteration
	@return boolean returns whether there is another value in the iteration
	*/
	public boolean hasNext()
	{
		return values.peek() != null;
	}
	
	/**
	returns the next value in the iteration
	@return E returns the next value in the iteration
	*/
	public E next()
	{
		if(hasNext() == false)
			throw new NoSuchElementException("no more items left in the binary tree");
		return values.poll();	
	}
}
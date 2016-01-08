import java.util.Iterator;
/**
	Binary Tree Class
	@version 12/18/15
	@author Will Long
*/
public class BinaryTree<E> implements Iterable<E>
{
	/**value of root of the binary tree*/
	protected E value;
	
	/**node to the left of the root*/
	protected BinaryTree<E> left;
	
	/**node to the right of the root*/
	protected BinaryTree<E> right;
	
	/**
	constructor that takes in a value and two binary trees
	@param v item that is going to be the root of the tree
	@param l binary tree that is going to be set to left
	@param r binary tree that is going to be set to right
	*/
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
	constructor that only takes in a value
	@param v item that is going to be the root of the tree
	*/
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	/**
	default constructor 
	*/
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}
	
	/**
	accessor for the field left
	@return BinaryTree<E> tree to the left of the root
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/**
	accessor for the field right
	@return BinaryTree<E> tree to the right of the root
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
	accessor for the field value
	@return E value of the root
	*/
	public E value()
	{
		return value;
	}
	
	/**
	modifier for the field left
	@param node new value for the field left
	*/
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	
	/**
	modifier for the field right
	@param node new value for the field right
	*/
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	
	/**
	modifier for the field value
	@param val new value for the field value
	*/
	public void setValue(E val)
	{
		value = val;
	}
	
	/**
	returns whether the tree doesn't have any branches
	@return boolean returns true if the tree doesn't have any branches, false if not
	*/
	public boolean isLeaf()
	{
		if((left == null) && (right == null))
			return true;
		return false;
	}
	
	/**
	returns the size of the binary tree
	@return int the size of the tree
	*/
	public int size()
	{
		if(isLeaf())  //size of a leaf is one
			return 1;
		if((left != null) && (right != null))  //has a left and a right branch
			return 1 + left().size() + right.size();
		if(right != null)
			return 1 + right.size();
		if(left != null)
			return 1 + left.size();
		return 0;
	}
	
	/**
	returns a preorder iterator for the binary tree
	@return Iterator<E> preorder iterator for binary tree
	*/
	public Iterator<E> preorderIterator()
	{
		return new preorderIterator<E>(this);
	}
	
	/**
	returns an inorder iterator for the binary tree
	@return Iterator<E> inorder iterator for binary tree
	*/
	public Iterator<E> inorderIterator()
	{
		return new inorderIterator<E>(this);	
	}
	
	/**
	returns a postorder iterator for the binary tree
	@return Iterator<E> postorder iterator for binary tree
	*/
	public Iterator<E> postorderIterator()
	{
		return new postorderIterator<E>(this);	
	}

	/**
	returns an iterator for the binary tree
	@return Iterator<E> iterator for binary tree
	*/
	public Iterator<E> iterator()
	{
		return new preorderIterator<E>(this);
	}
	
	/**
	returns string representation of the binary tree
	@return String string representation of the binary tree
	*/
	public String toString()
	{
		String s = "";
		if(value == null)
			return "";
		if(isLeaf())
			s += value.toString();
		else if((left != null) && (right != null)) //has a left and a right branch
				s += value.toString() + "(" + left.toString() + "," + right.toString() + ")";
		else if(left != null)
				s += value.toString() + "(" + left.toString() + ")";
		else if(right != null)
				s += value.toString() + "(" + right.toString() + ")";
		return s;
	}

	/**
	returns the height of the binary tree
	@return int size of the tree
	*/
	public int height()
	{
		if(isLeaf())
			return 0;
		if((left != null) && (right != null))
			return 1 + left().height() + right.height();
		if(right != null)
			return 1 + right.height();
		if(left != null)
			return 1 + left.height();
		return 0;
	}
	
	/**
	returns whether the tree is full or not
	@return boolean returns true if the tree is full, false if not
	*/
	public boolean isFull()
	{
		if(isLeaf())
			return true;
		if((left == null) || (right == null))
			return false;
		return (left.isFull()) && (right().isFull()) && (right.height() == left.height());
	}
	
	/**
	returns whether the tree is complete or not
	@return boolean returns true if the tree is complete, false if not
	*/
	public boolean isComplete()
	{
		if(isLeaf())
			return true;
		if(left == null)
			return false;
		if((right == null) && (left.isLeaf()))
			return true;
		if((left != null) && (right != null) && (left.height() - right.height() == 1))
			return (left.isComplete()) && (right.isFull());
		if((left != null) && (right != null) && (left.height() == right.height()))
			return (left.isFull()) && (right.isComplete());
		return false;
	}
	
	
	/**
	returns whether the tree is balanced or not
	@return boolean returns true if the tree is balanced, false if not
	*/
	public boolean isBalanced()
	{
		if(isLeaf()) 
			return true;
		if((left != null) && (right == null) && (height() <= 1))
			return true;
		if((right != null) && (left == null) && (height() <= 1))
			return true;
		if((left != null) && (right != null) && (Math.abs(right.height() - left.height()) <= 1)) //difference between heights is less than 2
			return (left.isBalanced()) && (right.isBalanced());
		return false;
	}
	
}
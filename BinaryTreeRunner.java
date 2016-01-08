public class BinaryTreeRunner
{
	public static void main(String [] args)
	{
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(5);
		tree1.setLeft(new BinaryTree<Integer>(4));
		tree1.setRight(new BinaryTree<Integer>(3));
		tree1.left().setLeft(new BinaryTree<Integer>(2));
		tree1.left().setRight(new BinaryTree<Integer>(1));
		/**
			5
		   / \
		  4   3
		 / \  / \
		2  1  7  6 
	   /
	  0*/ 
	  
		System.out.println(tree1.size());
		System.out.println(tree1.height());
		System.out.println(tree1.isFull());
		System.out.println(tree1.left().isFull());
		System.out.println(tree1.left().right().isFull());
		System.out.println(tree1.isComplete());
		tree1.right().setRight(new BinaryTree<Integer>(6));
		System.out.println(tree1.isComplete());
		tree1.left().left().setLeft(new BinaryTree<Integer>(0));
		System.out.println(tree1.isBalanced());
		tree1.right().setLeft(new BinaryTree<Integer>(7));
		System.out.println(tree1.isBalanced());
		System.out.println(tree1.toString());
		System.out.println(tree1.isComplete());
		//System.out.println(tree1.isBalanced());
		for(int x: tree1)
		{
			System.out.println(x);
		}
	}
}
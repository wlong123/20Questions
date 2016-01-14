import java.util.Scanner;
import java.io.*;
public class TwentyQuestions
{
	/**
	main method that plays the game 20 questions
	*/
	public static void main(String [] args)
	{
		BinaryTree<String> tree = initTree(); //initialize tree
		System.out.println("Please think of an object");
		Scanner keyboard = new Scanner(System.in); 
		while(!tree.isLeaf()) //goes through the tree until it finds a leaf
		{
			System.out.println(tree.value());
			String input = keyboard.nextLine(); //takes in input from the user
			if(input.equalsIgnoreCase("yes")) //traversal goes right if the user enters yes, left if the user enters no
				tree = tree.right();
			else if(input.equalsIgnoreCase("no"))
				tree = tree.left();
			else
				System.out.println("please enter yes or no");
		}
		System.out.println("Is your object a " + tree.value() + "?"); //guesses what user is thinking of
		String input = keyboard.nextLine();
		if(input.equalsIgnoreCase("yes"))
		{
			System.out.println("Guessed Your Object");
			return;
		}
		else if(input.equalsIgnoreCase("no")) //if the guess was wrong, updates the tree, takes in the user's object and a question
		{
			tree.setLeft(new BinaryTree<String>(tree.value()));
			System.out.println("Please enter the object your were thinking of");
			input = keyboard.nextLine();
			tree.setRight(new BinaryTree<String>(input));
			System.out.println("Please enter a question that would distinguish your object from a " + tree.value());
			input = keyboard.nextLine();
			tree.setValue(input);
		}
	}
	
	/**
	initializes tree with base question of "is it alive" and answer of a chair for not alive and a dog for alive
	@return BinaryTree<String> binary tree containing base question and an object for a yes or no response
	*/
	public static BinaryTree<String> initTree()
	{
		BinaryTree<String> tree = new BinaryTree<String>("Is it alive?");
		tree.setLeft(new BinaryTree<String>("chair"));
		tree.setRight(new BinaryTree<String>("dog"));
		return tree;
	}
	
}
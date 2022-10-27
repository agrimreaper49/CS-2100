package tester;

import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:
		 * 	BST Pre: 5 4 3 2 1 9 8 7 6 
		 *	BST In: 1 2 3 4 5 6 7 8 9 
		 *	BST Post: 1 2 3 4 6 7 8 9 5 
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */

		//You can comment this line back in next week
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
//		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		int[] toInsert = {9, 8, 7, 6, 1, 2, 3, 4, 5};
		
		for(int i : toInsert) {
			avl.insert(i);
//			bst.insert(i);
		}
		
		/* Print out pre, in, and post-order */
//		System.out.println("BST Pre: " + bst.getPreOrder());
//		System.out.println("BST In: " + bst.getInOrder());
//		System.out.println("BST Post: " + bst.getPostOrder());
//		System.out.println(bst.find(2));
		
		// You can comment these lines in next week as well
		 avl.printTree();
		 System.out.print("AVL Pre: " + avl.getPreOrder());
		 System.out.print("AVL In: " + avl.getInOrder());
		 System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}

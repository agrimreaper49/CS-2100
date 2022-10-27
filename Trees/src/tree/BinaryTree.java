package tree;

// Agrim Sharma
// Computing ID: hws7ug
// Assignment: 7a BST
public class BinaryTree<T> {

	public TreeNode<T> root = null;
	
	/* Tree Traversal methods */
	
	//HINT for three traversal methods: you can call toString() on the node's 
	//     data when you are executing the "root" command on a given node 
	//     (e.g. curNode.data.toString() + " ";) // Note the space added at the end
	
	public String getInOrder() {
		return getInOrder(root); // call getInOrder starting at the root!
	}
	private String getInOrder(TreeNode<T> curNode) {
		String str = "";
		if (curNode.left != null) {
			str += getInOrder(curNode.left);
		}
		str += curNode.data.toString() + " ";
		if (curNode.right != null) {
			str += getInOrder(curNode.right);
		}
		return str;
	}
	
	
	public String getPreOrder() {
		return getPreOrder(root); // call getPreOrder starting at the root! 
	}
	private String getPreOrder(TreeNode<T> curNode) {
		String str = "";
		str += curNode.data.toString() + " ";
		if (curNode.left != null) {
			str += getPreOrder(curNode.left);
		}
		if (curNode.right != null) {
			str += getPreOrder(curNode.right);
		}
		return str;
	}
	
	
	public String getPostOrder() {
		return getPostOrder(root);  // call getPostOrder starting at the root! 
	}
	private String getPostOrder(TreeNode<T> curNode) {
		String str = "";
		if (curNode.left != null) {
			str += getPostOrder(curNode.left);
		}
		if (curNode.right != null) {
			str += getPostOrder(curNode.right);
		}
		str += curNode.data.toString() + " ";
		return str;
	}


	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
	

}


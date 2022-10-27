package tree;

/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */
 
 // Don't worry about this class for the first assignment in the module.
 // You WILL use this class in the second assignment on AVL trees.

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) 
	{
		curNode = super.insert(data, curNode);

		curNode = balance(curNode);
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		printTree();
		
		return curNode;
	}	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	public TreeNode<T> balance(TreeNode<T> curNode) {
		int balanceFactor = balanceFactor(curNode);
		
		//Left Heavy
		if (balanceFactor == -2) {
			//Scenario where there is 2 lefts on the root
			if (balanceFactor(curNode.left) == -1) {
				curNode = rotateRight(curNode);
			} else {
				//Scenario where there is 1 left on the root, and a right on the left
				curNode.left = rotateLeft(curNode.left);
				curNode = rotateRight(curNode);
			}
		} 
		
		//Right heavy
		if (balanceFactor == 2) {
			//Scenario where there is 2 rights on the root
			if (balanceFactor(curNode.right) == 1) {
				curNode = rotateLeft(curNode);
			} else {
				//Scenario where there is right on the root, and a left on the right
				curNode.right = rotateRight(curNode.right);
				curNode = rotateLeft(curNode);
			}
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		TreeNode<T> lNew = curNode.left;
		TreeNode<T> LL = curNode.left.right;
		lNew.right = curNode;
		curNode.left = LL;
		curNode.height = 1 + Math.max(height(curNode.left), height(curNode.right));
		lNew.height = 1 + Math.max(height(lNew.left), height(lNew.right));
		return lNew;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> rNew = curNode.right;
		TreeNode<T> RL = curNode.right.left;
		rNew.left = curNode;
		curNode.right = RL;
		curNode.height = 1 + Math.max(height(curNode.left), height(curNode.right));
		rNew.height = 1 + Math.max(height(rNew.left), height(rNew.right));
		return rNew;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		return height(node.right) - height(node.left);
	}
	
	public String toString() {
		return treeString(this.root).trim().replaceAll("\\s+\\)", ")");
	}

	private String treeString(TreeNode<T> curNode) {
		if (curNode == null) {
			return "null ";
		}
		if (curNode.left == null && curNode.right == null) {
			return curNode.data + " ";
		}
		String res = "(" + curNode.data + " " + treeString(curNode.left) +
					treeString(curNode.right) + ") ";
		return res;
	}
	
	public void copyOf(BinaryTree<T> source) {
		this.root = copyRecursive(source.root);
	}

	public TreeNode<T> copyRecursive(TreeNode<T> sourceNode) {
		if (sourceNode == null)
			return null;	
		TreeNode<T> copyNode = new TreeNode<T>(sourceNode.data);
		copyNode.left = copyRecursive(sourceNode.left);
		copyNode.right = copyRecursive(sourceNode.right);
		return copyNode;
	}
	
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);
		
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		
		return curNode;
	}
	
	
}

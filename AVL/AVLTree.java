
package tree;


 
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) { // Insert a node into tree while maintaining balance
		// Validator
		if (curNode == null) {
			return new TreeNode<>(data);
		}

		if (data.compareTo(curNode.data) < 0) { // If less, go left
			curNode.left = insert(data, curNode.left);
		} else if (data.compareTo(curNode.data) > 0) {
			curNode.right = insert(data, curNode.right); // If greater, go right
		}
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1; // Change height

		return balance(curNode);
	}

	
	@Override
	public void remove(T data) { // Remove node while keeping tree balanced
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

	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) { // Balance the tree after insertions or deletions
		int balanceFactor = balanceFactor(curNode);
		if (balanceFactor > 1) {
			// Left side heavy
			if (balanceFactor(curNode.left) < 0) {
				// Left Right case
				curNode.left = rotateLeft(curNode.left);
			}
			// Left Left case
			return rotateRight(curNode);
		} else if (balanceFactor < -1) {
			// Right side heavy
			if (balanceFactor(curNode.right) > 0) {
				// Right to Left case
				curNode.right = rotateRight(curNode.right);
			}
			// Right Right case
			return rotateLeft(curNode);
		}

		return curNode; // Node balanced
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) { // Perfroms a right rotation on the given node
		TreeNode<T> newRoot = curNode.left; // Create new root
		curNode.left = newRoot.right; // Update left child of current node to be right child of new root
		newRoot.right = curNode; // Make current node right child of new root
		
		// Update height
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
		
		return newRoot;		
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){ // Perfroms a left rotation on the given node
		TreeNode<T> newRoot = curNode.right; // Create new root to become new root of subtree
		curNode.right = newRoot.left; // Update right child of current node to be left child of new root
		newRoot.left = curNode; // Make current node the left child of new root
		
		// Update height
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
		
		return newRoot;		
	}
	
	private int balanceFactor(TreeNode<T> node) {
		return get_height(node.left) - get_height(node.right);
	}

	private int get_height(TreeNode<T> node) {
		if (node == null) return -1;
		return node.height;
	}
	
	
}

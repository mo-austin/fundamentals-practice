
@SuppressWarnings("unchecked")



public class BinaryTree<T> {

    protected TreeNode<T> root = null;

    /* Tree Traversal methods */


    public String getInOrder() {
        return getInOrder(root); // call getInOrder starting at the root!
    }
    private String getInOrder(TreeNode<T> curNode) {
        //TODO: return the in order traversal of this tree, space separated
        String result = "";
        if (curNode != null) {
            result += getInOrder(curNode.left); // Traverse left subtree
            result += curNode.data.toString() + " "; // current node
            result += getInOrder(curNode.right); // Traverse right subtree
        }
        return result;
    }


    public String getPreOrder() {
        return getPreOrder(root); // call getPreOrder starting at the root!
    }
    private String getPreOrder(TreeNode<T> curNode) {
        //TODO: return the pre order traversal of this tree, space separated
        String result = "";
        if (curNode != null) {
            result += curNode.data.toString() + " "; // current node
            result += getPreOrder(curNode.left); // Traverse left subtree
            result += getPreOrder(curNode.right); // Traverse right subtree            
        }
        return result;
    }


    public String getPostOrder() {
        return getPostOrder(root);  // call getPostOrder starting at the root!
    }
    private String getPostOrder(TreeNode<T> curNode) {
        //TODO: return the post order traversal of this tree, space separated
        String result = "";
        if (curNode != null) {
            result += getPostOrder(curNode.left); // Traverse left subtree
            result += getPostOrder(curNode.right); // Traverse right subtree
            result += curNode.data.toString() + " "; // current node
        }
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) { // compare memory address
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false; // see if null or different class
        }

        BinaryTree<?> otherTree = (BinaryTree<?>) o; // cast o to BinaryTree with unknown type
        return equals(root, otherTree.root); // recursion to compare
    }

    private boolean equals(TreeNode<T> node1, TreeNode<?> node2) {
        if (node1 == null && node2 == null) { // if both null, its equal
            return true;
        }
        if (node1 != null && node2 != null) { // Compare data, check left and right subtrees with recursion
            return node1.data.equals(node2.data) && equals(node1.left, node2.left) && equals(node1.right, node2.right);
        }
        return false; // there is an inequality
    }



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

    public int height() {
        return height(root);
    }

    /* Computes the height of the tree on the fly */
    protected int height(TreeNode<T> node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}


@SuppressWarnings("unchecked")



public class TreeNode<T>{
    // Every TreeNode has a left and right reference (pointer), and a data item (currently null)
    protected TreeNode<T> left = null;
    protected TreeNode<T> right = null;
    protected int height = 0;
    protected T data = null;

    public TreeNode(T data) { // Constructor
        this.data = data;
    }

    public TreeNode(T data, int height) { // Another Constructor
        this(data);
        this.height = height;
    }

}

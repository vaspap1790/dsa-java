package searching;

/**
 * Used to traverse a tree
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Problems: Does this path exist? (maze)
 */
public class DepthFirstSearch {

    /**
     * Inorder Traversal
     * Left Child - Parent Node - Right Child
     * Often used to recreate the tree from an array
     */
    public void inorderDFS(TreeNode node){
        if(node == null) return;

        inorderDFS(node.left);
        System.out.println(node.val);
        inorderDFS(node.right);
    }

    /**
     * Preorder Traversal
     * Parent Node - Left Child - Right Child
     * Returns Ascending Sorted Order
     */
    public void preorderDFS(TreeNode node){
        if(node == null) return;

        System.out.println(node.val);
        inorderDFS(node.left);
        inorderDFS(node.right);
    }

    /**
     * Postorder Traversal
     * Left Child - Right Child - Parent Node
     */
    public void postorderDFS(TreeNode node){
        if(node == null) return;

        inorderDFS(node.left);
        inorderDFS(node.right);
        System.out.println(node.val);
    }

    /**
     * Reverse order Traversal
     * Right Child - Parent Node - Left Child
     * Returns Descending Sorted Order
     */
    public void reverseOrderDFS(TreeNode node){
        if(node == null) return;

        inorderDFS(node.right);
        System.out.println(node.val);
        inorderDFS(node.left);
    }
}

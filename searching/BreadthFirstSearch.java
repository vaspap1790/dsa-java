package searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Used to traverse a tree
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Problems: Shortest Path
 */
public class BreadthFirstSearch {

    public void bfs(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                if(curr != null) {
                    System.out.println(curr.val);
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
        }
    }
}

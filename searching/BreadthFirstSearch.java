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
            int currentLvlSize = queue.size();
            for (int i = 0; i < currentLvlSize; i++) {
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

    public static List<List<Integer>> bfsBottomUp(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int currentLvlSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentLvlSize; i++) {
                TreeNode curr = queue.poll();
                if(curr != null) {
                    level.add(curr.val);
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }
            }
            result.add(0, level);
        }

        return result;
    }
}

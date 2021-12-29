import java.util.PriorityQueue;
import java.util.*;

public class KthSmallestElmentInBst {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(pq, root);
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void helper(PriorityQueue<Integer> pq, TreeNode root) {
        if (root != null) {
            pq.add(root.val);
            helper(pq, root.left);
            helper(pq, root.right);
        }
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     int n = 0;
    //     Stack<TreeNode> s = new Stack<>();
    //     TreeNode curr = root;
    //     boolean toBreak = false;
    //     while (curr != null && !s.isEmpty()) {
    //         while (curr != null) {
    //             curr = curr.left;
    //         }  
    //         curr = s.pop();
    //         n++;
    //         if (n == k) {
    //             toBreak = true;
    //             break;
    //         }
    //         if (toBreak) {
    //             break;
    //         }
    //         curr = curr.right;
    //     }
    //     return curr.val;
    // }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

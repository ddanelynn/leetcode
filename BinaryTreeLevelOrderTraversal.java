import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelArr = new ArrayList<>();
        helper(root, 0, levelArr);
        return levelArr;
    }

    public static void helper(TreeNode node, int level, List<List<Integer>> levelArr) {
        if (node == null) {
            return;
        }
        while (level >= levelArr.size()) {
            List<Integer> nodeArr = new ArrayList<>();
            levelArr.add(nodeArr);
        }

        levelArr.get(level).add(node.val);
        helper(node.left, level + 1, levelArr);
        helper(node.right, level + 1, levelArr);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

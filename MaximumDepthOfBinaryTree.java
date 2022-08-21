public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return (int) Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  // public int maxDepth(TreeNode root) {
  // if (root == null) {
  // return 0;
  // }
  // return helper(root, 1);
  // }

  // public static int helper(TreeNode node, int depth) {
  // if (node.left == null && node.right == null) {
  // return depth;
  // }
  // if (node.left == null) {
  // return helper(node.right, depth + 1);
  // }
  // if (node.right == null) {
  // return helper(node.left, depth + 1);
  // }
  // return Math.max(helper(node.right, depth + 1), helper(node.left, depth + 1));
  // }

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

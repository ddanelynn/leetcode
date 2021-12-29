function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

node1 = new TreeNode(3, null, null);
node2 = new TreeNode(4, null, null);
node3 = new TreeNode(3, null, null);
node4 = new TreeNode(4, null, null);
node5 = new TreeNode(2, node2, node1);
node6 = new TreeNode(2, node3, node4);
root = new TreeNode(1, node5, node6);

var isSymmetric = function(root) {
    return helper(root, root);
};

var helper = function(l, r) {
    
    if (l === null && r === null) {
        return true
    } else if (l !== null && r !== null && l.val === r.val) {
        return helper(l.left, r.right) && helper(l.right, r.left);
    } else {
        return false;
    }
}

isSymmetric(root)
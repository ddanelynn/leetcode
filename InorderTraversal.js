function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

thirdNode = new TreeNode(3, null, null);
secondNode = new TreeNode(2, thirdNode, null);
root = new TreeNode(1, null, secondNode);

var inorderTraversal = function(root) {
    result = [];
    helper(root, result);

    console.log(result)
    return result;
};

function helper (root, result) {
    if (root !== null) {
        helper(root.left, result);
        result.push(root.val);
        helper(root.right, result);
    }
}

inorderTraversal(root);
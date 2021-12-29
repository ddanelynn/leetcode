function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

var kthSmallest = function(root, k) {
    const elementArr = [];
    traverse(root, elementArr);
    elementArr.sort((a, b) => a - b);
    return elementArr[k - 1];
};

var traverse = function(root, arr) {
    if (root !== null) {
        arr.push(root.val);
        traverse(root.left, arr);
        traverse(root.right, arr);
    }
}
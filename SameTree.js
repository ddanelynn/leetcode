function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

var isSameTree = function(p, q) {
    if (p !== null && q !== null) {
        if (p.val  === q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    } else if (p === null && q === null) {
        return true;
    } else {
        return false;
    }
};
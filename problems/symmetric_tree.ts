/*
* 101. Symmetric Tree
*/


// Definition for a binary tree node.
class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}


function isSymmetric(root: TreeNode | null): boolean {
    return isMirror(root, root);
};

function isMirror(a: TreeNode | null, b: TreeNode | null) {
    if (a == null && b == null)
        return true;
    else if (a != null && b != null
        && a.val == b.val)
        return (isMirror(a.left, b.right)
            && isMirror(a.right, b.left));
    return false;
}


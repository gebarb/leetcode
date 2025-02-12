/*
* 112 Path Sum
*/


// Definition for a binary tree root.
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

function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
    if (root == null) {
        return false
    }
    let ret = false;
    var subSum = targetSum - root.val;
    if (subSum == 0 && root.left == null && root.right == null) {
        return (ret = true);
    }
    if (root.left != null) {
        ret = ret || hasPathSum(root.left, subSum);
    }
    if (root.right != null) {
        ret = ret || hasPathSum(root.right, subSum);
    }
    return ret;
};


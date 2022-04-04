package leetcode.problems.q94;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TreeNode {
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

class Solution {

    private List<Integer> answer;

    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        inorder(root);
        return answer;
    }

    void inorder(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }

        inorder(treeNode.left);
        answer.add(treeNode.val);
        inorder(treeNode.right);
    }
}

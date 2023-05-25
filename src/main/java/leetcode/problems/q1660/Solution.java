package leetcode.problems.q1660;

import java.util.*;

class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {

        Set<Integer> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();

        visited.add(root.val);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (Objects.nonNull(currentNode.right)) {
                if (Objects.nonNull(currentNode.right.right) && visited.contains(currentNode.right.right.val)) {
                    currentNode.right = null;
                    break;
                }

                queue.add(currentNode.right);
                visited.add(currentNode.right.val);
            }

            if (Objects.nonNull(currentNode.left)) {
                if (Objects.nonNull(currentNode.left.right) && visited.contains(currentNode.left.right.val)) {
                    currentNode.left = null;
                    break;
                }

                queue.add(currentNode.left);
                visited.add(currentNode.left.val);
            }
        }

        return root;
    }
}

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

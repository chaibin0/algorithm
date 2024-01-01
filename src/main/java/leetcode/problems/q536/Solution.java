package leetcode.problems.q536;


class Solution {

    private static final char MINUS = '-';
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    private int index = 0;

    public TreeNode str2tree(String s) {

        if (s.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(0);
        return dfs(root, s);
    }

    private TreeNode dfs(TreeNode position, String s) {

        StringBuilder sb = new StringBuilder();
        TreeNode treeNode = null;

        while (index < s.length()) {
            if (s.charAt(index) == OPEN) {
                if (treeNode == null) {
                    treeNode = new TreeNode(Integer.parseInt(sb.toString()));
                }
                index++;
                dfs(treeNode, s);
                continue;
            }

            if (s.charAt(index) == CLOSE) {
                if (position.left != null) {
                    position.right = treeNode != null ? treeNode : new TreeNode(Integer.parseInt(sb.toString()));
                } else {
                    position.left = treeNode != null ? treeNode : new TreeNode(Integer.parseInt(sb.toString()));
                }
                index++;
                return treeNode;
            }
            sb.append(s.charAt(index));
            index++;
        }

        if (treeNode == null) {
            return new TreeNode(Integer.parseInt(sb.toString()));
        }

        return treeNode;
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

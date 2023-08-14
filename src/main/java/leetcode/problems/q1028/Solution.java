package leetcode.problems.q1028;


import java.util.ArrayList;
import java.util.List;

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

class Pair {
    int depth;
    int val;

    Pair(int depth, int val) {
        this.depth = depth;
        this.val = val;
    }
}

class Solution {

    private static final char HYPHEN = '-';
    private int count = 1;

    public TreeNode recoverFromPreorder(String traversal) {

        List<Pair> list = new ArrayList<>();

        int index = 0;

        StringBuilder rootValueStr = new StringBuilder();
        while (index < traversal.length()) {
            if (traversal.charAt(index) == '-') {
                break;
            }
            rootValueStr.append(traversal.charAt(index));
            index++;
        }

        TreeNode root = new TreeNode(Integer.parseInt(rootValueStr.toString()), null, null);
        list.add(new Pair(0, Integer.parseInt(rootValueStr.toString())));

        if (index == traversal.length()) {
            return root;
        }

        boolean isDepth = true;
        boolean isNumber = false;

        int depth = 0;

        StringBuilder numStr = new StringBuilder();

        for (int i = index; i < traversal.length(); i++) {

            char currentCharacter = traversal.charAt(i);

            if (currentCharacter == HYPHEN && isDepth) {
                depth++;
            }

            if (currentCharacter != HYPHEN) {
                isDepth = false;
                numStr.append(currentCharacter);
            }

            if (currentCharacter == HYPHEN && !isDepth) {
                list.add(new Pair(depth, Integer.parseInt(numStr.toString())));
                depth = 1;
                isDepth = true;
                numStr = new StringBuilder();
            }
        }

        list.add(new Pair(depth, Integer.parseInt(numStr.toString())));

        dfs(root, list, 1);
        return root;
    }

    public void dfs(TreeNode head, List<Pair> list, int currentDepth) {

        if (list.size() <= count) {
            return;
        }

        if (currentDepth == list.get(count).depth && head.left == null) {
            head.left = new TreeNode(list.get(count).val, null, null);
            count++;
            dfs(head.left, list, currentDepth + 1);
        }

        if (list.size() <= count) {
            return;
        }

        if (currentDepth == list.get(count).depth && head.right == null) {
            head.right = new TreeNode(list.get(count).val, null, null);
            count++;
            dfs(head.right, list, currentDepth + 1);
        }
    }
}

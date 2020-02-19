package problems.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> list = new ArrayList<>();

    private static final char OPEN_PARENTHESES = '(';

    private static final char CLOSE_PARENTHESES = ')';

    public List<String> generateParenthesis(int n) {

        dfs("", 0, 0, n);
        return list;
    }

    public void dfs(String current, int openCount, int closeCount, int n) {

        if (openCount == n && closeCount == n) {
            list.add(current);
        }

        if (openCount < n) {
            dfs(current + OPEN_PARENTHESES, openCount + 1, closeCount, n);
        }

        if (closeCount < n && openCount > closeCount) {
            dfs(current + CLOSE_PARENTHESES, openCount, closeCount + 1, n);
        }
    }
}

package leetcode.problems.q77;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> answer;
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.answer = new ArrayList<>();
        this.n = n;
        this.k = k;
        solve(-1, new ArrayList<>());
        return answer;
    }

    private void solve(int index, List<Integer> current) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = index + 1; i < n; i++) {
            int value = i + 1;
            current.add(value);
            solve(i, current);
            current.remove((Integer) value);
        }
    }


}
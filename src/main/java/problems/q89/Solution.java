package problems.q89;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> answer;
    private boolean[] visited;
    private List<List<Integer>> grayCodeDp;
    private boolean isCompleted;
    private int power;
    private int n;

    public List<Integer> grayCode(int n) {
        this.n = n;
        answer = new ArrayList<>();
        power = (int) Math.pow(2, n);
        visited = new boolean[power];
        grayCodeDp = new ArrayList<>();

        visited[0] = true;
        answer.add(0);
        if (n == 1) {
            answer.add(1);
            return answer;
        }

        dfs(0, 1);
        return answer;
    }

    private void dfs(int currentValue, int count) {
        if (isCompleted) {
            return;
        }

        if (count == power) {
            isCompleted = true;
            return;
        }

        for (int i = 0; i < this.n; i++) {
            int value = currentValue ^ (1 << i);
            if (currentValue != value && !visited[value]) {
                answer.add(value);
                visited[value] = true;
                dfs(value, count + 1);
                if (isCompleted) {
                    return;
                }
                visited[value] = false;
                answer.remove((Integer) value);
            }
        }
    }
}
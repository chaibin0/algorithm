package problems.q96;

public class Solution {

    private int[] cache;

    public int numTrees(int n) {
        this.cache = new int[20];
        this.cache[0] = 1;
        this.cache[1] = 1;
        this.cache[2] = 2;
        int answer = solve(n);
        return answer;
    }

    private int solve(int n) {
        if (n <= 2 || this.cache[n] != 0) {
            return this.cache[n];
        }

        int total = 0;

        for (int root = 1; root <= n; root++) {
            int left = solve(root - 1);
            int right = solve(n - root);
            total += (left * right);
        }

        this.cache[n] = total;
        return total;
    }
}

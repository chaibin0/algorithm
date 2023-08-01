package leetcode.problems.q1536;

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] g = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }

                count++;
            }

            g[i] = n - count;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            index++;

            if (g[i] <= index) {
                continue;
            }
            int j = i + 1;

            while (j < n && g[j] > index) {
                j++;
            }

            if (j == n) {
                return -1;
            }
            for (int k = j; k > i; k--) {
                int swap = g[k - 1];
                g[k - 1] = g[k];
                g[k] = swap;
                answer++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (g[i] > (i + 1)) {
                return -1;
            }
        }

        return answer;
    }
}

package leetcode.problems.q1314;

class Solution {
    private int m;
    private int n;

    public int[][] matrixBlockSum(int[][] mat, int k) {

        this.m = mat.length;
        this.n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = i - k; r <= i + k; r++) {
                    for (int c = j - k; c <= j + k; c++) {
                        if (outOfBoundary(r, c)) {
                            continue;
                        }

                        answer[i][j] += mat[r][c];
                    }
                }
            }
        }

        return answer;
    }

    public boolean outOfBoundary(int r, int c) {
        return r < 0 || c < 0 || r >= m || c >= n;
    }
}


// 1 2 3
// 4 5 6
// 7 8 9

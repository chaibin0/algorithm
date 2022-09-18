package leetcode.problems.q221;






class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int answer = matrix[0][0] == '1' ? 1 : 0;

        int[][] leftDp = new int[m][n];
        int[][] upDp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j] == '1' ? 1 : 0;

                if (j == 0) {
                    leftDp[i][j] = value;
                    continue;
                }

                leftDp[i][j] = value == 1 ? leftDp[i][j - 1] + value : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j] == '1' ? 1 : 0;

                if (i == 0) {
                    upDp[i][j] = value;
                    continue;
                }

                upDp[i][j] = value == 1 ? upDp[i - 1][j] + value : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(matrix[i][j] == '0'){
                    continue;
                }

                if (upDp[i][j] < answer && leftDp[i][j] < answer) {
                    continue;
                }
                int count = 0;
                int length = Math.min(upDp[i][j], leftDp[i][j]);
                while (count < length) {
                    if (upDp[i][j - count] < (count + 1) || leftDp[i - count][j] < (count + 1)) {
                        break;
                    }

                    count++;
                }

                answer = Math.max(count, answer);
            }
        }

        return answer * answer;
    }
}
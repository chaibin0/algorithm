package leetcode.problems.q62;

class Solution {
    public int uniquePaths(int m, int n) {
        int height = m - 1;
        int width = n - 1;
        int sum = height + width;
        long minGrid = Math.min(height, width);

        double value = 1;
        for (int i = 0; i < minGrid; i++) {
            value *= (sum - i);
            value /= (i + 1);
        }

        return (int) value;
    }
}
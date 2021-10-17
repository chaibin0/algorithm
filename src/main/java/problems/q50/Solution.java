package problems.q50;

class Solution {
    public double myPow(double x, int n) {

        if (n == 0 || x == 1.0) {
            return 1;
        }

        double value = x;
        double powValue = x;
        if (n < 0) {
            value = 1 / x;
            powValue = 1 / x;
        }
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                value *= powValue;
            }
        } else {
            for (int i = -1; i > n; i--) {
                value *= powValue;
            }
        }

        return (double) Math.round(value * 100000) / 100000;
    }
}
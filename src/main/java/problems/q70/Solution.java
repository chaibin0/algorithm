package problems.q70;

class Solution {
    public int climbStairs(int n) {
        int i = 1;
        int answer = 1;
        int size = n / 2;

        for (i = 1; i <= size; i += 1) {
            int k = n - i;
            answer += combination(k, i);
        }

        return answer;
    }

    public int combination(int k, int n) {
        long value = 1;
        int i = 1;
        n = Math.min(k - n, n);
        while (n >= i) {
            value *= (k - i + 1);
            value /= (i);
            i++;
        }
        return (int)value;
    }
}
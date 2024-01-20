package leetcode.problems.q2894;

class Solution {
    public int differenceOfSums(int n, int m) {
        int divisibleLength = n / m;
        int nSum = (n * (n + 1)) / 2;
        int divisibleSum = m * (divisibleLength * (divisibleLength + 1)) / 2;
        return nSum - 2 * divisibleSum;
    }
}
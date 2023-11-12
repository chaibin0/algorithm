package leetcode.problems.q1551;

class Solution {
    public int minOperations(int n) {
        int size = n / 2;
        int answer = size * (size + 1);
        return n % 2 == 0 ? answer - size : answer;
    }
}

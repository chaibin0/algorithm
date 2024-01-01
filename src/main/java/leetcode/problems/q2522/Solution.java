package leetcode.problems.q2522;

class Solution {
    public int minimumPartition(String s, int k) {

        int answer = 0;
        int size = s.length();
        int value = s.charAt(size - 1) - '0';
        int digitSize = 1;

        for (int i = size - 2; i >= 0; i--) {

            if (value > k) {
                return -1;
            }

            int digit = (s.charAt(i) - '0');
            long digitValue = digit * (long) Math.pow(10, digitSize);
            if ((value + digitValue) > k) {
                answer++;
                digitSize = 1;
                value = digit;
                continue;
            }
            value += (int) digitValue;
            digitSize++;
        }

        if (value <= k) {
            answer++;
        }

        return answer;
    }
}

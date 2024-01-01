package leetcode.problems.q1318;

class Solution {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        int i = 0;
        int bit = 1;
        int currentValue = 0;
        while ((currentValue = bit << i) <= c || currentValue <= b || currentValue <= a) {

            int aBit = (currentValue & a) >> i;
            int bBit = (currentValue & b) >> i;
            int cBit = (currentValue & c) >> i;
            if (cBit == 0) {
                answer += aBit;
                answer += bBit;
            }
            if (cBit == 1 && aBit == 0 && bBit == 0) {
                answer++;
            }

            i++;
        }
        return answer;
    }
}

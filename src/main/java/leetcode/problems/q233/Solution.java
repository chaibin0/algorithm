package leetcode.problems.q233;


class Solution {
    public int countDigitOne(int n) {

        if (n == 0) {
            return 0;
        }

        if (n <= 9) {
            return 1;
        }

        int answer = 0;
        int temp = n / 10;
        int digit = 1;

        while (temp != 0) {
            temp = temp / 10;
            digit = digit * 10;
        }

        int d = n / digit;

        if (d == 1) {
            return (n % digit) + countDigitOne(n % digit) + countDigitOne(digit - 1) + 1;
        }
        return answer = digit + d * countDigitOne(digit - 1) + countDigitOne(n % digit);
    }
}
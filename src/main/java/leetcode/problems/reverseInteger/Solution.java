package leetcode.problems.reverseInteger;

class Solution {

    public int reverse(int x) {

        boolean isPositive = checkPositive(x);
        String value = extractNumber(x);
        long absolutedReversedNumber = reverseNumber(value);
        if (absolutedReversedNumber > Integer.MAX_VALUE)
            return 0;

        if (!isPositive) {
            absolutedReversedNumber *= -1;
        }

        return (int) absolutedReversedNumber;
    }

    public boolean checkPositive(int x) {

        return x >= 0;
    }

    public String extractNumber(int x) {

        return String.valueOf(Math.abs((long) x));
    }

    public long reverseNumber(String x) {

        StringBuilder reversedNumber = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--) {
            reversedNumber.append(x.charAt(i));
        }
        return Long.parseLong(reversedNumber.toString());
    }
}

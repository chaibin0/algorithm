package problems.q29;

public class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }

        if (dividend == Integer.MIN_VALUE && divisor < 0) {
            dividend = dividend + 1;
        }


        boolean isMinusDividend = dividend < 0;
        boolean isMinusDivisor = divisor < 0;
        boolean isMinusResult = isMinusDividend ^ isMinusDivisor;

        long absDividend = getAbsDividend(dividend);
        long absDivisor = Math.abs((long) divisor);

        if (absDividend < absDivisor) {
            return 0;
        }

        long currentDividend = absDividend;

        boolean[] answerList = new boolean[32];
        while (true) {

            if (currentDividend < absDivisor) {
                break;
            }

            int divisorIndex = getDivisorIndex(currentDividend, absDivisor);
            currentDividend = currentDividend - (absDivisor << divisorIndex);
            answerList[divisorIndex] = true;
        }


        long answer = 0;
        for (int i = 0; i < answerList.length; i++) {
            if (answerList[i]) {
                answer += 1 << i;
            }
        }

        return isMinusResult ? (int) ((~answer) + 1) : (int) answer;
    }

    private long getAbsDividend(long dividend) {
        long value = Math.abs(dividend);
        return value;
    }

    public int getDivisorIndex(long currentDividend, long divisor) {

        int index = 0;

        while (true) {
            if (divisor << 1 < 0) {
                return index;
            }

            if (currentDividend < divisor << 1) {
                return index;
            }
            divisor = divisor << 1;
            index++;
        }
    }
}

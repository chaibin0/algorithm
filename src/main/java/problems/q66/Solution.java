package problems.q66;

class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        boolean check = isAllNine(digits);
        int[] answer = check ? new int[size + 1] : new int[size];
        int position = check ? 1 : 0;
        for (int i = 0; i < digits.length; i++) {
            answer[position + i] = digits[i];
        }

        plus(answer, answer.length - 1);
        return answer;
    }

    private void plus(int[] answer, int position) {
        int value = answer[position] + 1;
        answer[position] = value % 10;
        if (value >= 10) {
            plus(answer, position - 1);
        }
    }

    private boolean isAllNine(int[] digits) {

        for (int digit : digits) {
            if (digit != 9) {
                return false;
            }
        }

        return true;
    }
}

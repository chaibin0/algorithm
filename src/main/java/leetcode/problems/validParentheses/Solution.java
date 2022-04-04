package leetcode.problems.validParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private final static char OPEN_PARENTHESE = '(';

    private final static char CLOSE_PARENTHESE = ')';

    private final static char OPEN_SQURE_BRACKET = '[';

    private final static char CLOSE_SQURE_BRACKET = ']';

    private final static char OPEN_CUALY_BRACKET = '{';

    private final static char CLOSE_CUALY_BRACKET = '}';

    public boolean isValid(String s) {

        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOpenBracket(s.charAt(i))) {
                dq.addLast(s.charAt(i));
                continue;
            }

            if (!isSameBracket(dq.peekLast(), s.charAt(i))) {
                return false;
            }
            dq.pollLast();
        }

        return dq.isEmpty();
    }

    private boolean isOpenBracket(char digit) {

        return digit == OPEN_CUALY_BRACKET || digit == OPEN_PARENTHESE || digit == OPEN_SQURE_BRACKET;
    }

    private boolean isSameBracket(Character openDigit, char digit) {

        if (openDigit == null) {
            return false;
        }

        switch (digit) {
            case CLOSE_PARENTHESE:
                return openDigit == OPEN_PARENTHESE;

            case CLOSE_SQURE_BRACKET:
                return openDigit == OPEN_SQURE_BRACKET;

            case CLOSE_CUALY_BRACKET:
                return openDigit == OPEN_CUALY_BRACKET;

            default:
                return false;
        }
    }

}


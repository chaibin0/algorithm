package problems.q65;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final char DECIMAL_POINT = '.';
    private static final Set<Character> EXPONENT_POINT_SET = new HashSet<>(Arrays.asList('e', 'E'));
    private static final Set<Character> OPERATOR_SET = new HashSet<>(Arrays.asList('+', '-'));
    private static final Set<Character> NUMBER_SET = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public boolean isNumber(String s) {

        try {

            Pair intResult = validIntValue(s);
            Pair decimalResult = validDecimalValue(s, intResult.index);
            if (!intResult.isValid && !decimalResult.isValid) {
                return false;
            }
            Pair exponentResult = validExponentValue(s, decimalResult.index);
            return exponentResult.isValid;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Pair validExponentValue(String s, int index) {
        //없어도 정상
        if (s.length() <= index) {
            return new Pair(true, index);
        }

        if (!EXPONENT_POINT_SET.contains(s.charAt(index))) {
            throw new RuntimeException();
        }

        index++;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }

        StringBuilder number = new StringBuilder();
        while (index < s.length()) {
            if (OPERATOR_SET.contains(s.charAt(index))) {
                throw new RuntimeException();
            }

            if (s.charAt(index) == DECIMAL_POINT) {
                throw new RuntimeException();
            }

            if (EXPONENT_POINT_SET.contains(s.charAt(index))) {
                throw new RuntimeException();
            }

            if(!NUMBER_SET.contains(s.charAt(index))){
                throw new RuntimeException();
            }
            number.append(s.charAt(index));
            index++;
        }

        return new Pair(number.length() > 0, index);
    }

    public Pair validDecimalValue(String s, int index) {

        if (s.length() <= index) {
            return new Pair(false, index);
        }

        if (s.charAt(index) != DECIMAL_POINT) {
            return new Pair(false, index);
        }

        index++;
        StringBuilder number = new StringBuilder();
        while (index < s.length()) {
            if (OPERATOR_SET.contains(s.charAt(index))) {
                throw new RuntimeException();
            }

            if (s.charAt(index) == DECIMAL_POINT) {
                throw new RuntimeException();
            }

            if (EXPONENT_POINT_SET.contains(s.charAt(index))) {
                break;
            }

            if(!NUMBER_SET.contains(s.charAt(index))){
                throw new RuntimeException();
            }
            number.append(s.charAt(index));
            index++;
        }

        return new Pair(number.length() > 0, index);
    }

    public Pair validIntValue(String s) {
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
        }

        StringBuilder number = new StringBuilder();

        while (index < s.length()) {
            if (OPERATOR_SET.contains(s.charAt(index))) {
                throw new RuntimeException();
            }

            if (s.charAt(index) == DECIMAL_POINT) {
                break;
            }

            if (EXPONENT_POINT_SET.contains(s.charAt(index))) {
                break;
            }

            if(!NUMBER_SET.contains(s.charAt(index))){
                throw new RuntimeException();
            }

            number.append(s.charAt(index));
            index++;
        }


        return new Pair(number.length() > 0, index);
    }

    class Pair {
        boolean isValid;
        int index;

        public Pair(boolean isValid, int index) {
            this.isValid = isValid;
            this.index = index;
        }
    }
}

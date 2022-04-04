package leetcode.problems.q93;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class Solution {

    private List<String> answers;

    public List<String> restoreIpAddresses(String s) {
        answers = new ArrayList<>();
        solve(s, new ArrayList<>(), 0);
        return answers;
    }

    private void solve(String s, List<String> list, int index) {

        if (list.size() == 4) {
            if (s.length() == index) {
                StringJoiner sj = new StringJoiner(".");
                for (String l : list) {
                    sj.add(l);
                }
                answers.add(sj.toString());
            }

            return;
        }

        if (index + 1 > s.length()) {
            return;
        }

        for (int i = 1; i <= 3; i++) {

            if (index + i > s.length()) {
                return;
            }

            String number = s.substring(index, index + i);
            if (!isValidNumber(number)) {
                return;
            }

            list.add(number);
            solve(s, list, index + i);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValidNumber(String number) {

        int length = number.length();
        int value = Integer.parseInt(number);
        if (length == 1) {
            return value >= 0 && value <= 9;
        } else if (length == 2) {
            return value >= 10 && value <= 99;
        } else {
            return value >= 100 && value <= 255;
        }
    }
}
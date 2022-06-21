package leetcode.problems.q118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>(Arrays.asList(1)));

        if (numRows == 1) {
            return answers;
        }

        answers.add(new ArrayList<>(Arrays.asList(1, 1)));

        for (int i = 2; i < numRows; i++) {

            List<Integer> lastValues = answers.get(i - 1);
            List<Integer> answer = new ArrayList<>();
            answer.add(1);

            for (int j = 0; j < i - 2; j++) {
                answer.add(lastValues.get(j) + lastValues.get(j + 1));
            }

            answer.add(1);
            answers.add(answer);
        }

        return answers;
    }
}
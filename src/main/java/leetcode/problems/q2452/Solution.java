package leetcode.problems.q2452;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int lengthSize = queries[0].length();
        boolean[] finished = new boolean[queries.length];

        for (String word : dictionary) {
            for (int i = 0; i < queries.length; i++) {
                if (finished[i]) {
                    continue;
                }
                int difference = 0;
                for (int k = 0; k < lengthSize; k++) {
                    if (queries[i].charAt(k) != word.charAt(k)) {
                        difference++;
                    }
                }

                if (difference <= 2) {
                    finished[i] = true;
                }
            }
        }
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < finished.length; i++) {
            if (finished[i]) {
                answer.add(queries[i]);
            }
        }

        return answer;
    }
}

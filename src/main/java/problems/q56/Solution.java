package problems.q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<Integer> answerIndex = new ArrayList<>();

        sortAssent(intervals);

        int target = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (isInterval(intervals, target, i)) {
                intervals[target] = new int[]{intervals[target][0], Math.max(intervals[target][1], intervals[i][1])};
            } else {
                answerIndex.add(target);
                target = i;
            }
        }

        answerIndex.add(target);

        int[][] answers = new int[answerIndex.size()][2];
        for (int i = 0; i < answerIndex.size(); i++) {
            answers[i] = intervals[answerIndex.get(i)];
        }

        return answers;
    }

    private boolean isInterval(int[][] intervals, int target, int i) {
        return intervals[target][1] >= intervals[i][0];
    }

    public void sortAssent(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
    }
}

package leetcode.problems.q57;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<Integer> answerIndex = new ArrayList<>();

        int[][] integratedIntervals = mergeIntervals(intervals, newInterval);

        int target = 0;

        for (int i = 1; i < integratedIntervals.length; i++) {
            if (isInterval(integratedIntervals, target, i)) {
                integratedIntervals[target] = new int[]{integratedIntervals[target][0], Math.max(integratedIntervals[target][1], integratedIntervals[i][1])};
            } else {
                answerIndex.add(target);
                target = i;
            }
        }

        answerIndex.add(target);

        int[][] answers = new int[answerIndex.size()][2];
        for (int i = 0; i < answerIndex.size(); i++) {
            answers[i] = integratedIntervals[answerIndex.get(i)];
        }

        return answers;
    }

    private boolean isInterval(int[][] intervals, int target, int i) {
        return intervals[target][1] >= intervals[i][0];
    }

    private int[][] mergeIntervals(int[][] intervals, int[] newInterval) {

        int size = intervals.length + newInterval.length;
        int[][] mergedIntervals = new int[size][2];
        int mergedPosition = 0;

        int intervalPosition = 0;
        boolean isMergedNewInterval = false;

        while (intervalPosition < intervals.length) {
            if (isGreaterEqualThenIntervals(intervals[intervalPosition], newInterval)) {
                mergedIntervals[mergedPosition] = newInterval;
                isMergedNewInterval = true;
                mergedPosition++;
                break;
            }

            mergedIntervals[mergedPosition] = intervals[intervalPosition];
            intervalPosition++;
            mergedPosition++;
        }

        while (intervalPosition < intervals.length) {
            mergedIntervals[mergedPosition] = intervals[intervalPosition];
            intervalPosition++;
            mergedPosition++;
        }

        if (!isMergedNewInterval) {
            mergedIntervals[mergedPosition] = newInterval;
        }

        return mergedIntervals;
    }

    private boolean isGreaterEqualThenIntervals(int[] intervals, int[] targetIntervals) {
        if (intervals[0] == targetIntervals[0]) {
            return intervals[1] > targetIntervals[1];
        }

        return intervals[0] > targetIntervals[0];
    }
}
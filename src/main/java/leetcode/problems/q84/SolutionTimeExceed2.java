package leetcode.problems.q84;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionTimeExceed2 {

    private boolean[] allHeightVisited;

    public int largestRectangleArea(int[] heights) {

        this.allHeightVisited = new boolean[heights.length];
        int answer = 0;
        List<Pair> indexToHeightPairs = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                continue;
            }
            indexToHeightPairs.add(new Pair(i, heights[i]));
        }

        Collections.sort(indexToHeightPairs);

        for (Pair pair : indexToHeightPairs) {
            if (allHeightVisited[pair.index]) {
                continue;
            }

            int currentHeight = pair.height;
            int leftIndex = pair.index;
            int rightIndex = pair.index;

            allHeightVisited[pair.index] = true;
            answer = Math.max(answer, currentHeight);

            while (canGoAnywhere(heights, leftIndex, rightIndex)) {

                if (isGreaterThanRightValue(heights, leftIndex, rightIndex)) {
                    if (heights[leftIndex - 1] <= currentHeight) {
                        currentHeight = heights[leftIndex - 1];
                        allHeightVisited[leftIndex - 1] = true;
                    }
                    leftIndex -= 1;
                } else {
                    if (heights[rightIndex + 1] <= currentHeight) {
                        currentHeight = heights[rightIndex + 1];
                        allHeightVisited[rightIndex + 1] = true;
                    }
                    rightIndex += 1;
                }

                answer = Math.max(answer, (rightIndex - leftIndex + 1) * currentHeight);
            }
        }

        return answer;
    }

    private boolean isGreaterThanRightValue(int[] heights, int leftIndex, int rightIndex) {
        if (!canGoLeft(heights, leftIndex)) {
            return false;
        }

        if (!canGoRight(heights, rightIndex)) {
            return true;
        }

        return heights[leftIndex - 1] >= heights[rightIndex + 1];
    }

    private boolean canGoAnywhere(int[] heights, int leftIndex, int rightIndex) {

        return canGoLeft(heights, leftIndex) || canGoRight(heights, rightIndex);
    }

    private boolean canGoLeft(int[] heights, int leftIndex) {
        return (leftIndex - 1 >= 0) && (heights[leftIndex - 1] != 0);
    }

    private boolean canGoRight(int[] heights, int rightIndex) {
        return (rightIndex + 1 < heights.length) && (heights[rightIndex + 1] != 0);
    }

    class Pair implements Comparable<Pair> {

        private int index;
        private int height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {

            return Integer.compare(o.height, this.height);
        }
    }
}



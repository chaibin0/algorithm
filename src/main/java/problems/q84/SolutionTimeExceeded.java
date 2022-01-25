package problems.q84;

class SolutionTimeExceeded {
    public int largestRectangleArea(int[] heights) {

        int answer = 0;

        for (int i = 0; i < heights.length; i++) {

            int maxValue = 0;
            int maxHeight = 0;
            for (int j = i; j < heights.length; j++) {
                if (i == j) {
                    maxValue = heights[i];
                    maxHeight = heights[i];
                    continue;
                }

                if (maxHeight > heights[j]) {
                    maxHeight = heights[j];
                }

                maxValue = Math.max(maxValue, (j - i + 1) * maxHeight);
            }

            answer = Math.max(answer, maxValue);
        }

        return answer;
    }
}
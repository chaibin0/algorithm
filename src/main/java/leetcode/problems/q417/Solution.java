package leetcode.problems.q417;

import java.util.*;

class Solution {

    private List<List<Integer>> answers = new ArrayList<>();


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] up = new int[m];
        int[] down = new int[m];

        for (int i = 0; i < m; i++) {

            boolean canGoLeft = true;
            boolean canGoRight = true;

            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    continue;
                }

                if (j != 0 && canGoRight && heights[i][j - 1] <= heights[i][j]) {
                    left[i]++;
                } else {
                    canGoRight = false;
                }

                if (j != 0 && canGoLeft && heights[i][n - j] <= heights[i][n - j - 1]) {
                    right[i]++;
                } else {
                    canGoLeft = false;
                }
            }
        }

        for (int j = 0; j < n; j++) {

            boolean canGoUp = true;
            boolean canGoDown = true;

            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    continue;
                }

                if (i != 0 && canGoDown && heights[i - 1][j] <= heights[i][j]) {
                    up[j]++;
                } else {
                    canGoDown = false;
                }

                if (i != 0 && canGoUp && heights[m - i][j] <= heights[m - i - 1][j]) {
                    down[j]++;
                } else {
                    canGoUp = false;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flewPacificOcean = false;
                boolean flewAtlanticOcean = false;

                if (left[i] >= j || up[j] >= i) {
                    flewPacificOcean = true;
                }

                if (right[i] >= (n - j - 1) || down[j] >= (m - i - 1)) {
                    flewAtlanticOcean = true;
                }

                if (flewPacificOcean && flewAtlanticOcean) {
                    answers.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return answers;
    }

    //left :  5 1 3 2 1
    //right : 1 2 3 1 1
    //up : 2 4 3 2 1
    //down : 2 2 3 2 2
}
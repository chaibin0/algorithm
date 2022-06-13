package leetcode.problems.q733;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private int[][] vectors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(sc, sr));

        int m = image.length;
        int n = image[0].length;

        int color = image[sr][sc];
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {

            Pair currentPair = queue.pollFirst();
            int currentXpos = currentPair.xpos;
            int currentYpos = currentPair.ypos;

            for (int i = 0; i < vectors.length; i++) {
                int nextXpos = currentXpos + vectors[i][0];
                int nextYpos = currentYpos + vectors[i][1];
                if (nextXpos < 0 || nextXpos >= n || nextYpos < 0 || nextYpos >= m) {
                    continue;
                }

                if (image[nextYpos][nextXpos] != color) {
                    continue;
                }

                image[nextYpos][nextXpos] = newColor;
                queue.add(new Pair(nextXpos, nextYpos));
            }
        }

        return image;
    }

}

class Pair {
    int xpos;
    int ypos;

    Pair(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }
}
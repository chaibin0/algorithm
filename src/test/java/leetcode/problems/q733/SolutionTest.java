package leetcode.problems.q733;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void floodFill() {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = new Solution().floodFill(image, sr, sc, newColor);

        System.out.println(result);
    }

    @Test
    void floodFill2() {

        int[][] image = {
                {0, 0, 1},
                {1, 0, 0}};
        int sr = 1;
        int sc = 0;
        int newColor = 2;

        int[][] result = new Solution().floodFill(image, sr, sc, newColor);

        System.out.println(result);
    }
}
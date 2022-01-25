package problems.q84;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void largestRectangleArea() {

        int[] heights = {2, 1, 5, 6, 2, 3};
        int expected = 10;

        assertThat(new SolutionTimeExceed2().largestRectangleArea(heights)).isEqualTo(expected);
    }

    @Test
    void largestRectangleArea2() {

        int[] heights = {16, 9, 10, 3, 8, 7, 18, 10, 19, 0, 3, 3, 9, 13, 15, 19, 3, 6, 17, 9};
        int expected = 39;

        assertThat(new SolutionTimeExceed2().largestRectangleArea(heights)).isEqualTo(expected);
    }

}
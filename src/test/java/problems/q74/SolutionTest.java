package problems.q74;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void searchMatrix() {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        assertThat(new Solution().searchMatrix(matrix, target)).isTrue();
    }

    @Test
    void searchMatrix2() {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;

        assertThat(new Solution().searchMatrix(matrix, target)).isFalse();
    }

    @Test
    void searchMatrix3() {

        int[][] matrix = {{1}};
        int target = 2;

        assertThat(new Solution().searchMatrix(matrix, target)).isFalse();
    }

    @Test
    void searchMatrix4() {

        int[][] matrix = {{1, 1}};
        int target = 2;

        assertThat(new Solution().searchMatrix(matrix, target)).isFalse();
    }

    @Test
    void searchMatrix5() {

        int[][] matrix = {{1, 3}};
        int target = 3;

        assertThat(new Solution().searchMatrix(matrix, target)).isTrue();
    }

    @Test
    void searchMatrix6() {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 11;

        assertThat(new Solution().searchMatrix(matrix, target)).isTrue();
    }

    @Test
    void searchMatrix7() {

        int[][] matrix = {{1}, {3}};
        int target = 3;

        assertThat(new Solution().searchMatrix(matrix, target)).isTrue();
    }
}
package problems.sumOfTwoIntegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        assertEquals(3, solution.getSum(1, 2));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        assertEquals(-1, solution.getSum(-4, 3));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        assertEquals(-7, solution.getSum(-10, 3));
    }
}
package problems.q29;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void divide() {

        int dividend = 10;
        int divisor = 3;
        int expected = 3;

        Solution solution = new Solution();
        assertThat(solution.divide(dividend, divisor)).isEqualTo(expected);
    }

    @Test
    void divide2() {

        int dividend = 7;
        int divisor = -3;
        int expected = -2;

        Solution solution = new Solution();
        assertThat(solution.divide(dividend, divisor)).isEqualTo(expected);
    }

    @Test
    void divide3() {

        int dividend = 0;
        int divisor = 1;
        int expected = 0;

        Solution solution = new Solution();
        assertThat(solution.divide(dividend, divisor)).isEqualTo(expected);
    }

    @Test
    void divide4() {

        int dividend = -1010369383;
        int divisor = 1;
        int expected = -2147483648;

        Solution solution = new Solution();
        assertThat(solution.divide(dividend, divisor)).isEqualTo(expected);
    }
}
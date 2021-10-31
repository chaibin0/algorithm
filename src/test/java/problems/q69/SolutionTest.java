package problems.q69;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void mySqrt() {
        int input = 4;
        int expected = 2;

        assertThat(new Solution().mySqrt(input)).isEqualTo(expected);
    }

    @Test
    void mySqrt2() {
        int input = 8;
        int expected = 2;

        assertThat(new Solution().mySqrt(input)).isEqualTo(expected);
    }

    @Test
    void mySqrt3() {
        int input = 2;
        int expected = 1;

        assertThat(new Solution().mySqrt(input)).isEqualTo(expected);
    }

    @Test
    void mySqrt4() {
        int input = 2147395599;
        int expected = 46339;

        assertThat(new Solution().mySqrt(input)).isEqualTo(expected);
    }
}
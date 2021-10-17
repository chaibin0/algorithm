package problems.q50;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void myPow() {
        double x = 2.00000;
        int n = -2147483648;
        double expect = 1024;

        assertThat(new Solution().myPow(x,n)).isEqualTo(expect);
    }

    @Test
    void myPow2() {
        double x = 2.0;
        int n = -2;
        double expect = 0.25;

        assertThat(new Solution().myPow(x,n)).isEqualTo(expect);
    }
}
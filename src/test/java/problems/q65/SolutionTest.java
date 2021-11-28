package problems.q65;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void isNumber1() {

        String s = "0";
        assertThat(new Solution().isNumber(s)).isTrue();
    }

    @Test
    void isNumber2() {

        String s = "e";
        assertThat(new Solution().isNumber(s)).isFalse();
    }

    @Test
    void isNumber3() {

        String s = ".";
        assertThat(new Solution().isNumber(s)).isFalse();
    }

    @Test
    void isNumber4() {

        String s = ".1";
        assertThat(new Solution().isNumber(s)).isTrue();
    }

    @Test
    void isNumber5() {

        String s = "-123.456e789";
        assertThat(new Solution().isNumber(s)).isTrue();
    }

    @Test
    void isNumber6() {

        String s = "2e0";
        assertThat(new Solution().isNumber(s)).isTrue();
    }

    @Test
    void validExponentValue() {
    }

    @Test
    void validDecimalValue() {
    }

    @Test
    void validIntValue() {
    }
}
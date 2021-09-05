package problems.q43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    @DisplayName("Input: num1 = 2, num2 = 3 Output: 6")
    void multiply1() {

        Solution solution = new Solution();

        String num1 = "2";
        String num2 = "3";
        String output = "6";
        assertThat(solution.multiply(num1, num2)).isEqualTo(output);
    }

    @Test
    @DisplayName("Input: num1 = 123, num2 = 456 Output: 56088")
    void multiply2() {

        Solution solution = new Solution();

        String num1 = "123";
        String num2 = "456";
        String output = "56088";
        assertThat(solution.multiply(num1, num2)).isEqualTo(output);
    }

    @Test
    @DisplayName("size 0")
    void get0_0() {
        Solution solution = new Solution();
        assertThat(solution.get0(0)).isEqualTo("");
    }

    @Test
    @DisplayName("size 3")
    void get0_3() {
        Solution solution = new Solution();
        assertThat(solution.get0(3)).isEqualTo("000");
    }

    @Test
    void plus() {

        String num1 = "456";
        String num2 = "62";
        assertThat(new Solution().plus(num1, num2)).isEqualTo("518");
    }
}
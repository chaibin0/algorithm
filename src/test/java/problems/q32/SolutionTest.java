package problems.q32;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestValidParentheses1() {

        Solution solution = new Solution();
        String s = "(()";
        assertThat(solution.longestValidParentheses(s)).isEqualTo(2);
    }

    @Test
    void longestValidParentheses2() {

        Solution solution = new Solution();
        String s = ")()())";
        assertThat(solution.longestValidParentheses(s)).isEqualTo(4);
    }

    @Test
    void longestValidParentheses3() {

        Solution solution = new Solution();
        String s = "";
        assertThat(solution.longestValidParentheses(s)).isEqualTo(0);
    }
}
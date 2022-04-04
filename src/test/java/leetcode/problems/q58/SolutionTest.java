package leetcode.problems.q58;

import leetcode.problems.q58.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void lengthOfLastWord() {

        Solution solution = new Solution();
        String s = "   fly me   to   the moon  ";
        assertThat(solution.lengthOfLastWord(s)).isEqualTo(4);
    }
}
package problems.q58;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLastWord() {

        Solution solution = new Solution();
        String s = "   fly me   to   the moon  ";
        assertThat(solution.lengthOfLastWord(s)).isEqualTo(4);
    }
}
package leetcode.problems.q51;

import leetcode.problems.q51.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solveNQueens() {
        int n = 4;
        List<List<String>> answer = new Solution().solveNQueens(4);
        assertThat(answer.get(0).get(0)).isEqualTo(".Q..");
        assertThat(answer.get(0).get(1)).isEqualTo("...Q");
        assertThat(answer.get(0).get(2)).isEqualTo("Q...");
        assertThat(answer.get(0).get(3)).isEqualTo("..Q.");
        assertThat(answer.get(1).get(0)).isEqualTo("..Q.");
        assertThat(answer.get(1).get(1)).isEqualTo("Q...");
        assertThat(answer.get(1).get(2)).isEqualTo("...Q");
        assertThat(answer.get(1).get(3)).isEqualTo(".Q..");
    }
}
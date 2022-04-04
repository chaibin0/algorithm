package leetcode.problems.q62;

import leetcode.problems.q62.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void uniquePaths() {

        int m = 3;
        int n = 7;
        assertThat(new Solution().uniquePaths(m,n)).isEqualTo(28);
    }


    @Test
    void uniquePath2() {

        int m = 10;
        int n = 10;
        assertThat(new Solution().uniquePaths(m,n)).isEqualTo(48620);
    }
}
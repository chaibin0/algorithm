package problems.q60;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void getPermutation1() {
        int n = 3;
        int k = 3;
        String output = "213";

        assertThat(new Solution().getPermutation(n,k)).isEqualTo(output);
    }

    @Test
    void getPermutation2() {
        int n = 4;
        int k = 9;
        String output = "2314";

        assertThat(new Solution().getPermutation(n,k)).isEqualTo(output);
    }

    @Test
    void getPermutation3() {
        int n = 3;
        int k = 1;
        String output = "123";

        assertThat(new Solution().getPermutation(n,k)).isEqualTo(output);
    }
}
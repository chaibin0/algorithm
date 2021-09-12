package problems.q42;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void trap() {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertThat(new Solution().trap(height)).isEqualTo(6);
    }

    @Test
    void trap2() {

        int[] height = {4,2,0,3,2,5};
        assertThat(new Solution().trap(height)).isEqualTo(9);
    }
}
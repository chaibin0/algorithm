package leetcode.problems.q152;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProduct() {

        int[] input = {-2, 3, -4};
        assertThat(new Solution().maxProduct(input)).isEqualTo(24);
    }
}
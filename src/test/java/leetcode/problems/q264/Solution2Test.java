package leetcode.problems.q264;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {

    @Test
    void nthUglyNumber() {

        assertThat(new Solution2().nthUglyNumber(10)).isEqualTo(12);
    }
}
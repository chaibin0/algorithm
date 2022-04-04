package leetcode.problems.q40;

import leetcode.problems.q40.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void combinationSum2() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(1, 1, 6));
        answer.add(Arrays.asList(1, 2, 5));
        answer.add(Arrays.asList(1, 7));
        answer.add(Arrays.asList(2, 6));

        assertThat(new Solution().combinationSum2(candidates, target)).isEqualTo(answer);
    }
}
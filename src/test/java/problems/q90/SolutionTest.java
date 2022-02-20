package problems.q90;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void subsetsWithDup() {

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = new Solution().subsetsWithDup(nums);

        result.size();
    }
}
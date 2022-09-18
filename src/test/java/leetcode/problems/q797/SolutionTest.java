package leetcode.problems.q797;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void allPathsSourceTarget() {

        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        List<List<Integer>> answer = new Solution().allPathsSourceTarget(graph);

    }
}
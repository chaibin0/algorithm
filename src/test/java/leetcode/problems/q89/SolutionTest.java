package leetcode.problems.q89;

import leetcode.problems.q89.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

class SolutionTest {

    Logger logger = Logger.getLogger("test");
    @Test
    void grayCode() {
        int n = 3;

        List<Integer> answer = new Solution().grayCode(n);
        answer.stream().forEach(System.out::println);
    }
}
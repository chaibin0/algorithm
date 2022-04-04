package leetcode.problems.q91;

import leetcode.problems.q91.Solution;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void numDecodings() {

        String input = "11106";
        int result = new Solution().numDecodings(input);

        System.out.println(result);
    }
}
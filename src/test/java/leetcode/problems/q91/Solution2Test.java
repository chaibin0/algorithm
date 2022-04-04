package leetcode.problems.q91;

import leetcode.problems.q91.Solution2;
import org.junit.jupiter.api.Test;

class Solution2Test {

    @Test
    void numDecodings() {

        String input = "111111111111111111111111111111111111111111111";
        int result = new Solution2().numDecodings(input);

        System.out.println(result);
    }
}
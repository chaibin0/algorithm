package q91;

import org.junit.jupiter.api.Test;

class Solution2Test {

    @Test
    void numDecodings() {

        String input = "111111111111111111111111111111111111111111111";
        int result = new Solution2().numDecodings(input);

        System.out.println(result);
    }
}
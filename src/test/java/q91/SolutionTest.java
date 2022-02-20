package q91;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void numDecodings() {

        String input = "11106";
        int result = new Solution().numDecodings(input);

        System.out.println(result);
    }
}
package problems.q67;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void addBinary() {
        String a = "11";
        String b = "1";
        String answer = "100";
        assertThat(new Solution().addBinary(a,b)).isEqualTo(answer);
    }

    @Test
    void addBinary2() {
        String a = "1010";
        String b = "1011";
        String answer = "10101";
        assertThat(new Solution().addBinary(a,b)).isEqualTo(answer);
    }


}
package leetcode.problems.q139;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordBreak() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        assertThat(new Solution().wordBreak(s, wordDict)).isTrue();
    }

    @Test
    void wordBreak2() {
        String s = "catsandcat";
        List<String> wordDict = List.of("cats","atsand", "dcat");
        assertThat(new Solution().wordBreak(s, wordDict)).isFalse();
    }
}
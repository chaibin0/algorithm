package problems.q71;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void simplifyPath() {

        String path = "/home/";
        assertThat(new Solution().simplifyPath(path)).isEqualTo("/home");
    }

    @Test
    void simplifyPath2() {

        String path = "/../";
        assertThat(new Solution().simplifyPath(path)).isEqualTo("/");
    }

    @Test
    void simplifyPath3() {

        String path = "/home//foo/";
        assertThat(new Solution().simplifyPath(path)).isEqualTo("/home/foo");
    }

    @Test
    void simplifyPath4() {

        String path = "/a/./b/../../c/";
        assertThat(new Solution().simplifyPath(path)).isEqualTo("/c");
    }
}
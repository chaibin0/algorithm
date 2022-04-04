package leetcode.problems.q96;

import leetcode.problems.q96.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("numTreeArgument")
    void numTrees(int n, int expected) {
        int result = new Solution().numTrees(n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> numTreeArgument() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(5, 42),
                Arguments.of(6, 132),
                Arguments.of(7, 429),
                Arguments.of(8, 1430),
                Arguments.of(9, 4862),
                Arguments.of(10, 16796),
                Arguments.of(11, 58786),
                Arguments.of(12, 208012),
                Arguments.of(13, 742900),
                Arguments.of(14, 2674440),
                Arguments.of(15, 9694845),
                Arguments.of(16, 35357670),
                Arguments.of(17, 129644790),
                Arguments.of(18, 477638700),
                Arguments.of(19, 1767263190)
        );
    }
}


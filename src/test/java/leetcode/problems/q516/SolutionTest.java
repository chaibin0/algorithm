package leetcode.problems.q516;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindromeSubseq1() {

        String s = "bbbab";
        int output = 4;

        assertThat(new Solution().longestPalindromeSubseq(s)).isEqualTo(output);
    }

    @Test
    void longestPalindromeSubseq2() {

        String s = "cbbd";
        int output = 2;

        assertThat(new Solution().longestPalindromeSubseq(s)).isEqualTo(output);
    }

    @Test
    void longestPalindromeSubseq3() {

        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        int output = 159;

        assertThat(new Solution().longestPalindromeSubseq(s)).isEqualTo(output);
    }
}
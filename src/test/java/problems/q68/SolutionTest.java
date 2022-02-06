package problems.q68;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void fullJustify() {

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> answers = new Solution().fullJustify(words, maxWidth);

        assertThat(answers.get(0)).isEqualTo("This    is    an");
        assertThat(answers.get(1)).isEqualTo("example  of text");
        assertThat(answers.get(2)).isEqualTo("justification.  ");
    }

    @Test
    void fullJustify2() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};

        int maxWidth = 20;

        List<String> answers = new Solution().fullJustify(words, maxWidth);

        assertThat(answers.get(0)).isEqualTo("Science  is  what we");
        assertThat(answers.get(1)).isEqualTo("understand      well");
        assertThat(answers.get(2)).isEqualTo("enough to explain to");
        assertThat(answers.get(3)).isEqualTo("a  computer.  Art is");
        assertThat(answers.get(4)).isEqualTo("everything  else  we");
        assertThat(answers.get(5)).isEqualTo("do                  ");


    }
}
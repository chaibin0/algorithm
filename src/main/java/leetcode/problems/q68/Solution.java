package leetcode.problems.q68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<String> answer;

    public List<String> fullJustify(String[] words, int maxWidth) {
        answer = new ArrayList<>();


        int currentLength = 0;
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (currentLength + word.length() > maxWidth) {

                answer.add(justifyWord(wordList, maxWidth));
                wordList = new ArrayList<>(Arrays.asList(word));
                currentLength = word.length() + 1;
                continue;
            }

            wordList.add(word);
            currentLength += (word.length() + 1);
        }

        if (!wordList.isEmpty()) {
            answer.add(joinWord(wordList, maxWidth));
        }

        return answer;
    }

    private String justifyWord(List<String> wordList, int maxWidth) {
        if (wordList.size() == 1) {
            return joinWord(wordList, maxWidth);
        }

        StringBuilder sb = new StringBuilder();

        int wordCount = wordList.size();
        int wordsTotalLength = getWordTotalLength(wordList);
        int gapCount = wordCount - 1;
        int gap = (maxWidth - wordsTotalLength) / gapCount;
        int remain = (maxWidth - wordsTotalLength) % gapCount;
        int lastWordIndex = wordList.size() - 1;

        for (int i = 0; i < wordList.size(); i++) {
            sb.append(wordList.get(i));

            int whiteSpaceLength = gap;
            if (remain > 0) {
                whiteSpaceLength++;
                remain--;
            }

            if (i == lastWordIndex) {
                break;
            }
            String whiteSpace = getWhiteSpace(whiteSpaceLength);
            sb.append(whiteSpace);
        }

        return sb.toString();
    }

    private int getWordTotalLength(List<String> wordList) {
        int wordsTotalLength = 0;

        for (String word : wordList) {
            wordsTotalLength += word.length();
        }
        return wordsTotalLength;
    }

    private String getWhiteSpace(int whiteSpaceLength) {

        StringBuilder whiteSpace = new StringBuilder();
        for (int i = 0; i < whiteSpaceLength; i++) {
            whiteSpace.append(" ");
        }
        return whiteSpace.toString();
    }

    private String joinWord(List<String> wordList, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int lastWordIndex = wordList.size() - 1;
        int currentSize = 0;
        for (int i = 0; i < wordList.size(); i++) {

            String word = wordList.get(i);
            sb.append(word);
            currentSize += word.length();
            if (i == lastWordIndex) {
                break;
            }
            sb.append(" ");
            currentSize++;
        }

        int remain = maxWidth - currentSize;
        sb.append(getWhiteSpace(remain));

        return sb.toString();
    }
}

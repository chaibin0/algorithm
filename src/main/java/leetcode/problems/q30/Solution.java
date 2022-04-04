package leetcode.problems.q30;
/*

You are given a string s and an array of strings words of the same length.
Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]


Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.

*/

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> answer = new ArrayList<>();
        Set<String> successCache = new HashSet<>();

        int wordsAllLength = getWordAllLength(words);       //16

        if (s.length() < wordsAllLength) {
            return Collections.emptyList();
        }

        for (int i = 0; i <= s.length() - wordsAllLength; i++) {
            String subString = getSubString(i, wordsAllLength, s);
            if (successCache.contains(subString)) {
                answer.add(i);
                continue;
            }

            boolean[] visit = new boolean[words.length];
            if (isPossibleConcatWords(i, wordsAllLength, words, s, visit, 0)) {

                answer.add(i);
                successCache.add(subString);
            }
        }

        return answer;
    }

    private String getSubString(int index, int wordsAllLength, String s) {
        return s.substring(index, index + wordsAllLength);
    }

    private boolean isPossibleConcatWords(int index, int wordsAllLength, String[] words, String s, boolean[] visit, int currentSize) {

        if (currentSize == wordsAllLength) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            if (visit[i]) {
                continue;
            }

            if (isSameWord(index, s, words[i])) {
                visit[i] = true;
                if (isPossibleConcatWords(index + words[i].length(), wordsAllLength, words, s, visit, currentSize + words[i].length())) {
                    return true;
                }
                visit[i] = false;
            }
        }

        return false;
    }

    private boolean isSameWord(int index, String s, String word) {

        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(index++) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private int getWordAllLength(String[] words) {
        int length = 0;

        for (String word : words) {
            if (word.length() % 2 == 1) {
                continue;
            }

            length += word.length();
        }

        return length;
    }
}

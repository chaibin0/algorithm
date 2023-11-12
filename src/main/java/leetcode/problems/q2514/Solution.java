package leetcode.problems.q2514;

import java.math.BigInteger;
import java.util.*;

class Solution {

    private final long modulo = 1000_000_000 + 7L;

    public int countAnagrams(String s) {

        StringTokenizer st = new StringTokenizer(s, " ");
        List<Long> anagrams = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int[] alphabetCount = new int[26];
            String word = st.nextToken();
            int wordSize = word.length();

            for (int i = 0; i < wordSize; i++) {
                alphabetCount[word.charAt(i) - 'a']++;
            }

            for (int count : alphabetCount) {
                if (count == 0 || wordSize == 0) {
                    continue;
                }
                anagrams.add(combination(wordSize, count));
                wordSize -= count;
            }
        }

        BigInteger answer = new BigInteger(String.valueOf(1));
        for (long anagram : anagrams) {
            answer = answer.multiply(new BigInteger(String.valueOf(anagram)));
            answer = answer.mod(new BigInteger(String.valueOf(modulo)));
        }

        return answer.intValue();
    }

    private long combination(int n, int r) {

        double value = 1;

        if (n - r < r) {
            r = n - r;
        }

        for (int i = r; i >= 1; i--, n--) {
            value *= ((double) n / i);
            value %= modulo;
        }
        return (long) value;
    }
}


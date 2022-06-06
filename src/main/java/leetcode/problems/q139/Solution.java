package leetcode.problems.q139;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int sLength = s.length();
        Map<String, Integer> wordsToIndex = mapWordsToIndex(wordDict);
        Set<String> wordDictSet = wordDict.stream().collect(Collectors.toSet());
        Map<Integer, List<Integer>> hashTable = new HashMap<>();

        for (int i = 0; i < sLength; i++) {
            for (String words : wordDictSet) {
                int wordLength = words.length();
                if (i + wordLength > sLength) {
                    continue;
                }

                String sub = s.substring(i, i + wordLength);
                if (!sub.equals(words)) {
                    continue;
                }

                if (hashTable.containsKey(i)) {
                    hashTable.get(i).add(wordsToIndex.get(words));
                } else {
                    hashTable.put(i, new ArrayList<>(Arrays.asList(wordsToIndex.get(words))));
                }
            }
        }


        // catsandcats(10)
        // hastable
        // 0 -> (0, 2)
        // 3 -> 1
        // 7 -> (0, 2)
        // apple pen apple
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        boolean[] visited = new boolean[sLength];
        while (!dq.isEmpty()) {

            int index = dq.pollFirst();
            if (!hashTable.containsKey(index)) {
                continue;
            }

            List<Integer> list = hashTable.get(index);
            for (int i : list) {
                int nextIndex = index + wordDict.get(i).length();
                if (nextIndex == s.length()) {
                    return true;
                }

                if (visited[nextIndex]) {
                    continue;
                }
                dq.add(index + wordDict.get(i).length());
                visited[nextIndex] = true;
            }
        }

        return false;
    }

    public Map<String, Integer> mapWordsToIndex(List<String> wordDict) {

        Map<String, Integer> wordsToIndex = new HashMap<>();

        int wordDictSize = wordDict.size();
        for (int i = 0; i < wordDictSize; i++) {
            wordsToIndex.put(wordDict.get(i), i);
        }

        return wordsToIndex;
    }
}
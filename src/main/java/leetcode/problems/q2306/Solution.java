package leetcode.problems.q2306;

import java.util.*;

class Solution {

    public long distinctNames(String[] ideas) {
        long answer = 0;
        Map<String, boolean[]> companyFirstLetterMap = new HashMap<>();
        for (String idea : ideas) {

            String subStr = idea.length() <= 1 ? "" : idea.substring(1);
            char firstLetter = idea.charAt(0);
            if (!companyFirstLetterMap.containsKey(subStr)) {
                companyFirstLetterMap.put(subStr, new boolean[26]);
            }

            companyFirstLetterMap.get(subStr)[firstLetter - 'a'] = true;
        }

        List<Map.Entry<String, boolean[]>> entries = new ArrayList<>(companyFirstLetterMap.entrySet());
        int entriesSize = entries.size();

        for (int i = 0; i < entriesSize - 1; i++) {

            boolean[] baseAlphabets = entries.get(i).getValue();

            for (int j = i + 1; j < entriesSize; j++) {
                boolean[] targetAlphabets = entries.get(j).getValue();

                int base = 0;
                int target = 0;

                for (int k = 0; k < 26; k++) {
                    if (baseAlphabets[k] && targetAlphabets[k]) {
                        continue;
                    }

                    if (baseAlphabets[k] && !targetAlphabets[k]) {
                        base++;
                    }

                    if (!baseAlphabets[k] && targetAlphabets[k]) {
                        target++;
                    }
                }

                answer += ((long) base * target * 2);
            }
        }

        return answer;
    }
}

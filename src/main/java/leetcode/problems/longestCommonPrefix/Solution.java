package leetcode.problems.longestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = new String();
        int count = 0;

        if(strs.length==0)
            return answer;

        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if(min>strs[i].length()) {
                min=strs[i].length();
            }
        }

        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[0].charAt(i) == strs[j].charAt(i))
                    count++;
            }

            if (count == strs.length) {
                answer += strs[0].charAt(i);
                count = 0;
            }
            else break;
        }

        return answer;
    }
}
package leetcode.problems.q880;

class Solution {
    public String decodeAtIndex(String s, int k) {
        int sLength = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sLength; i++) {
            if (sb.length() >= k) {
                return sb.substring(k - 1, k);
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int digit = s.charAt(i) - '0';
                if (sb.length() * digit >= k) {
                    if (k % sb.length() == 0) {
                        return sb.substring(sb.length() - 1, sb.length());
                    }

                    return sb.substring(k % sb.length() - 1, k % sb.length());
                }
                sb = new StringBuilder(sb.toString().repeat(digit));
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.substring(k - 1, k);
    }
}

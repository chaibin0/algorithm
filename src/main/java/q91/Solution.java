package q91;

class Solution {

    private StringBuilder sb;
    private int[] dp;

    public int numDecodings(String s) {

        this.sb = new StringBuilder(s);
        this.dp = new int[s.length() + 2];
        this.dp[0] = 1;

        for (int i = 0; i < sb.length(); i++) {
            String first = sb.substring(i, i + 1);
            if (isbetweenMappingTable(first)) {
                dp[i + 1] += dp[i];
            }

            if ((i + 2) > sb.length()) {
                continue;
            }
            String second = sb.substring(i, i + 2);
            if (isbetweenMappingTable(second)) {
                dp[i + 2] += dp[i];
            }
        }
        return dp[s.length()];
    }

    private boolean isbetweenMappingTable(String s) {

        int value = Integer.parseInt(s);

        if (s.length() == 1) {
            return value > 0 && value <= 9;
        }

        return value >= 10 && value <= 26;
    }
}
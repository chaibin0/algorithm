package q91;

class Solution2 {

    private StringBuilder sb;
    private int answer;

    public int numDecodings(String s) {

        this.answer = 0;
        this.sb = new StringBuilder(s);
        solve(0);
        return answer;
    }

    private void solve(int i) {
        if (i == sb.length()) {
            answer++;
            return;
        }

        if ((i + 1) > sb.length()) {
            return;
        }
        String first = sb.substring(i, i + 1);
        if (isbetweenMappingTable(first)) {
            solve(i + 1);
        }

        if ((i + 2) > sb.length()) {
            return;
        }
        String second = sb.substring(i, i + 2);
        if (isbetweenMappingTable(second)) {
            solve(i + 2);
        }
    }

    private boolean isbetweenMappingTable(String s) {

        int value = Integer.parseInt(s);

        if (s.length() == 1) {
            return value > 0 && value <= 9;
        }

        return value >= 10 && value <= 26;
    }
}
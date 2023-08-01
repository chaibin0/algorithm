package leetcode.problems.q639;

class Solution {

    private static final char ASTERISK = '*';
    private static final int MODULO = 1000_000_000 + 7;
    private int[][] decodeTable;
    private long[] dp;

    public int numDecodings(String s) {

        int sLength = s.length();

        this.decodeTable = new int[2][sLength];
        this.dp = new long[sLength];

        for (int i = 0; i < sLength; i++) {

            char currentCharacter = s.charAt(i);

            if (currentCharacter == ASTERISK) {
                this.decodeTable[0][i] = 9;
            } else if (currentCharacter == '0') {
                this.decodeTable[0][i] = 0;
            } else {
                this.decodeTable[0][i] = 1;
            }


            if (i + 1 >= sLength) {
                continue;
            }

            char nextCharacter = s.charAt(i + 1);

            if (currentCharacter == ASTERISK && nextCharacter == ASTERISK) {
                this.decodeTable[1][i] = 15;
            }
            if (currentCharacter == ASTERISK && nextCharacter != ASTERISK) {
                this.decodeTable[1][i] += (nextCharacter >= '0' && nextCharacter <= '6') ? 2 : 1;
            }

            if (currentCharacter != ASTERISK && nextCharacter == ASTERISK) {
                if (currentCharacter == '1') {
                    this.decodeTable[1][i] = 9;
                } else if (currentCharacter == '2') {
                    this.decodeTable[1][i] = 6;
                } else {
                    this.decodeTable[1][i] = 0;
                }
            }

            if (currentCharacter != ASTERISK && nextCharacter != ASTERISK) {
                int value = Character.getNumericValue(currentCharacter) * 10 + Character.getNumericValue(nextCharacter);
                if(value>= 10 && value <= 26){
                    this.decodeTable[1][i] = 1;
                } else {
                    this.decodeTable[1][i] = 0;
                }

            }
        }

        this.dp[0] = solve(0, sLength - 1);
        return (int) this.dp[0] % MODULO;
    }

    private long solve(int start, int end) {

        if (start > end) {
            return 1;
        }

        if (this.dp[start] != 0) {
            return (int) (this.dp[start] % MODULO);
        }

        if(this.decodeTable[0][start] != 0){
            this.dp[start] += (long) this.decodeTable[0][start] * solve(start + 1, end) % MODULO;
        }

        if (start + 1 <= end && this.decodeTable[1][start] != 0) {
            this.dp[start] += (long) this.decodeTable[1][start] * solve(start + 2, end) % MODULO;
        }

        return this.dp[start] % MODULO;
    }
}

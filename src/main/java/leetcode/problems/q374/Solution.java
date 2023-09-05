package leetcode.problems.q374;


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long low = 1;
        long high = n;

        while(low < high){
            long mid = (low + high) / 2;

            int result = guess((int)mid);
            if(result == 1){
                low = mid + 1;
            } else if(result == -1){
                high = mid - 1;
            } else {
                return (int) mid;
            }
        }

        return (int) low;
    }

    private int guess(int mid) {
        return 0;
    }
}
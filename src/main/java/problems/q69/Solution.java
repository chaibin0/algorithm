package problems.q69;

class Solution {
    public int mySqrt(int x) {

        int low = 0;
        int high = 65536;
        int mid = 0;

        for (int i = 0; i < 16; i++) {
            mid = (low + high) / 2;
            int power = mid * mid;

            if (power < 0) {
                high = mid;
                continue;
            }

            if (x == power) {
                return mid;
            }

            if (x > power) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
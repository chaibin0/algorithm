package leetcode.problems.q2582;

class Solution {
    public int passThePillow(int n, int time) {

        time += 1;
        int pass = 1;
        int current = 0;
        for (int i = 1; i <= time; i++) {

            current += pass;

            if (current == n) {
                pass = -1;
            }

            if (current == 1) {
                pass = 1;
            }
        }

        return current;
    }
}
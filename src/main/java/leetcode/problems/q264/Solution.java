package leetcode.problems.q264;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<Integer> uglyNum = new HashSet<>();

    public int nthUglyNumber(int n) {
        if (n <= 5) {
            return n;
        }

        uglyNum = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        int size = 5;
        for (int i = 6; i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0 && uglyNum.contains(i / 2)) {
                uglyNum.add(i);
                size++;
            } else if (i % 3 == 0 && uglyNum.contains(i / 3)) {
                uglyNum.add(i);
                size++;
            } else if (i % 5 == 0 && uglyNum.contains(i / 5)) {
                uglyNum.add(i);
                size++;
            }

            if (size == n) {
                return i;
            }
        }

        return 0;
    }
}
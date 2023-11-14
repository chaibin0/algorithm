package leetcode.problems.q2300;

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        for (int i = 0; i < potions.length; i++) {
            potions[i] = (int) Math.ceil((double) success / potions[i]);
        }

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int low = 0;
            int high = potions.length - 1;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;

                if (spell >= potions[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (low != potions.length && potions[low] < spell) {
                low++;
            }
            spells[i] = low;
        }

        return spells;
    }
}

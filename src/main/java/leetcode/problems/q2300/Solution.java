package leetcode.problems.q2300;

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] atLeastSuccessNum = new int[potions.length];

        for (int i = 0; i < potions.length; i++) {
            atLeastSuccessNum[i] = (int) Math.ceil((double) success / potions[i]);
        }

        Arrays.sort(atLeastSuccessNum);

        int[] answer = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int low = 0;
            int high = atLeastSuccessNum.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;

                if (spell >= atLeastSuccessNum[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (low != atLeastSuccessNum.length && atLeastSuccessNum[low] < spell) {
                low++;
            }
            answer[i] = low;
        }

        return answer;
    }
}

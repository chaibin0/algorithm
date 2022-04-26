package leetcode.problems.q740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<Integer> numList;
    List<Integer> sumOfNumList;
    private int[] dp;

    public int deleteAndEarn(int[] nums) {

        numList = new ArrayList<>();
        sumOfNumList = new ArrayList<>();

        Arrays.sort(nums);

        int lastNum = -1;
        int sumOfNum = 0;
        for (int num : nums) {
            if (lastNum != num) {
                if (lastNum != -1) {
                    numList.add(lastNum);
                    sumOfNumList.add(sumOfNum);
                }
                lastNum = num;
                sumOfNum = num;
                continue;
            }

            sumOfNum += num;
        }

        numList.add(lastNum);
        sumOfNumList.add(sumOfNum);

        int size = numList.size();
        if (size == 1) {
            return sumOfNumList.get(0);
        }

        dp = new int[size];
        dp[0] = sumOfNumList.get(0);
        dp[1] = numList.get(0) + 1 == numList.get(1) ? sumOfNumList.get(1) : sumOfNumList.get(1) + dp[0];

        for (int i = 2; i < size; i++) {
            if (numList.get(i) == numList.get(i - 1) + 1) {
                dp[i] = sumOfNumList.get(i) + getMaxNum(i - 2, i - 3);
                continue;
            }

            dp[i] = getMaxNum(i - 1, i - 2) + sumOfNumList.get(i);
        }

        return getMaxNum(size - 1, size - 2);
    }

    public int getMaxNum(int index1, int index2) {
        if (index1 < 0 && index2 < 0) {
            return 0;
        }

        if (index1 < 0) {
            return dp[index2];
        }


        if (index2 < 0) {
            return dp[index1];
        }

        return Math.max(dp[index1], dp[index2]);
    }
}

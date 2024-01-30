package leetcode.problems.q698;

import java.util.Arrays;


class Solution {
    private int[] nums;
    private int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        this.nums = nums;
        this.k = k;

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int equalSum = sum / k;
        int[] sums = new int[k];
        return dfs(sums, 0, 0, equalSum);
    }

    public boolean dfs(int[] sums, int size, int position, int equalsSum) {
        if (position == nums.length) {
            for (int sum : sums) {
                if (sum != equalsSum) {
                    return false;
                }
            }

            return true;
        }

        for (int i = 0; i < sums.length; i++) {
            if (i > size) {
                break;
            }

            if ((sums[i] + nums[position]) > equalsSum) {
                continue;
            }

            sums[i] = sums[i] + nums[position];
            if (dfs(sums, size + 1, position + 1, equalsSum)) {
                return true;
            }
            sums[i] = sums[i] - nums[position];
        }

        return false;
    }
}


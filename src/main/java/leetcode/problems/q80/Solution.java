package leetcode.problems.q80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int totalDuplicateCount = 0;
        int currentValue = Integer.MIN_VALUE;
        int currentDuplicateCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentValue != nums[i]) {
                currentValue = nums[i];
                currentDuplicateCount = 0;
                continue;
            }

            currentDuplicateCount++;
            if (currentDuplicateCount > 1) {
                totalDuplicateCount++;
                nums[i] = Integer.MIN_VALUE;
            }
        }

        int answer = nums.length - totalDuplicateCount;
        int j = 0;
        for (int i = 0; i < answer; i++) {

            j++;

            if (nums[i] != Integer.MIN_VALUE) {
                continue;
            }

            while (j < nums.length) {
                if (nums[j] != Integer.MIN_VALUE) {
                    nums[i] = nums[j];
                    nums[j] = Integer.MIN_VALUE;
                    break;
                }
                j++;
            }
        }


        return answer;
    }
}
package leetcode.problems.q35;

class Solution {
    public int searchInsert(int[] nums, int target) {

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        if (nums[0] > target) {
            return 0;
        }

        int low = 0;
        int high = nums.length;
        int mid = 0;

        while (low <= high) {

            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));
    }
}
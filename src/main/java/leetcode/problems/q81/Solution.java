package leetcode.problems.q81;

class Solution {
    public boolean search(int[] nums, int target) {

        return search(0, nums.length - 1, nums, target);
    }

    public boolean search(int low, int high, int[] nums, int target) {

        if (low < 0 || low >= nums.length || high < 0 || high >= nums.length) {
            return false;
        }

        if (low >= high) {
            return nums[low] == target;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return true;
        }

        if (mid - 1 >= 0 && nums[low] >= nums[mid - 1] && search(low, mid - 1, nums, target)) {
            return true;
        }

        if (mid + 1 <= nums.length && nums[mid + 1] >= nums[high] && search(mid + 1, high, nums, target)) {
            return true;
        }

        if (mid - 1 >= 0 && target >= nums[low] && target <= nums[mid - 1] && binarySearch(low, mid - 1, nums, target)) {
            return true;
        }

        if (mid + 1 <= nums.length && target >= nums[mid + 1] && target <= nums[high] && binarySearch(mid + 1, high, nums, target)) {
            return true;
        }

        return false;
    }

    private boolean binarySearch(int low, int high, int[] nums, int target) {

        int mid;
        while (low <= high) {

            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
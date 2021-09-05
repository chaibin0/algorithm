package problems.q33;

class Solution {
    public int search(int[] nums, int target) {

        if (nums[0] < nums[nums.length - 1] && target <= nums[nums.length - 1] && target >= nums[0]) {
            return findIndex(nums, 0, nums.length - 1, target);
        }

        return slice(nums, 0, nums.length - 1, target);
    }

    public int slice(int[] nums, int start, int end, int target) {

        int midIndex = (start + end) / 2;

        if (nums[midIndex] == target) {
            return midIndex;
        }

        if (start == end) {
            return -1;
        }

        if (nums[start] <= nums[midIndex] && target <= nums[midIndex] && target >= nums[start]) {
            return findIndex(nums, start, midIndex, target);
        } else if (midIndex + 1 < nums.length && nums[midIndex + 1] <= nums[end] && target <= nums[end] && target >= nums[midIndex + 1]) {
            return findIndex(nums, midIndex + 1, end, target);
        }

        if (nums[start] > nums[midIndex] && (target >= nums[start] || target <= nums[midIndex])) {
            return slice(nums, start, midIndex, target);
        } else if (midIndex + 1 < nums.length && nums[midIndex + 1] > nums[end] && (target >= nums[midIndex + 1] || target <= nums[end])) {
            return slice(nums, midIndex + 1, end, target);
        }

        return -1;
    }

    public int findIndex(int[] nums, int start, int end, int target) {

        int low = start;
        int high = end;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
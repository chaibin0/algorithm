package leetcode.problems.q162;

class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;

            if(mid >= nums.length - 1){
                return mid;
            }

            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}

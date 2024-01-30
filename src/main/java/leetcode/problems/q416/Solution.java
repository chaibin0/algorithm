package leetcode.problems.q416;

class Solution {

    private boolean[][] leftDp;
    private boolean[][] rightDp;
    private int dpValue;
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }

        this.dpValue = sum / 2;
        this.leftDp = new boolean[nums.length][dpValue + 1];
        this.rightDp= new boolean[nums.length][dpValue + 1];

        return dfs(nums, 0, 0, 0);
    }

    public boolean dfs(int[] nums, int position, int leftSum, int rightSum){

        if(position == nums.length){
            return leftSum == rightSum;
        }

        if(leftSum > dpValue || rightSum > dpValue){
            return false;
        }

        if(this.leftDp[position][leftSum]){
            return false;
        }

        if(this.rightDp[position][rightSum]){
            return false;
        }

        this.leftDp[position][leftSum] = true;
        this.rightDp[position][rightSum] = true;


        return dfs(nums, position + 1, leftSum + nums[position], rightSum) ||
                dfs(nums, position + 1, leftSum, rightSum + nums[position]);
    }


}

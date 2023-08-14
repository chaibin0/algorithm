package leetcode.problems.q1980;

import java.util.Arrays;

class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int n = nums[0].length();

        Arrays.sort(nums);
        if (!"0".repeat(n).equals(nums[0])) {
            return "0".repeat(n);
        }

        if (n == 1) {
            return "1";
        }

        String one = "0".repeat(n - 1) + "1";


        String lastNum = nums[0];
        StringBuilder sumNum = new StringBuilder();
        boolean sum = false;

        for (int i = 1; i < nums.length; i++) {
            sumNum = new StringBuilder();
            sum = false;
            for (int j = n - 1; j >= 0; j--) {
                sumNum.append((sum ? 1 : 0) ^ (one.charAt(j) - '0') ^ (lastNum.charAt(j) - '0'));
                sum = ((sum ? 1 : 0) + (one.charAt(j) - '0') + (lastNum.charAt(j) - '0')) > 1;
            }
            if (!sumNum.reverse().toString().equals(nums[i])) {
                return sumNum.toString();
            }

            lastNum = nums[i];
        }

        sumNum = new StringBuilder();

        for (int j = n - 1; j >= 0; j--) {
            sumNum.append((sum ? 1 : 0) ^ (one.charAt(j) - '0') ^ (lastNum.charAt(j) - '0'));
            sum = ((sum ? 1 : 0) + (one.charAt(j) - '0') + (lastNum.charAt(j) - '0')) > 1;
        }

        return sumNum.reverse().toString();
    }
}

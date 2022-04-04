package leetcode.problems.q42;

class Solution {
    public int trap(int[] height) {

        int maxHeight = 0;
        int sumHeight = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
            sumHeight += height[i];
        }

        int totalWater = height.length * maxHeight - sumHeight;

        int currentHeightWater = height[0];
        for (int i = 0; i < height.length; i++) {
            if (currentHeightWater < height[i]) {
                totalWater -= ((height[i] - currentHeightWater) * i);
                currentHeightWater = height[i];
            }
        }

        currentHeightWater = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            if (currentHeightWater < height[i]) {
                totalWater -= ((height[i] - currentHeightWater) * (height.length - 1 - i));
                currentHeightWater = height[i];
            }
        }

        return totalWater;
    }
}
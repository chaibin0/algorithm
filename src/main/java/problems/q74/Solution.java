package problems.q74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int heightValue = getAdjustHeightIndex(matrix, target);
        if (matrix[heightValue][0] == target) {
            return true;
        }

        int widthValue = getTargetByBinarySearch(matrix[heightValue], target);
        return matrix[heightValue][widthValue] == target;
    }

    public int getAdjustHeightIndex(int[][] matrix, int target) {
        if (matrix[0][0] >= target) {
            return 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                return i - 1;
            }
        }
        return matrix.length - 1;
    }

    public int getTargetByBinarySearch(int[] matrix, int target) {

        int low = 0;
        int high = matrix.length - 1;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;
            if (matrix[mid] == target) {
                return mid;
            }

            if (matrix[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
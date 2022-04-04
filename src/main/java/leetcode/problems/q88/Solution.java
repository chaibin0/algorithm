package leetcode.problems.q88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPos = m - 1;
        int nPos = n - 1;
        int lastIndex = nums1.length - 1;
        while (mPos >= 0 && nPos >= 0) {
            if (nums1[mPos] <= nums2[nPos]) {
                nums1[lastIndex] = nums2[nPos];
                nPos--;
                lastIndex--;
                continue;
            }

            nums1[lastIndex] = nums1[mPos];
            mPos--;
            lastIndex--;
        }

        while (nPos >= 0) {
            nums1[lastIndex] = nums2[nPos];
            nPos--;
            lastIndex--;
        }
    }
}
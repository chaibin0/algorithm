package problems.medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        List<Integer> nums3=new ArrayList<>();

        while(i<nums1.length&&j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                nums3.add(nums1[i]);
                i++;
            }
            else {
                nums3.add(nums2[j]);
                j++;
            }
        }

        while(i<nums1.length) {
            nums3.add(nums1[i]);
            i++;
        }
        while(j<nums2.length) {
            nums3.add(nums2[j]);
            j++;
        }

        if(nums3.size()%2==0) {
            return (double)(nums3.get(nums3.size()/2)+nums3.get((nums3.size()/2-1)))/2;
        }
        else {
            return nums3.get(nums3.size()/2);
        }
    }
}

package leetcode.problems.q78;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> answers;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {

        this.answers = new ArrayList<>();
        this.nums = nums;

        for (int i = 0; i <= nums.length; i++) {
            makeSubsets(0, i, new ArrayList<>());
        }

        return answers;
    }

    public void makeSubsets(int index, int size, List<Integer> items) {

        if (items.size() == size) {
            answers.add(new ArrayList<>(items));
            return;
        }

        if (index == nums.length) {
            return;
        }

        makeSubsets(index + 1, size, items);

        items.add(nums[index]);
        makeSubsets(index + 1, size, items);
        items.remove((Integer) nums[index]);
    }
}
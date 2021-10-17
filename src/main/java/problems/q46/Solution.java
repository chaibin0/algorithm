package problems.q46;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Solution {
    public List<List<Integer>> permute(int[] nums) {

        int permutationLength = factorial(nums.length);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(toList(nums));


        for (int i = 0; i < permutationLength - 1; i++) {
            nextPermute(nums);
            answer.add(toList(nums));
        }

        return answer;
    }

    public List<Integer> toList(int[] nums) {
        return IntStream.of(nums)
                .boxed()
                .collect(Collectors.toList());
    }

    public void nextPermute(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int factorial(int length) {
        int n = 1;
        for (int i = 1; i <= length; i++) {
            n = n * i;
        }
        return n;
    }
}
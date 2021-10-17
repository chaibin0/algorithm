package problems.q47;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        if(nums.length == 1){
            answer.add(new ArrayList<>(Arrays.asList(nums[0])));
            return answer;
        }

        Set<List<Integer>> alreadySavedPermute = new HashSet<>();
        List<List<Integer>> basePermuteList = new ArrayList<>();
        int permutationLength = factorial(nums.length);
        int[] base = IntStream.range(0, nums.length).toArray();
        basePermuteList.add(toList(base));

        for (int i = 0; i < permutationLength - 1; i++) {
            nextPermute(base);
            basePermuteList.add(toList(base));
        }

        for (List<Integer> basePermute : basePermuteList) {
            List<Integer> valueList = new ArrayList<>();
            for(int value : basePermute){
                valueList.add(nums[value]);
            }
            alreadySavedPermute.add(valueList);
        }

        for (List<Integer> filteredPermute : alreadySavedPermute) {
            answer.add(filteredPermute);
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
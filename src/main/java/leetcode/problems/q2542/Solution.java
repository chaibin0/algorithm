package leetcode.problems.q2542;


import java.util.*;

class Solution {

    private long answer = 0L;
    private int[] nums1;
    private int[] nums2;

    private int k;

    private List<Pair> pairs = new ArrayList<>();

    public long maxScore(int[] nums1, int[] nums2, int k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.k = k;

        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new Pair(nums1[i], nums2[i]));
        }

        Collections.sort(pairs);

        dfs(0, 0, 0, Integer.MAX_VALUE);

        return answer;
    }

    private void dfs(int size, int currentIndex, int num1SumValue, int num2MinValue) {

        if (num2MinValue == 0) {
            return;
        }

        if (size == k) {
            answer = Math.max(answer, (long) num1SumValue * num2MinValue);
            return;
        }

        if (currentIndex == pairs.size()) {
            return;
        }

        if (currentIndex < pairs.size()) {
            dfs(size, currentIndex + 1, num1SumValue, num2MinValue);
            dfs(size + 1, currentIndex + 1, num1SumValue + pairs.get(currentIndex).num1, Math.min(num2MinValue, pairs.get(currentIndex).num2));
        }
    }
}

class Pair implements Comparable<Pair> {

    int num1;
    int num2;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.num2 == this.num2) {
            return o.num1 - this.num1;
        }

        return o.num2 - this.num2;
    }
}
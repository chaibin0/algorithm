package leetcode.problems.q1049;

import java.util.*;
class Solution {

    private int[] stones;
    private int answer = Integer.MAX_VALUE;
    private Map<Integer, Set<Integer>> cache;

    public int lastStoneWeightII(int[] stones) {
        this.stones = stones;
        this.cache = new HashMap<>();
        Arrays.sort(stones);
        dfs(0, 0);
        return answer;
    }

    public void dfs(int position, int sum) {

        if (!cache.containsKey(position)) {
            cache.put(position, new HashSet<>());
        }

        if (cache.get(position).contains(sum)) {
            return;
        }

        cache.get(position).add(sum);

        if (position >= stones.length) {
            answer = Math.min(answer, Math.abs(sum));
            return;
        }

        dfs(position + 1, Math.abs(Math.abs(sum) - stones[position]));
        dfs(position + 1, Math.abs(Math.abs(sum) + stones[position]));
    }
}


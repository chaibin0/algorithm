package leetcode.problems.q797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int[][] graph;
    private List<List<Integer>> answers;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        answers = new ArrayList<>();
        dfs(new ArrayList<>(Arrays.asList(0)), 0);
        return answers;
    }

    private void dfs(List<Integer> list, int current) {

        if (current == this.graph.length - 1) {
            answers.add(new ArrayList<>(list));
            return;
        }

        for (int next : graph[current]) {
            list.add(next);
            dfs(list, next);
            list.remove((Integer) next);
        }
    }
}


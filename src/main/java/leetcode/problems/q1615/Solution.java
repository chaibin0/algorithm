package leetcode.problems.q1615;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] size = new int[n];
        int[][] graph = new int[n][n];

        for (int[] road : roads) {
            graph[road[0]][road[1]] = 1;
            graph[road[1]][road[0]] = 1;
            size[road[0]]++;
            size[road[1]]++;
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer = Math.max(answer, size[i] + size[j] - graph[i][j]);
            }
        }

        return answer;


    }
}

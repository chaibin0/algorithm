package leetcode.problems.q1989;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {

        int answer = 0;

        Queue<Integer> notItQueue = new PriorityQueue<>();

        for (int i = 0; i < dist; i++) {
            if (team[i] == 0) {
                notItQueue.add(i);
                team[i] = -1;
            }
        }

        for (int i = 0; i < team.length; i++) {

            int left = i - dist;
            int right = i + dist;

            if (right < team.length && team[right] == 0) {
                notItQueue.add(right);
                team[right] = -1;
            }

            if (team[i] != 1) {
                continue;
            }

            while (!notItQueue.isEmpty()) {

                int notIt = notItQueue.poll();
                if (notIt >= left && notIt <= right) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
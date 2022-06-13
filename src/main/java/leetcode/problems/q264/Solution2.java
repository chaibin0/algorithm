package leetcode.problems.q264;

import java.util.PriorityQueue;

public class Solution2 {

    PriorityQueue<Long> pq;

    public int nthUglyNumber(int n) {
        pq = new PriorityQueue<>();
        pq.add(1l);
        for (int i = 1; i <= n; i++) {
            long value = pq.poll();
            if (i == n) {
                return (int) value;
            }

            if (!pq.contains(value * 2)) {
                pq.add(value * 2);
            }
            if (!pq.contains(value * 3)) {
                pq.add(value * 3);
            }
            if (!pq.contains(value * 5)) {
                pq.add(value * 5);
            }
        }

        return 1;
    }
}

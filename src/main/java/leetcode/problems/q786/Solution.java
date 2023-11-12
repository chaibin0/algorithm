package leetcode.problems.q786;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<Data> list = new PriorityQueue<>(
                Comparator.comparingDouble(o -> o.value)
        );

        int[] current = new int[arr.length];

        for (int j = 1; j < arr.length; j++) {
            list.add(new Data(0, j, (double) arr[0] / arr[j]));
        }

        for (int pos = 1; pos <= k; pos++) {
            Data smallest = list.poll();

            if (pos == k) {
                return new int[]{arr[smallest.i], arr[smallest.j]};
            }

            if (current[smallest.j] < smallest.j) {
                current[smallest.j]++;
                list.add(new Data(current[smallest.j], smallest.j, (double) arr[current[smallest.j]] / arr[smallest.j]));
            }
        }

        return null;
    }
}

class Data {
    final int i;
    final int j;
    final double value;

    public Data(int i, int j, double value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

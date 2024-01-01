package leetcode.problems.q1792;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        Queue<StudentRatio> queue = new PriorityQueue<>(((o1, o2) -> Double.compare(o2.difference, o1.difference)));

        for (int i = 0; i < classes.length; i++) {
            queue.add(new StudentRatio(i,
                    (double) classes[i][0] / classes[i][1],
                    (double) (classes[i][0] + 1) / (classes[i][1] + 1) -
                            ((double) classes[i][0] / classes[i][1])));
        }

        for (int i = 0; i < extraStudents && !queue.isEmpty(); i++) {
            StudentRatio studentRatio = queue.poll();
            classes[studentRatio.index][0] += 1;
            classes[studentRatio.index][1] += 1;
            queue.add(new StudentRatio(studentRatio.index,
                    (double) (classes[studentRatio.index][0]) / (classes[studentRatio.index][1]),
                    ((double) (classes[studentRatio.index][0] + 1) / (classes[studentRatio.index][1] + 1)) -
                            (double) (classes[studentRatio.index][0]) / (classes[studentRatio.index][1])));
        }

        double answer = 0;
        while (!queue.isEmpty()) {
            answer += queue.poll().ratio;
        }

        return answer / classes.length;
    }
}

class StudentRatio {

    int index;
    double ratio;
    double difference;

    public StudentRatio(int index, double ratio, double difference) {
        this.index = index;
        this.ratio = ratio;
        this.difference = difference;
    }
}

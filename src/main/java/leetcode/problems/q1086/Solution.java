package leetcode.problems.q1086;

import java.util.*;

class Solution {
    public int[][] highFive(int[][] items) {

        List<int[]> outputs = new ArrayList<>();

        Arrays.sort(items, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        });

        int count = 1;
        int[] output = new int[2];
        output[0] = items[0][0];
        output[1] = items[0][1];

        for(int i=1;i<items.length;i++){
            if(output[0] != items[i][0]){
                output[1] /= count;
                outputs.add(output);
                output = new int[2];
                output[0] = items[i][0];
                output[1] = items[i][1];
                count = 1;
                continue;
            }

            if(count >= 5){
                continue;
            }

            output[1] += items[i][1];
            count++;
        }

        output[1] /= count;
        outputs.add(output);

        int[][] result = new int[outputs.size()][2];
        for(int i=0;i<outputs.size();i++){
            result[i] = outputs.get(i);
        }

        return result;
    }
}

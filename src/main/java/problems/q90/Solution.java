package problems.q90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {

    private TreeMap<Integer, Integer> countOfNum;
    private List<Integer> numberList;
    private List<List<Integer>> answers;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        this.countOfNum = initCountOfNum(nums);
        this.numberList = initNumberList(nums);
        this.answers = new ArrayList<>();

        dfs(0, new ArrayList<>());
        return answers;
    }

    private List<Integer> initNumberList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int lastValue = -11;
        for (int num : nums) {
            if (lastValue == num) {
                continue;
            }

            list.add(num);
            lastValue = num;
        }

        return list;
    }

    private void dfs(int index, List<Integer> list) {
        if (index >= numberList.size()) {
            answers.add(listToAnswer(list));
            return;
        }

        int count = countOfNum.get(numberList.get(index));
        for (int i = 0; i <= count; i++) {
            list.add(i);
            dfs(index + 1, list);
            list.remove(index);
        }
    }

    private List<Integer> listToAnswer(List<Integer> list) {

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int count = list.get(i);
            for (int j = 0; j < count; j++) {
                answer.add(numberList.get(i));
            }
        }

        return answer;
    }

    private TreeMap<Integer, Integer> initCountOfNum(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);
        }

        return map;
    }
}
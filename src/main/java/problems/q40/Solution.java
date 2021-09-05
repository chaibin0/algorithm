package problems.q40;


import java.util.*;
import java.util.stream.Collectors;

// timeout
class Solution {

    Set<List<Integer>> answerSet = new HashSet<>();
    private List<Integer> answer;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        this.answerSet = new HashSet<>();

        this.candidates = candidates;
        this.target = target;
        this.answer = new ArrayList<>();

        int position = 0;
        int remain = Arrays.stream(this.candidates).sum();
        int currentValueSum = 0;

        Arrays.sort(candidates);

        solve(position, currentValueSum, remain);

        return answerSet.stream()
                .map(set -> set.stream().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    void solve(int position, int currentValueSum, int remain) {

        if (currentValueSum == this.target) {
            List<Integer> set = answer.stream().collect(Collectors.toList());
            answerSet.add(set);
            return;
        }

        // 전체 탐색
        if (position >= this.candidates.length) {
            return;
        }

        // 값이 넘어간 경우
        if (this.target < currentValueSum) {
            return;
        }

        // 뒤에 계산할 값을 다 더해도 원하는 값이 안나오는 경우
        if (this.target > currentValueSum + remain) {
            return;
        }

        int value = this.candidates[position];
        answer.add(value);
        solve(position + 1, currentValueSum + value, remain - value);

        answer.remove((Integer) value);
        solve(position + 1, currentValueSum, remain);
    }
}
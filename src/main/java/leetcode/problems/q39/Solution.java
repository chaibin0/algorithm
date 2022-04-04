package leetcode.problems.q39;
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]


Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500


 */


import java.util.*;

class Solution {

    private List<List<Integer>> answerList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        solve(candidates, new HashSet<>(), candidates.length, 0, target);

        return answerList;
    }

    private void solve(int[] candidates, Set<CandidatesSet> candidatesSets, int currentIndex, int currentValue, int target) {

        if (currentValue == target) {
            addAnswers(candidatesSets);
            return;
        }

        if (currentIndex == 0) {
            return;
        }

        int nextIndex = currentIndex - 1;
        // 최대 가능한 곱셈수?    target = 30   30 / 5 = 6  6 -> 5 -> 4
        int maxCandidates = (target - currentValue) / candidates[nextIndex];

        for (int i = maxCandidates; i >= 0; i--) {

            if (i == 0) {
                solve(candidates, candidatesSets, nextIndex, currentValue, target);
            } else {
                CandidatesSet candidatesSet = new CandidatesSet(candidates[nextIndex], i);
                candidatesSets.add(candidatesSet);
                solve(candidates, candidatesSets, nextIndex, currentValue + candidates[nextIndex] * i, target);
                candidatesSets.remove(candidatesSet);
            }
        }
    }

    private void addAnswers(Set<CandidatesSet> candidatesSets) {

        List<Integer> answer = new ArrayList<>();
        for (CandidatesSet candidatesSet : candidatesSets) {
            for (int i = 0; i < candidatesSet.maxCandidates; i++) {
                answer.add(candidatesSet.candidate);
            }
        }

        answerList.add(answer);
    }


    class CandidatesSet {

        int candidate;
        int maxCandidates;

        public CandidatesSet(int candidate, int maxCandidates) {
            this.candidate = candidate;
            this.maxCandidates = maxCandidates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CandidatesSet that = (CandidatesSet) o;
            return candidate == that.candidate && maxCandidates == that.maxCandidates;
        }

        @Override
        public int hashCode() {
            return Objects.hash(candidate, maxCandidates);
        }
    }
}
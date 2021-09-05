package problems.q40_2;


import java.util.*;

class Solution {

    List<Candidate> candidatesList;
    List<List<Integer>> answers;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        this.target = target;
        this.answers = new ArrayList<>();
        this.candidatesList = new ArrayList<>();

        Arrays.sort(candidates);
        int lastCandidate = -1;
        Candidate candidate = null;

        for (int c : candidates) {
            if (lastCandidate == -1 || lastCandidate != c) {
                candidate = new Candidate(c);
                lastCandidate = c;
                candidatesList.add(candidate);
                continue;
            }

            candidate.addFrequency();
        }

        solve(new TreeSet<>(), 0, 0);

        return answers;
    }

    public void solve(Set<Candidate> candidateSet, int position, int currentTotal) {

        if (currentTotal == this.target) {
            insertAnswer(candidateSet);
        }

        if (this.candidatesList.size() <= position) {
            return;
        }

        Candidate candidate = this.candidatesList.get(position);
        int value = candidate.value;
        int frequency = candidate.frequency;

        if (target - currentTotal < value) {
            return;
        }

        int possibleLength = Math.min((target - currentTotal) / value, frequency);
        for (int i = 0; i <= possibleLength; i++) {
            Candidate newCandidate = new Candidate(value, i);
            candidateSet.add(newCandidate);
            solve(candidateSet, position + 1, currentTotal + value * i);
            candidateSet.remove(newCandidate);
        }
    }

    private void insertAnswer(Set<Candidate> candidateSet) {
        List<Integer> answer = new ArrayList<>();

        for (Candidate candidate : candidateSet) {
            for (int i = 0; i < candidate.frequency; i++) {
                answer.add(candidate.value);
            }
        }

        answers.add(answer);
    }
}


class Candidate implements Comparable<Candidate> {

    int value;
    int frequency;

    public Candidate(int value) {
        this.value = value;
        this.frequency = 1;
    }

    public Candidate(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.value - o.value;
    }

    public void addFrequency() {
        this.frequency = this.frequency + 1;
    }
}
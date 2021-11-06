package problems.q60;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder answer = new StringBuilder();
        List<Integer> permutationNum = initNumber(n);
        k--;
        while (!permutationNum.isEmpty()) {
            int nextValue = factorial(n - 1);
            int numIndex = k / nextValue;
            k -= (nextValue * numIndex);
            answer.append(permutationNum.get(numIndex));
            permutationNum.remove(numIndex);
            n--;
        }

        return answer.toString();
    }

    private int factorial(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    private List<Integer> initNumber(int n) {

        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        return numList;
    }
}
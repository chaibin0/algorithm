package leetcode.problems.q1007;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int answer = Integer.MAX_VALUE;
        int length = tops.length;
        int firstTopDice = tops[0];
        int firstBottomDice = bottoms[0];

        int topChange = 0;
        int bottomChange = 0;
        int sameFirstDice = 0;
        int sameBottomDice = 0;

        boolean canTopDomino = true;
        boolean canBottomDomino = true;
        for (int i = 1; i < length; i++) {


            if (canTopDomino && firstTopDice != tops[i] && firstTopDice != bottoms[i]) {
                canTopDomino = false;
            }

            if (canBottomDomino && firstBottomDice != bottoms[i] && firstBottomDice != tops[i]) {
                canBottomDomino = false;
            }


            if (canTopDomino &&
                    firstTopDice != tops[i] &&
                    firstTopDice == bottoms[i]) {
                topChange++;
            }

            if (firstTopDice == tops[i] && firstTopDice == bottoms[i]) {
                sameFirstDice++;
            }

            if (canBottomDomino &&
                    firstBottomDice != bottoms[i] &&
                    firstBottomDice == tops[i]) {
                bottomChange++;
            }

            if (firstBottomDice == tops[i] && firstBottomDice == bottoms[i]) {
                sameBottomDice++;
            }
        }

        if (!canTopDomino && !canBottomDomino) {
            return -1;
        }

        if (canTopDomino) {
            answer = Math.min(topChange, length - topChange - sameFirstDice);
        }

        if (canBottomDomino) {
            answer = Math.min(answer, Math.min(bottomChange, length - bottomChange - sameBottomDice));
        }

        return answer;
    }
}

package leetcode.problems.q307;


// 1 3 5
// 1 4 8

class NumArray {

    private static final int CHUNK_SIZE = 100;
    private int[][] sumDp;
    private int[] nums;

    public NumArray(int[] nums) {
        int chunk = nums.length / CHUNK_SIZE + 1;
        this.sumDp = new int[chunk][CHUNK_SIZE + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            sumDp[i / CHUNK_SIZE][i % CHUNK_SIZE + 1] = sumDp[i / CHUNK_SIZE][i % CHUNK_SIZE] + nums[i];
        }
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        int difference = val - nums[index];
        int currentChunk = index / CHUNK_SIZE;
        int lastChunk = nums.length / CHUNK_SIZE;

        int length = currentChunk == lastChunk ? nums.length % CHUNK_SIZE + 1 : CHUNK_SIZE;

        for (int i = index % CHUNK_SIZE; i < length; i++) {
            sumDp[currentChunk][i + 1] = sumDp[currentChunk][i + 1] + difference;
        }
    }

    public int sumRange(int left, int right) {
        int leftChunk = left / CHUNK_SIZE;
        int rightChunk = right / CHUNK_SIZE;
        for (int i = 1; i <= nums.length; i++) {
            System.out.print(sumDp[0][i] + " ");
        }
        System.out.println();
        if (leftChunk == rightChunk) {
            return sumDp[rightChunk][right % CHUNK_SIZE + 1] - sumDp[leftChunk][left % CHUNK_SIZE];
        }

        int answer = 0;
        for (int i = leftChunk; i <= rightChunk; i++) {
            if (i == leftChunk) {
                answer += (sumDp[leftChunk][CHUNK_SIZE] - sumDp[leftChunk][left % CHUNK_SIZE]);
            } else if (i == rightChunk) {
                answer += sumDp[rightChunk][right % CHUNK_SIZE + 1];
            } else {
                answer += (sumDp[i][CHUNK_SIZE] - sumDp[i][0]);
            }
        }

        return answer;
    }
}
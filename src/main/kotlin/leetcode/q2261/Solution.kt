package leetcode.q2261

class Solution {

    val rootNode = TreeNode(0)
    var answer = 0

    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {

        var initK = 0

        for (i in 0 until nums.size) {

            if (nums[i] % p == 0) {
                initK++
            }

            var currentK = initK
            val size = (nums.size - i)

            for (j in 0 until size) {
                if (currentK <= k) {
                    dfs(j, i + j, nums)
                }

                if (nums[j] % p == 0) {
                    currentK--
                }

                val nextIndex = i + j + 1
                if (nextIndex < nums.size && nums[nextIndex] % p == 0) {
                    currentK++
                }
            }
        }

        return answer
    }

    fun dfs(start: Int, end: Int, nums: IntArray) {

        var currentNode = rootNode

        for (i in start..end) {

            if (!currentNode.leaf.containsKey(nums[i])) {
                currentNode.leaf[nums[i]] = TreeNode(nums[i])
            }

            currentNode = currentNode.leaf[nums[i]]!!
        }

        if (!currentNode.isSubArray) {
            answer++
            currentNode.isSubArray = true
        }
    }
}

data class TreeNode(
    var `val`: Int
) {
    var isSubArray = false
    var leaf: MutableMap<Int, TreeNode> = mutableMapOf()
}
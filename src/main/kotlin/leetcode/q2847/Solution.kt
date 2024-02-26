package leetcode.q2847

class Solution {
    fun smallestNumber(n: Long): String {
        val sb = StringBuilder()

        var current = n
        while(current > 1){

            val temp = current

            for(i in 9 downTo  2){

                if(current == 1L){
                    break
                }

                if(current % i == 0L){
                    sb.append(i)
                    current /= i;
                    break
                }
            }

            if(temp == current){
                break;
            }
        }

        if(current > 9){
            return "-1"
        }

        if(sb.isEmpty()){
            return n.toString()
        }

        return sb.reverse().toString()
    }
}
package leetcode.q1826

class Solution {
    fun badSensor(sensor1: IntArray, sensor2: IntArray): Int {

        val length = sensor1.size - 1

        var i = 0
        while (i < length) {
            if (sensor1[i] != sensor2[i]) {
                break
            }
            i++
        }

        if (i == length) {
            return -1
        }

        var position = i
        var leftFault = false
        var rightFault = false

        while (position < length) {
            if (!rightFault && sensor1[position] != sensor2[position + 1]) {
                rightFault = true
            }

            if (!leftFault && sensor1[position + 1] != sensor2[position]) {
                leftFault = true
            }
            position++
        }


        if (leftFault == rightFault) {
            return -1
        }

        return if(leftFault) 1 else 2
    }
}
package leetcode.q2074


class Solution {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        var answerPosition = head

        var need = 2
        var count = 0
        var current = head?.next

        var deque = ArrayDeque<ListNode>()

        while (current != null) {

            if (need == count) {
                if (count % 2 == 0) {
                    while (deque.isNotEmpty()) {
                        answerPosition?.next = deque.removeLast()
                        answerPosition = answerPosition?.next
                    }
                } else {
                    while (deque.isNotEmpty()) {
                        answerPosition?.next = deque.removeFirst()
                        answerPosition = answerPosition?.next
                    }
                }

                deque = ArrayDeque()
                need++
                count = 0
                continue
            }

            deque.addLast(current)
            count++
            current = current.next
        }

        if (count % 2 == 0) {
            while (deque.isNotEmpty()) {
                answerPosition?.next = deque.removeLast()
                answerPosition = answerPosition?.next
            }
        } else {
            while (deque.isNotEmpty()) {
                answerPosition?.next = deque.removeFirst()
                answerPosition = answerPosition?.next
            }
        }

        answerPosition?.next = null
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
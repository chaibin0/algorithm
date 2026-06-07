package leetcode.q281

class ZigzagIterator {

    var queue: ArrayDeque<Zigzag> = ArrayDeque()

    constructor(v1: IntArray, v2: IntArray) {
        val zigzag1 = Zigzag(v1)
        val zigzag2 = Zigzag(v2)

        if (!zigzag1.isLast()) {
            queue.addLast(zigzag1)
        }
        if (!zigzag2.isLast()) {
            queue.addLast(Zigzag(v2))
        }
    }

    fun next(): Int {
        val zigzag = queue.removeFirst()
        val value = zigzag.next()
        if (!zigzag.isLast()) {
            queue.addLast(zigzag)
        }

        return value
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }
}

class Zigzag(private var v1: IntArray) {

    private var pointer: Int = 0

    fun next(): Int {
        val value = v1[pointer]
        pointer++
        return value
    }

    fun isLast() = v1.size == pointer
}
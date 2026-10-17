package leetcode.q1146

class SnapshotArray(val length: Int) {

    val snap = mutableListOf<IntArray>()
    var currentArray = IntArray(length)

    fun set(index: Int, `val`: Int) {
        currentArray[index] = `val`
    }

    fun snap(): Int {
        val size = snap.size
        snap.add(currentArray.copyOf())
        return size
    }

    fun get(index: Int, snap_id: Int): Int {
        return snap[snap_id][index]
    }
}

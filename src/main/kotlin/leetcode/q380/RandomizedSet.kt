package leetcode.q380

class RandomizedSet() {

    private val arr: MutableSet<Int> = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return arr.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return arr.remove(`val`)
    }

    fun getRandom(): Int {
        return arr.random()
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
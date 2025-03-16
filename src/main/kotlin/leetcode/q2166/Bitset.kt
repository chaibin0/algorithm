package leetcode.q2166

class Bitset(val size: Int) {
    private val bitArray = BooleanArray(size)
    private var cacheAll = false
    private var cacheAllValue = false
    private var cacheAny = false
    private var cacheAnyValue = false
    private var cacheCount = false
    private var cacheCountValue = 0
    private var cacheToString = false
    private var cacheToStringValue = ""

    fun fix(idx: Int) {
        bitArray[idx] = true
        cacheAll = false
        cacheAny = false
        cacheCount = false
        cacheToString = false
    }

    fun unfix(idx: Int) {
        bitArray[idx] = false
        cacheAll = false
        cacheAny = false
        cacheCount = false
        cacheToString = false
    }

    fun flip() {
        for (i in bitArray.indices) bitArray[i] = bitArray[i] xor true
        cacheAll = false
        cacheAny = false
        cacheCount = false
        cacheToString = false
    }

    fun all(): Boolean {

        if (cacheAll) {
            return cacheAllValue
        }

        cacheAllValue = bitArray.all { it }
        cacheAll = true
        return cacheAllValue
    }

    fun one(): Boolean {
        if (cacheAny) {
            return cacheAnyValue
        }

        cacheAnyValue = bitArray.any { it }
        cacheAny = true
        return cacheAnyValue
    }

    fun count(): Int {
        if (cacheCount) {
            return cacheCountValue
        }

        cacheCountValue = bitArray.count { it }
        cacheCount = true
        return cacheCountValue
    }

    override fun toString(): String {

        if (cacheToString) {
            return cacheToStringValue
        }

        val sb = StringBuilder()
        for (bit in bitArray) {
            sb.append(if (bit) '1' else '0')
        }

        cacheToStringValue = sb.toString()
        cacheToString = true
        return cacheToStringValue
    }

}
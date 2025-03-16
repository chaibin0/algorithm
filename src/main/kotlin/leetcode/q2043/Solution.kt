package leetcode.q2043

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class Bank(balance: LongArray) {
    private val bank: ConcurrentMap<Int, Long> = ConcurrentHashMap()

    init {
        for ((index, value) in balance.withIndex()) {
            bank[index + 1] = value
        }
    }

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        val currentAccount1Money = bank[account1] ?: return false
        val currentAccount2Money = bank[account2] ?: return false
        if (currentAccount1Money < money) {
            return false
        }

        if (account1 == account2) {
            return true
        }

        bank[account1] = currentAccount1Money - money
        bank[account2] = currentAccount2Money + money
        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        val currentAccount1Money = bank[account] ?: return false
        bank[account] = currentAccount1Money + money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        val currentAccount1Money = bank[account] ?: return false
        if (currentAccount1Money < money) {
            return false
        }

        bank[account] = currentAccount1Money - money
        return true
    }
}
package cses_fi.task2216

import java.util.*

object DummySolution {
    @JvmStatic
    fun numberOfRounds(nums: IntArray): Int {
        val n = nums.size
        if (n <= 1) return n;

        val pq = PriorityQueue(nums.asList())
        val used = BitSet(n)
        var ans = 0
        var i = 0
        while (!pq.isEmpty()) {
            if (i == 0) ans++
            if (!used[i] && pq.peek() == nums[i]) {
                used[i] = true
                pq.poll()
            }
            if (++i == n) i = 0
        }
        return ans
    }
}

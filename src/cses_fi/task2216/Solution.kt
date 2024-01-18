package cses_fi.task2216

import kotlin.math.max

object Solution {
    @JvmStatic
    fun numberOfRounds(arr: IntArray): Int {
        val n = arr.size
        if (n <= 1) return n

        val indices = arr.indices.sortedBy { arr[it] }

        var lastPickIndex = -1
        var i = 0
        var ans = 1
        while (i < n) {
            val curr = arr[indices[i]]
            var max1 = -1
            var max2 = -1
            while (i < n && arr[indices[i]] == curr) {
                val idx = indices[i++]
                if (idx < lastPickIndex) max1 = max(max1, idx)
                else max2 = max(max2, idx)
            }
            if (max1 != -1) {
                ans++
                lastPickIndex = max1
            } else lastPickIndex = max2
        }
        return ans
    }
}

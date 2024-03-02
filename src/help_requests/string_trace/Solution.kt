package help_requests.string_trace

import java.util.*

fun solve(arr: IntArray): IntArray {
    val n = arr.size
    val cnt = HashMap<Int, Deque<Int>>()
    var unused = 1

    val ans = IntArray(n)
    for (i in 0 until n) {
        if (arr[i] != 0) {
            val queue = cnt[arr[i]]!!
            ans[i] = queue.pollFirst()
            if (queue.isEmpty()) cnt.remove(arr[i])
        } else {
            ans[i] = unused++
        }
        cnt.computeIfAbsent(arr[i] + 1) { ArrayDeque() }.offerLast(ans[i])
    }
    return ans
}
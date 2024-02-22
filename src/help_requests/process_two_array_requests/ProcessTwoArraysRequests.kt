package help_requests.process_two_array_requests

class ProcessTwoArraysRequests {
    companion object {
        fun dummy(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray =
            queries.map { (p, q) ->
                val n = a.size
                var ans = 0L
                for (i in 0 until n) {
                    for (j in i + 1 until n) {
                        if (a[i] + a[j] == p && b[i] + b[j] == q) ans++
                    }
                }
                ans
            }.toLongArray()

        fun usingHashMap(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray {
            val pairMap = a.indices.map { a[it] to b[it] }.groupingBy { it }.eachCount()
            return queries.map { (p, q) ->
                var ans = 0L
                for ((pair1, c1) in pairMap.entries) {
                    val pair2 = p - pair1.first to q - pair1.second
                    val c2 = pairMap.getOrDefault(pair2, 0)
                    if (pair1 == pair2) ans += c1 * (c1 - 1L)
                    else ans += c1 * c2
                }
                ans / 2
            }.toLongArray()
        }

        //only for distinct
        fun sortAndTwoPointersDistinct(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray {
            val c = a.indices.map { a[it] to b[it] }.sortedBy { it.first }
            return queries.map { (p, q) ->
                var (ans, i, j) = Triple(0L, 0, c.size - 1)
                while (i < j) {
                    if (c[i].first + c[j].first == p && c[i].second + c[j].second == q) {
                        ans++
                        i++
                        j--
                    } else if (c[i].first + c[j].first <= p) i++
                    else j--
                }
                ans
            }.toLongArray()
        }

        fun sortAndTwoPointersDuplicates(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray {
            val c = a.indices.map { a[it] to b[it] }
                .groupingBy { it }.eachCount()
                .toList().map { Triple(it.first.first, it.first.second, it.second.toLong()) }
                .sortedWith { x, y ->
                    if (x.first != y.first) x.first.compareTo(y.first)
                    else x.second.compareTo(y.second)
                }
            return queries.map { (p, q) ->
                var (ans, i, j) = Triple(0L, 0, c.size - 1)
                while (i <= j) {
                    if (c[i].first + c[j].first == p && c[i].second + c[j].second == q) {
                        if (i == j) ans += c[i].third * (c[i].third - 1) / 2
                        else ans += c[i].third * c[j].third
                        i++
                        j--
                    } else if (c[i].first + c[j].first < p) i++
                    else if (c[i].first + c[j].first > p) j--
                    else if (c[i].second + c[j].second <= q) i++
                    else j--
                }
                ans
            }.toLongArray()
        }

        fun countPairs(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray {
            val count = queries.associateWithTo(HashMap()) { 0L }
            val n = a.size
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    val key = a[i] + a[j] to b[i] + b[j]
                    if (key in count) count[key] = count[key]!! + 1
                }
            }
            return queries.map { count[it]!! }.toLongArray()
        }

        fun distinctCardinality(a: IntArray, b: IntArray, queries: Array<Pair<Int, Int>>): LongArray {
            val c = a.indices.map { a[it] to b[it] }.groupingBy { it }.eachCount()
                .toList().map { Triple(it.first.first, it.first.second, it.second.toLong()) }
            val count = queries.associateWithTo(HashMap()) { 0L }
            val k = c.size
            for (i in 0 until k) {
                for (j in i until k) {
                    val key = c[i].first + c[j].first to c[i].second + c[j].second
                    if (key in count) {
                        if (i == j) count[key] = count[key]!! + c[i].third * (c[i].third - 1) / 2
                        else count[key] = count[key]!! + c[i].third * c[j].third
                    }
                }
            }
            return queries.map { count[it]!! }.toLongArray()
        }
    }
}
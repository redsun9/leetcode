package help_requests.string_trace

import org.junit.jupiter.api.Test
import stress.StressTester
import kotlin.random.Random

class SolutionTest {
    @Test
    fun solve() {
        StressTester.constructionStressTest(
            ::generate,
            ::solve,
            ::verify,
            1_000_000,
            1,
            100_000
        )
    }
}

private fun generate(seed: Long, n: Int = 100): IntArray {
    val rnd = Random(seed)
    val cnt = IntArray(n)
    var uniq = 0
    val arr = IntArray(n)
    for (i in 0 until n) {
        val a = rnd.nextInt(uniq + 1)
        if (a == uniq) uniq++
        arr[i] = cnt[a]++
    }
    return arr
}

private fun verify(input: IntArray, actual: IntArray): Boolean {
    val cnt = HashMap<Int, Int>()
    val n = input.size
    if (actual.size != n) return false
    for (i in 0 until n) {
        val a = cnt.getOrDefault(actual[i], 0)
        if (input[i] != a) return false
        cnt[actual[i]] = a + 1
    }
    return true
}

fun main(args: Array<String>) {
    for (i in 0 until 5) {
        val test = generate(i.toLong(), 10)
        val solution = solve(test)
        println("${test.contentToString()} => ${solution.contentToString()}")
    }
}

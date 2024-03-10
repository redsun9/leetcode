package help_requests.max_element_after_deletions

import org.junit.jupiter.api.Test
import stress.StressTester
import java.util.*

class SolutionKtTest {
    private val n = 200
    private val m = 100

    @Test
    fun test() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { (a, s) -> solve(a, s) },
            { (a, s) -> dummySolution(a, s) },
            1_000_000,
            1,
            100_000
        )
    }

    private fun generate(seed: Long): Pair<IntArray, String> {
        val random = Random(seed)
        val a = IntArray(n) { random.nextInt(1_000_000_000) }
        val s = String(CharArray(m) { if (random.nextBoolean()) 'L' else 'R' })
        return a to s
    }
}
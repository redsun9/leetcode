package help_requests.differ_in_one_position

import org.junit.jupiter.api.Test
import stress.StressTester
import kotlin.random.Random

private const val n = 1000
private const val MAX_VAL = 10

class SolutionKtTest {

    @Test
    fun numberOfPairs() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { arr -> dummySolution(arr) },
            { arr -> numberOfPairs(arr) },
            1_000,
            1,
            100
        )
    }

    private fun generate(seed: Long, random: Random = Random(seed)): Array<Pair<Int, Int>> =
        Array(n) { random.nextInt(MAX_VAL) to random.nextInt(MAX_VAL) }
}
@file:Suppress("DuplicatedCode")

package help_requests.process_two_array_requests

import org.junit.jupiter.api.Test
import stress.StressTester
import kotlin.random.Random

class ProcessTwoArraysRequestsTest {
    private val n = 100
    private val m = 100
    private val minVal = 1
    private val maxVal = 10
    private val minSumVal = 2
    private val maxSumVal = 20

    @Test
    fun checkUsingHashMap() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { test -> ProcessTwoArraysRequests.dummy(test.first, test.second, test.third) },
            { test -> ProcessTwoArraysRequests.usingHashMap(test.first, test.second, test.third) },
            10_000,
            1,
            1_000
        )
    }

    @Test
    fun checkSortAndTwoPointersDistinct() {
        StressTester.exactStressTest(
            { seed -> generateUnique(seed) },
            { test -> ProcessTwoArraysRequests.usingHashMap(test.first, test.second, test.third) },
            { test -> ProcessTwoArraysRequests.sortAndTwoPointersDistinct(test.first, test.second, test.third) },
            10_000,
            1,
            1_000
        )
    }

    @Test
    fun checkSortAndTwoPointersDuplicates() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { test -> ProcessTwoArraysRequests.usingHashMap(test.first, test.second, test.third) },
            { test -> ProcessTwoArraysRequests.sortAndTwoPointersDuplicates(test.first, test.second, test.third) },
            10_000,
            1,
            1_000
        )
    }

    @Test
    fun checkCountPairs() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { test -> ProcessTwoArraysRequests.usingHashMap(test.first, test.second, test.third) },
            { test -> ProcessTwoArraysRequests.countPairs(test.first, test.second, test.third) },
            10_000,
            1,
            1_000
        )
    }

    @Test
    fun checkDistinctCardinality() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { test -> ProcessTwoArraysRequests.usingHashMap(test.first, test.second, test.third) },
            { test -> ProcessTwoArraysRequests.distinctCardinality(test.first, test.second, test.third) },
            10_000,
            1,
            1_000
        )
    }


    private fun generate(seed: Long) = Random(seed).let { random ->
        Triple(
            IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) },
            IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) },
            Array(m) {
                Pair(
                    minSumVal + random.nextInt(maxSumVal - minSumVal + 1),
                    minSumVal + random.nextInt(maxSumVal - minSumVal + 1)
                )
            }
        )
    }

    private fun generateUnique(seed: Long) = Random(seed).let { random ->
        Triple(
            IntRange(1, n).shuffled(random).toIntArray(),
            IntRange(1, n).shuffled(random).toIntArray(),
            Array(m) {
                Pair(
                    2 + random.nextInt(2 * (n - 1)),
                    2 + random.nextInt(2 * (n - 1))
                )
            }
        )
    }
}
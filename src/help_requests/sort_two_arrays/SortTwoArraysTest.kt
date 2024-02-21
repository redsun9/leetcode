package help_requests.sort_two_arrays

import help_requests.sort_two_arrays.SortTwoArrays.Companion.canSort
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stress.StressTester
import kotlin.random.Random

class SortTwoArraysTest {

    @Test
    fun canSort() {
        StressTester.exactStressTest(
            { seed -> generate(seed) },
            { (a, b) -> true },
            { (a, b) -> canSort(a, b) },
            1_000_000,
            1,
            100_000
        )
    }

    @Test
    fun verifyBroken1() {
        val a = Int.MIN_VALUE // -2147483648
        val b = Int.MAX_VALUE // 2147483647
        assertFalse(SortTwoArrays.broken1(intArrayOf(a, b), intArrayOf(0, 1)))
    }

    @Test
    fun findSeedForBroken2() {
        StressTester.exactStressTest(
            { seed -> generateRandom(seed, n = 32, minVal = 1, maxVal = 5) },
            { (a, b) -> true },
            { (a, b) -> doesntThrow { SortTwoArrays.broken2(a, b) } },
            1_000_000,
            1,
            100_000
        )
    }

    @Test
    fun verifyBroken2() {
        val seed = 9024654201992055039L
        val (a, b) = generateRandom(seed, n = 32, minVal = 1, maxVal = 5)
        println("${a.contentToString()}, ${b.contentToString()}")
        assertThrows(IllegalArgumentException::class.java) { SortTwoArrays.broken2(a, b) }
    }

    @Test
    fun verifyBroken3() {
        val seed = 9024654201992055039L
        val (a, b) = generateRandom(seed, n = 32, minVal = 1, maxVal = 5)
        println("${a.contentToString()}, ${b.contentToString()}")
        assertThrows(IllegalArgumentException::class.java) { SortTwoArrays.broken3(a, b) }
    }

    @Test
    fun testNegative() {
        assertFalse(canSort(intArrayOf(1, 2), intArrayOf(2, 1)))
    }

    fun generate(seed: Long, n: Int = 1000, minVal: Int = 0, maxVal: Int = 100): Pair<IntArray, IntArray> =
        Random(seed).let { random ->
            IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) }.sorted().zip(
                IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) }.sorted()
            ).shuffled(random).let {
                it.map { it.first }.toIntArray() to it.map { it.second }.toIntArray()
            }
        }

    fun generateRandom(seed: Long, n: Int = 1000, minVal: Int = 0, maxVal: Int = 100): Pair<IntArray, IntArray> =
        Random(seed).let { random ->
            IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) } to IntArray(n) { minVal + random.nextInt(maxVal - minVal + 1) }
        }

    private fun doesntThrow(executable: () -> Any): Boolean = kotlin.runCatching { executable() }.isFailure
}

fun main() {
    val s = SortTwoArraysTest()
    var neededTrue = 3
    for (i in 0 until 1000000) {
        val (a, b) = s.generateRandom(seed = i.toLong(), n = 10, 1, 9)
        val result = canSort(a, b)
        if (result && neededTrue-- > 0) {
            println("${a.contentToString()}, ${b.contentToString()} => $result")
        }
    }
}
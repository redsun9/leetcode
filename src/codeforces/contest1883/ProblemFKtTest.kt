package codeforces.contest1883

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProblemFKtTest {

    @Test
    fun test1() {
        assertEquals(28, solve(intArrayOf(1, 7, 7, 2, 3, 4, 3, 2, 1, 100)))
        assertEquals(28, solve2(intArrayOf(1, 7, 7, 2, 3, 4, 3, 2, 1, 100)))
    }
}
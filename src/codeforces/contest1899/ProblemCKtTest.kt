package codeforces.contest1899

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProblemCKtTest {
    @Test
    fun test() {
        assertEquals(15, solve(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(17, solve(intArrayOf(9, 9, 8, 8)))
        assertEquals(8, solve(intArrayOf(-1, 4, -1, 0, 5, -4)))
        assertEquals(4, solve(intArrayOf(-1, 2, 4, -3)))
        assertEquals(-1000, solve(intArrayOf(-1000)))
        assertEquals(101, solve(intArrayOf(101, -99, 101)))
        assertEquals(10, solve(intArrayOf(-10, 5, -8, 10, 6, -10, 7, 9, -2, -6, 7, 2, -4, 6, -1, 7, -6, -7, 4, 1)))
    }
}
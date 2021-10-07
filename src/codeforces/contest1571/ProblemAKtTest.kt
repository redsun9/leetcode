package codeforces.contest1571

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProblemAKtTest {

    @Test
    fun test1() {
        assertEquals(">", solve(">>>"))
    }

    @Test
    fun test2() {
        assertEquals("?", solve("<><=<"))
    }

    @Test
    fun test3() {
        assertEquals("=", solve("="))
    }

    @Test
    fun test4() {
        assertEquals("<", solve("<<=="))
    }
}
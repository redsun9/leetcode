package help_requests.spearman

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class KotlinSolutionKtTest {

    @Test
    fun spearmanUnique() {
        val xs = doubleArrayOf(106.0, 100.0, 86.0, 101.0, 99.0, 103.0, 97.0, 113.0, 112.0, 110.0)
        val ys = doubleArrayOf(7.0, 27.0, 2.0, 50.0, 28.0, 29.0, 20.0, 12.0, 6.0, 17.0)
        assertEquals(-0.175757575, spearmanUnique(xs, ys), 1e-9)
    }

    @Test
    fun spearmanNonUnique() {
        val xs = arrayOf(106.0, 100.0, 86.0, 101.0, 99.0, 103.0, 97.0, 113.0, 112.0, 110.0)
        val ys = arrayOf(7.0, 27.0, 2.0, 50.0, 28.0, 29.0, 20.0, 12.0, 6.0, 17.0)
        assertEquals(-0.175757575, spearmanNonUnique(xs, ys), 1e-9)
    }
}
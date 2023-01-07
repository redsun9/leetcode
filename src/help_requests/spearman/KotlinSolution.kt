package help_requests.spearman

import kotlin.math.pow

fun spearmanUnique(xs: DoubleArray, ys: DoubleArray): Double {
    val n = xs.size
    val sum = xs.ranksOfUniqueValues().zip(ys.ranksOfUniqueValues()).sumOf { (it.first - it.second).toDouble().pow(2) }
    return 1.0 - 6.0 * sum / n / (n.toLong() * n - 1)
}

fun <A : Comparable<A>, B : Comparable<B>> spearmanNonUnique(xs: Array<A>, ys: Array<B>): Double {
    if (xs.size != ys.size || xs.size < 2) throw IllegalArgumentException();
    val n = xs.size
    val sum = xs.ranksOfNonUniqueValues().zip(ys.ranksOfNonUniqueValues()).sumOf { (it.first - it.second).pow(2) }
    return 1.0 - 6.0 * sum / n / (n.toLong() * n - 1)
}


private fun DoubleArray.ranksOfUniqueValues() = this.withIndex()
    .sortedBy { it.value }
    .mapIndexed { rank, indexedValue -> Pair(indexedValue.index, rank) }
    .sortedBy { it.first }
    .map { it.second }

private fun <T : Comparable<T>> Array<T>.ranksOfNonUniqueValues(): DoubleArray {
    val n = this.size
    val sortedValues = this.withIndex().sortedBy { it.value }

    val ranksAfterAveraging = DoubleArray(n)
    var left = 0
    while (left < n) {
        val value = sortedValues[left].value
        var right = left + 1
        while (right < n && value.compareTo(sortedValues[right].value) == 0) right++
        val averageRank = left + (right - left - 1.0).div(2.0)
        for (i in left until right) ranksAfterAveraging[sortedValues[i].index] = averageRank
        left = right
    }
    return ranksAfterAveraging
}
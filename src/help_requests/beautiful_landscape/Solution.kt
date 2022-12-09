package help_requests.beautiful_landscape


// Content with the amount of tree cover available, еhe Elves just need to know the best spot to build
// their tree house: they would like to be able to see a lot of trees.
//
// To measure the viewing distance from a given tree, look up, down, left, and right from that tree;
// stop if you reach an edge or at the first tree that is the same height or taller than the tree under
// consideration. (If a tree is right on the edge, at least one of its viewing distances will be zero.)
//
// The Elves don't care about distant trees taller than those found by the rules above; the proposed tree
// house has large eaves to keep it dry, so they wouldn't be able to see higher than the tree house anyway.
fun bestPlace1(heights: Array<IntArray>): Triple<Int, Int, Long> {
    return bestPlace(heights, IntArray::canSeeArray2) { vl, vr, vd, vu -> 1L * vl * vr * vd * vu }
}

// We see only trees that is higher than all previous
fun bestPlace2(heights: Array<IntArray>): Triple<Int, Int, Long> {
    return bestPlace(heights, IntArray::canSeeArray1) { vl, vr, vd, vu -> 1L * vl * vr * vd * vu }
}

private fun bestPlace(
    heights: Array<IntArray>,
    f: (arr: IntArray) -> IntArray,
    g: (l: Int, r: Int, u: Int, d: Int) -> Long
): Triple<Int, Int, Long> {
    val transposed = heights.transposed()
    val l = heights.map { f.invoke(it) }.toTypedArray()
    val r = heights.map { f.invoke(it.reversedArray()).reversedArray() }.toTypedArray()
    val u = transposed.map { f.invoke(it) }.transposed()
    val d = transposed.map { f.invoke(it.reversedArray()).reversed() }.transposed()
    return getMax(l, r, u, d, g)
}

private fun IntArray.canSeeArray1(): IntArray {
    val ans = IntArray(this.size)
    for (i in 1..this.lastIndex) {
        var canSee = 1
        while (canSee != i && this[i] > this[i - canSee]) canSee += ans[i - canSee]
        ans[i] = canSee
    }
    return ans
}

private fun IntArray.canSeeArray2(): IntArray {
    val ans = IntArray(this.size)
    val stack = ArrayDeque<Int>()
    for (i in this.indices) {
        ans[i] = stack.size
        while (stack.isNotEmpty() && stack.last() <= this[i]) stack.removeLast()
        stack.addLast(this[i])
    }
    return ans
}

private fun getMax(
    l: Array<IntArray>, r: Array<IntArray>, u: Array<IntArray>, d: Array<IntArray>,
    f: (l: Int, r: Int, u: Int, d: Int) -> Long
): Triple<Int, Int, Long> {
    return IntRange(0, l.size - 1).flatMap { i ->
        IntRange(0, l[0].size - 1).map { j ->
            Triple(i, j, f(l[i][j], r[i][j], u[i][j], d[i][j]))
        }
    }.maxBy { it.third }
}

fun Array<IntArray>.transposed() = Array(this[0].size) { i -> IntArray(size) { j -> this[j][i] } }
fun Array<List<Int>>.transposed() = Array(this[0].size) { i -> IntArray(size) { j -> this[j][i] } }
fun List<IntArray>.transposed() = Array(this[0].size) { i -> IntArray(size) { j -> this[j][i] } }

@JvmName("anotherNameToAvoidPlatfromDeclarationClash")
fun List<List<Int>>.transposed() = Array(this[0].size) { i -> IntArray(size) { j -> this[j][i] } }

package help_requests.differ_in_one_position

// number of pairs i<j such that arr[i] and arr[j] differs in exactly one element
fun numberOfPairs(arr: Array<Pair<Int, Int>>): Long {
    val counterByFirst = arr.groupingBy { it.first }.eachCount().values
    val countBySecond = arr.groupingBy { it.second }.eachCount().values
    val countByBoth = arr.groupingBy { it }.eachCount().values

    return counterByFirst.sumOf { it * (it - 1L) / 2 } +
            countBySecond.sumOf { it * (it - 1L) / 2 } -
            2 * countByBoth.sumOf { it * (it - 1L) / 2 }
}

fun dummySolution(arr: Array<Pair<Int, Int>>): Long {
    var ans = 0L
    for ((i, a) in arr.withIndex()) {
        for ((j, b) in arr.withIndex()) {
            if (i < j && ((a.first == b.first).xor(a.second == b.second))) ans++
        }
    }
    return ans
}
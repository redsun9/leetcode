@file:Suppress("DuplicatedCode")

package help_requests.max_element_after_deletions

import kotlin.math.max


// Вам задан массив чисел a и строка команд s.
// Каждая команда — это либо символ 'L', либо символ 'R'.
//
// Обработайте все команды в порядке их записи в строке s
// Обработка команды производится следующим образом:
//
// сначала выведите максимальный элемент среди всех элементов массива a
// затем, если команда равна 'L', то удалите из массива a крайний левый элемент,
// если команда равна 'R', то удалите из массива a крайний правый элемент.

fun solve(arr: IntArray, s: String): IntArray {
    val n = arr.size
    val m = s.length
    var left = s.count { it == 'L' }
    var right = n - 1 - s.count { it == 'R' }
    var curr = IntRange(left, right).fold(Int.MIN_VALUE) { tmp, idx -> max(tmp, arr[idx]) }
    val ans = IntArray(m)
    for (i in m - 1 downTo 0) {
        curr = if (s[i] == 'L') maxOf(curr, arr[--left]) else maxOf(curr, arr[++right])
        ans[i] = curr
    }
    return ans
}


fun dummySolution(arr: IntArray, s: String): IntArray {
    var (l, r) = 0 to arr.size - 1
    return s.map {
        if (it == 'L') arr.slice(IntRange(l++, r)).max()
        else arr.slice(IntRange(l, r--)).max()
    }.toIntArray()
}
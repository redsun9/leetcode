package help_requests.unusual_template

// https://codeforces.com/contest/1922/problem/A
// follow up for it
class Solution {
    companion object {
        fun solve2(a: String, b: String, c: String) = a.indices.any { i -> a[i] != c[i] && b[i] != c[i] }

        fun solve3(a: String, b: String, c: String, d: String): Boolean {
            if (a.indices.any { i -> a[i] != c[i] && b[i] != c[i] && c[i] == d[i] }) return true
            val countC = a.indices.count { i -> a[i] != c[i] && b[i] != c[i] }
            val countD = a.indices.count { i -> a[i] != d[i] && b[i] != d[i] }
            val countCorD = a.indices.count { i -> a[i] != c[i] && b[i] != c[i] && a[i] != d[i] && b[i] != d[i] && c[i] != d[i] }
            val onlyC = countC - countCorD
            val onlyD = countD - countCorD
            return countC != 0 && countD != 0 && (countCorD >= 2 || onlyC != 0 || onlyD != 0)
        }
    }
}
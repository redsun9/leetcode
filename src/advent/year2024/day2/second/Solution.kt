package advent.year2024.day2.second

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.PrintStream
import java.lang.Integer.signum
import java.util.*
import kotlin.math.abs

object Solution {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        FileInputStream("src/advent/year2024/day2/second/input.txt").use { fis ->
            Scanner(fis).use { scanner ->
                FileOutputStream("src/advent/year2024/day2/second/output.txt").use { fos ->
                    PrintStream(fos).use { printer ->
                        var ans: Long = 0
                        while (scanner.hasNextLine()) {
                            val s = scanner.nextLine().trim { it <= ' ' }
                            val arr = s.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.map { it.toInt() }
                            if (isSafe(arr) || isAlmostSafe(arr)) ans++
                        }
                        printer.println(ans)
                    }
                }
            }
        }
    }

    private fun isSafe(arr: List<Int>): Boolean {
        if (arr.size <= 1) return true
        if (arr[0] == arr[1]) return false
        val signum = signum(arr[1] - arr[0])
        for (i in 1 until arr.size) {
            if (abs((arr[i] - arr[i - 1]).toDouble()) > 3 || signum(arr[i] - arr[i - 1]) != signum) return false
        }
        return true
    }

    private fun isAlmostSafe(arr: List<Int>): Boolean {
        return arr.indices.any { isSafe(arr.subList(0, it).plus(arr.subList(it + 1, arr.size))) }
    }
}

package help_requests.sort_two_arrays

import java.util.Comparator.comparingInt

class SortTwoArrays {
    companion object {
        @JvmStatic
        fun canSort(a: IntArray, b: IntArray) = a.zip(b)
            .sortedWith(
                comparingInt(Pair<Int, Int>::first)
                    .thenComparingInt(Pair<Int, Int>::second)
            )
            .windowed(2)
            .none { it[0].second > it[1].second }


        @JvmStatic
        fun broken1(arr1: IntArray, arr2: IntArray) = arr1.zip(arr2)
            .sortedWith { a, b ->
                if (a.first != b.first) a.first - b.first // incorrect integer comparison
                else a.second - b.second
            }
            .windowed(2)
            .none { it[0].second > it[1].second }

        @JvmStatic
        fun broken2(arr1: IntArray, arr2: IntArray) = arr1.zip(arr2)
            .sortedWith { a, b ->
                if (a.first < b.first || a.second < b.second) -1
                else 1
            }
            .windowed(2)
            .none { it[0].second > it[1].second }

        @JvmStatic
        fun broken3(arr1: IntArray, arr2: IntArray) = arr1.zip(arr2)
            .sortedWith { a, b ->
                if (a.first == b.first && a.second == b.second) 0
                else if (a.first < b.first || a.second < b.second) -1
                else 1
            }
            .windowed(2)
            .none { it[0].second > it[1].second }
    }
}

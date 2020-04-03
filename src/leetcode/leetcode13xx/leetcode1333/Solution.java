package leetcode.leetcode13xx.leetcode1333;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .parallel()
                .filter(arr -> arr[2] >= veganFriendly && arr[3] <= maxPrice && arr[4] <= maxDistance)
                .sorted(Comparator.comparingInt((int[] a) -> -a[1]).thenComparingInt(a -> -a[0]))
                .map(a -> a[0])
                .collect(Collectors.toList());

    }
}

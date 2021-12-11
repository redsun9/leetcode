package leetcode.leetcode20xx.leetcode2099;

import java.util.Comparator;
import java.util.stream.IntStream;

// O(NlogN)
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .mapToObj(i -> new int[]{i, nums[i]})
                .sorted(Comparator.comparingInt(arr -> arr[1]))
                .skip(nums.length - k)
                .sorted(Comparator.comparingInt(arr -> arr[0]))
                .mapToInt(arr -> arr[1])
                .toArray();

    }
}

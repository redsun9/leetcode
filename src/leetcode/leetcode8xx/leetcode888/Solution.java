package leetcode.leetcode8xx.leetcode888;

import java.util.HashSet;

public class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int diff = 0;
        for (int i : a) diff += i;
        for (int i : b) diff -= i;
        diff /= 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i : b) set.add(i);
        for (int i : a) {
            if (set.contains(i - diff)) return new int[]{i, i - diff};
        }
        return new int[]{-1, -1};
    }
}

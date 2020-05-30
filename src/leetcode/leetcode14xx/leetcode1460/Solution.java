package leetcode.leetcode14xx.leetcode1460;

import java.util.Arrays;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}

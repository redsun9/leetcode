package leetcode.leetcode13xx.leetcode1346;

import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i << 1)) return true;
            if ((i & 1) == 0 && set.contains(i >> 1)) return true;
            set.add(i);
        }
        return false;
    }
}

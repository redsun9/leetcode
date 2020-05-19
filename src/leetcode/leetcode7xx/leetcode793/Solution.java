package leetcode.leetcode7xx.leetcode793;

public class Solution {
    private static final int[] pos = {1, 6, 31, 156, 781, 3906, 19531, 97656, 488281, 2441406, 12207031, 61035156, 305175781};

    public int preimageSizeFZF(int n) {
        for (int i = pos.length - 1; i >= 0; i--) {
            if (n / pos[i] == 5) return 0;
            n %= pos[i];
        }
        return 5;
    }
}

package leetcode.leetcode6xx.leetcode600;

public class Solution {
    public int findIntegers(int num) {
        if (num <= 2) return num + 1;
        int[] fibb = new int[32];
        fibb[0] = 1;
        fibb[1] = 2;
        for (int i = 2; i < 32; i++) fibb[i] = fibb[i - 1] + fibb[i - 2];

        int ans = 0, pos = 30;
        boolean previousBit = false;
        while (pos >= 0) {
            if ((num & (1 << pos)) != 0) {
                ans += fibb[pos];
                if (previousBit) return ans;
                previousBit = true;
            } else {
                previousBit = false;
            }
            pos--;
        }
        return ans + 1;
    }
}

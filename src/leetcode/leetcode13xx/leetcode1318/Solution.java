package leetcode.leetcode13xx.leetcode1318;

public class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a & (1 << i)) >> i;
            int bitB = (b & (1 << i)) >> i;
            int bitC = (c & (1 << i)) >> i;
            if ((bitA | bitB) != bitC) {
                if (bitC == 0) ans += bitA + bitB;
                else ans += 1;
            }
        }
        return ans;
    }
}

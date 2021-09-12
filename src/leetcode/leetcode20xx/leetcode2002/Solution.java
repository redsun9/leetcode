package leetcode.leetcode20xx.leetcode2002;

public class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int fullMask = (1 << n) - 1;

        int[] len = new int[fullMask + 1];
        for (int mask1 = 0; mask1 <= fullMask; mask1++) len[mask1] = maxLen(s, mask1);

        int ans = 0;
        for (int mask1 = 1; mask1 < fullMask; mask1++) {
            if (len[mask1] == 0) continue;
            int mask2 = fullMask ^ mask1;
            for (int submask = mask2; submask != 0; submask = (submask - 1) & mask2) {
                if (len[submask] == 0) continue;
                ans = Math.max(ans, len[mask1] * len[submask]);
            }
        }
        return ans;
    }

    private static int maxLen(String s, int mask) {
        int i = 0, j = s.length() - 1;
        int ans = 0;
        while (i <= j) {
            while (i <= j && (mask >>> i & 1) == 0) i++;
            while (j >= i && (mask >>> j & 1) == 0) j--;
            if (i <= j) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans += i == j ? 1 : 2;
                    i++;
                    j--;
                } else return 0;
            }
        }
        return ans;
    }
}

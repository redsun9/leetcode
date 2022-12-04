package leetcode.leetcode24xx.leetcode2468;

public class Solution {
    private static final int[] maxN = {9, 18, 108, 207, 1107, 2105, 11105};

    public String[] splitMessage(String message, int k) {
        int n = message.length();
        if (k <= 5 || (k <= 12 && n > maxN[k - 6])) return new String[0];

        int m;
        if ((k - 5) * 9 >= n) m = (n + k - 6) / (k - 5);
        else if ((k - 6) * 9 + (k - 7) * 90 >= n) m = 9 + (n - (k - 6) * 9 + (k - 8)) / (k - 7);
        else if ((k - 7) * 9 + (k - 8) * 90 + (k - 9) * 900 >= n)
            m = 99 + (n - (k - 7) * 9 - (k - 8) * 90 + (k - 10)) / (k - 9);
        else m = 999 + (n - (k - 8) * 9 - (k - 9) * 90 - (k - 10) * 900 + (k - 12)) / (k - 11);

        int mLen = lenOfInt(m);

        String[] ans = new String[m];
        int pos = 0;
        for (int i = 1; i <= m; i++) {
            int charToPlace = k - lenOfInt(i) - mLen - 3;
            ans[i - 1] = message.substring(pos, Math.min(n, pos + charToPlace)) + "<" + i + "/" + m + ">";
            pos += charToPlace;
        }
        return ans;
    }

    private static int lenOfInt(int n) {
        return n < 10 ? 1 : n < 100 ? 2 : n < 1000 ? 3 : 4;
    }
}

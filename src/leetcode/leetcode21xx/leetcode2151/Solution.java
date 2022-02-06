package leetcode.leetcode21xx.leetcode2151;

public class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int[] goodStatements = new int[n], badStatements = new int[n];
        for (int i = 0; i < n; i++) {
            int[] statement = statements[i];
            int goodStatement = 0, badStatement = 0;
            for (int j = 0; j < n; j++) {
                switch (statement[j]) {
                    case 0 -> badStatement |= 1 << j;
                    case 1 -> goodStatement |= 1 << j;
                }
            }
            goodStatements[i] = goodStatement;
            badStatements[i] = badStatement;
        }

        int ans = 0;
        int allMask = (1 << n) - 1;
        for (int goodMask = allMask; goodMask != 0; goodMask--) {
            int badMask = allMask ^ goodMask;
            int tmpGood = 0, tmpBad = 0;
            for (int i = 0; i < n; i++) {
                if ((goodMask >> i & 1) == 1) {
                    tmpGood |= goodStatements[i];
                    tmpBad |= badStatements[i];
                }
            }
            if ((tmpGood & badMask | tmpBad & goodMask) != 0) continue;
            ans = Math.max(ans, Integer.bitCount(goodMask));
        }
        return ans;
    }
}

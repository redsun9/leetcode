package leetcode.leetcode2xx.leetcode294;

import java.util.HashMap;

//support only strings with not more than 65 consecutive '+'
public class Solution {
    public boolean canWin(String s) {
        long state = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '+') continue;
            int j = i + 1;
            while (j < n && s.charAt(j) == '+') j++;
            if (j - i >= 2) state ^= 1L << (j - i - 2);
            i = j;
        }

        return dfs(state, new HashMap<>());
    }

    private static boolean dfs(long key, HashMap<Long, Boolean> cache) {
        if (!cache.containsKey(key)) {
            boolean canWin = false;
            for (int i = 0; !canWin && i <= 63; i++) {
                if ((key >>> i & 1L) == 0) continue;
                int len = i + 2;
                for (int leftLen = 0, rightLen = len - 2; !canWin && leftLen <= rightLen; leftLen++, rightLen--) {
                    long key2 = key ^ (1L << i);
                    if (leftLen >= 2) key2 ^= 1L << (leftLen - 2);
                    if (rightLen >= 2) key2 ^= 1L << (rightLen - 2);
                    if (!dfs(key2, cache)) canWin = true;
                }
            }
            cache.put(key, canWin);
            return canWin;
        } else return cache.get(key);
    }
}

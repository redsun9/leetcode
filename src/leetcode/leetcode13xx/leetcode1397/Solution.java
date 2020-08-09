package leetcode.leetcode13xx.leetcode1397;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    private static final int p = 1_000_000_007;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        return dfs(
                0, 0, n, evil.length(),
                true, true,
                s1.toCharArray(), s2.toCharArray(), evil.toCharArray(),
                kmp(evil), new HashMap<>()
        );
    }

    private static int[] kmp(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = ans[j - 1];
            if (s.charAt(i) == s.charAt(j)) ans[i] = ++j;
        }
        return ans;
    }

    private static int dfs(
            int curLength, int curEvilLen,
            int n, int evilLen,
            boolean touchBottom, boolean touchTop,
            char[] s1, char[] s2, char[] evil,
            int[] kmp, HashMap<Key, Integer> cache
    ) {
        if (curEvilLen == evilLen) return 0;
        if (curLength == n) return 1;
        Key key = new Key(curLength, curEvilLen, touchBottom, touchTop);
        if (cache.containsKey(key)) return cache.get(key);
        char startChar = touchBottom ? s1[curLength] : 'a';
        char endChar = touchTop ? s2[curLength] : 'z';
        int ans = 0;
        for (char c = startChar; c <= endChar; c++) {
            boolean nextTouchBottom = touchBottom && c == s1[curLength];
            boolean nextTouchTop = touchTop && c == s2[curLength];
            int nextEvilLen = curEvilLen;
            while (nextEvilLen > 0 && c != evil[nextEvilLen]) nextEvilLen = kmp[nextEvilLen - 1];
            nextEvilLen = c == evil[nextEvilLen] ? nextEvilLen + 1 : 0;
            ans = (ans + dfs(curLength + 1, nextEvilLen, n, evilLen, nextTouchBottom, nextTouchTop, s1, s2, evil, kmp, cache)) % p;
        }
        cache.put(key, ans);
        return ans;
    }

    private static final class Key {
        int curLen, curEvil;
        boolean touchBottom, touchTop;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return curLen == key.curLen &&
                    curEvil == key.curEvil &&
                    touchBottom == key.touchBottom &&
                    touchTop == key.touchTop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(curLen, curEvil, touchBottom, touchTop);
        }

        public Key(int curLen, int curEvil, boolean touchBottom, boolean touchTop) {
            this.curLen = curLen;
            this.curEvil = curEvil;
            this.touchBottom = touchBottom;
            this.touchTop = touchTop;
        }
    }
}

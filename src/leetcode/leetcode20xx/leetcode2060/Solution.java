package leetcode.leetcode20xx.leetcode2060;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private char[] s1, s2;
    private int m, n;
    private Set<Key> set;

    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.m = s1.length();
        this.n = s2.length();
        this.set = new HashSet<>();
        return dfs(0, 0, 0, 0);
    }

    private boolean dfs(int i, int j, int l1, int l2) {
        if (l1 != 0 && l2 != 0) {
            int skip = Math.min(l1, l2);
            l1 -= skip;
            l2 -= skip;
        }
        if ((i == m && l1 == 0) || (j == n && l2 == 0)) return i == m && l1 == 0 && j == n && l2 == 0;

        if (!set.add(new Key(i, j, l1 - l2))) return false;

        if (l1 == 0 && l2 == 0 && s1[i] == s2[j] && dfs(i + 1, j + 1, 0, 0)) return true;
        if (l1 == 0) {
            if (l2 != 0 && !isDigit(s1[i]) && dfs(i + 1, j, 0, l2 - 1)) return true;
            int tmpLeft = 0, tmpIndex = i;
            while (tmpIndex < m && isDigit(s1[tmpIndex])) {
                tmpLeft = tmpLeft * 10 + s1[tmpIndex++] - '0';
                if (dfs(tmpIndex, j, tmpLeft, l2)) return true;
            }
        }
        if (l2 == 0) {
            if (l1 != 0 && !isDigit(s2[j]) && dfs(i, j + 1, l1 - 1, 0)) return true;
            int tmpLeft = 0, tmpIndex = j;
            while (tmpIndex < n && isDigit(s2[tmpIndex])) {
                tmpLeft = tmpLeft * 10 + s2[tmpIndex++] - '0';
                if (dfs(i, tmpIndex, l1, tmpLeft)) return true;
            }
        }
        return false;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }


    private static class Key {
        final int i, j, left;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return i == key.i && j == key.j && left == key.left;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, left);
        }

        public Key(int i, int j, int left) {
            this.i = i;
            this.j = j;
            this.left = left;
        }
    }
}

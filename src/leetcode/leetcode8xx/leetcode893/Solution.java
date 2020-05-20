package leetcode.leetcode8xx.leetcode893;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int numSpecialEquivGroups(String[] arr) {
        HashSet<CanonicalFrom> ans = new HashSet<>();
        for (String s : arr) ans.add(new CanonicalFrom(s));
        return ans.size();
    }

    private static class CanonicalFrom {
        private final int[][] count = new int[2][26];

        public CanonicalFrom(String s) {
            for (int i = 0, n = s.length(); i < n; i++) {
                count[i & 1][s.charAt(i) - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CanonicalFrom that = (CanonicalFrom) o;
            return Arrays.equals(count[0], that.count[0]) &&
                    Arrays.equals(count[1], that.count[1]);
        }

        @Override
        public int hashCode() {
            return 31 * Arrays.hashCode(count[0]) + Arrays.hashCode(count[1]);
        }
    }
}

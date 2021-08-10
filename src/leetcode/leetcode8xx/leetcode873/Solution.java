package leetcode.leetcode8xx.leetcode873;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        int n = arr.length;
        HashMap<Pair, Integer> map = new HashMap<>();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int len = map.getOrDefault(new Pair(arr[j] - arr[i], arr[i]), 1) + 1;
                map.put(new Pair(arr[i], arr[j]), len);
                ans = Math.max(ans, len);
            }
        }
        return ans < 3 ? 0 : ans;
    }

    private static class Pair {
        final int a, b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

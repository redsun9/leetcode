package leetcode.leetcode39xx.leetcode3943;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        SqrtLazy sqrtLazy = new SqrtLazy(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) map.put(a, map.getOrDefault(a, 0) + 1);

        int m = 0, pos = 0;
        for (int[] query : queries) if (query[0] == 2) m++;
        int[] ans = new int[m];
        for (int[] query : queries) {
            if (query[0] == 1) sqrtLazy.add(query[1], query[2] + 1, query[3]);
            else {
                int tmp = 0, total = query[1];
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    tmp += sqrtLazy.compute(total - entry.getKey()) * entry.getValue();
                }
                ans[pos++] = tmp;
            }
        }
        return ans;
    }

    private static final class SqrtLazy {
        final int[] arr;
        final int n, d, m;
        final LazyNode[] nodes;

        private SqrtLazy(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.d = (int) Math.round(Math.sqrt(n));
            this.m = (n + d - 1) / d;
            this.nodes = new LazyNode[m];
            for (int i = 0; i < m; i++) nodes[i] = new LazyNode(i * d, Math.min((i + 1) * d, n));
        }

        private void add(int x, int y, int val) {
            for (LazyNode node : nodes) node.add(x, y, val);
        }

        private int compute(int num) {
            int ans = 0;
            for (LazyNode node : nodes) ans += node.count(num);
            return ans;
        }

        private class LazyNode {
            final int l, r;
            Map<Integer, Integer> map;
            int shift = 0;

            private LazyNode(int l, int r) {
                this.l = l;
                this.r = r;
                map = new HashMap<>();
                for (int i = l; i < r; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            private void add(int x, int y, int val) {
                if (y <= l || x >= r || val == 0) return;
                if (x <= l && y >= r) {
                    shift += val;
                } else {
                    if (shift != 0) for (int i = l; i < r; i++) arr[i] += shift;
                    shift = 0;
                    int a = Math.max(x, l), b = Math.min(y, r);
                    for (int i = a; i < b; i++) arr[i] += val;
                    map.clear();
                    for (int i = l; i < r; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }
            }

            private int count(int num) {
                return map.getOrDefault(num - shift, 0);
            }
        }
    }
}

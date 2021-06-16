package leetcode.leetcode6xx.leetcode699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] position : positions) {
            pq.offer(position[0]);
            pq.offer(position[0] + position[1]);
        }
        int idx = 0;
        int prev = 0, next;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            next = pq.poll();
            if (prev != next) map.put(next, idx++);
            prev = next;
        }
        InconsistentSegmentTree tree = new InconsistentSegmentTree(idx);
        List<Integer> ans = new ArrayList<>(positions.length);
        for (int[] position : positions) {
            int a = map.get(position[0]);
            int b = map.get(position[0] + position[1]);
            int prevHeight = tree.query(a, b);
            tree.update(a, b, prevHeight + position[1]);
            ans.add(tree.query());
        }
        return ans;
    }

    private static class InconsistentSegmentTree {
        private static final int NEUTRAL_VALUE = 0;
        private final int n;
        private final int[] t;
        private final int[] mod;

        public InconsistentSegmentTree(int size) {
            this.n = nextPow2(size);
            this.t = new int[n * 2 - 1];
            this.mod = new int[n * 2 - 1];
        }

        public int query() {
            return t[0];
        }

        public int query(int a, int b) {
            return query(0, 0, n, a, b);
        }

        public void update(int a, int b, int val) {
            update(0, 0, n, a, b, val);
        }

        private int query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) return NEUTRAL_VALUE;
            if (ql <= l && r <= qr) return t[v];
            push(v);
            int mid = (l + r) / 2;
            return Math.max(
                    query(v * 2 + 1, l, mid, ql, qr),
                    query(v * 2 + 2, mid, r, ql, qr)
            );
        }

        private void update(int v, int l, int r, int ql, int qr, int value) {
            if (ql <= l && r <= qr) {
                t[v] = value;
                mod[v] = value;
                return;
            }
            if (l >= qr || r <= ql) return;
            push(v);
            int mid = (l + r) / 2;
            update(v * 2 + 1, l, mid, ql, qr, value);
            update(v * 2 + 2, mid, r, ql, qr, value);
            t[v] = Math.max(t[v * 2 + 1], t[v * 2 + 2]);
        }

        private void push(int v) {
            if (mod[v] != 0 && v < n - 1) {
                t[v * 2 + 1] = mod[v];
                t[v * 2 + 2] = mod[v];
                mod[v * 2 + 1] = mod[v];
                mod[v * 2 + 2] = mod[v];
                mod[v] = 0;
            }
        }
    }
}

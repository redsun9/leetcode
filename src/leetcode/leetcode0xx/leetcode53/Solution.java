package leetcode.leetcode0xx.leetcode53;

import java.lang.reflect.Array;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i];
        }
        SegmentTree<Long, SegmentMax> segmentTree = new SegmentTree<>(
                a,
                x -> new SegmentMax(x, x, x, x),
                (l, r) -> new SegmentMax(
                        max(l.maxSum, r.maxSum, l.maxRightSum + r.maxLeftSum),
                        max(l.maxLeftSum, l.allSum + r.maxLeftSum),
                        max(r.maxRightSum, r.allSum + l.maxRightSum),
                        l.allSum + r.allSum
                ),
                SegmentMax[].class,
                (long) Integer.MIN_VALUE
        );
        return (int) segmentTree.query(0, n).maxSum;
    }

    private static class SegmentMax {
        long maxSum;
        long maxLeftSum;
        long maxRightSum;
        long allSum;

        public SegmentMax(long maxSum, long maxLeftSum, long maxRightSum, long allSum) {
            this.maxSum = maxSum;
            this.maxLeftSum = maxLeftSum;
            this.maxRightSum = maxRightSum;
            this.allSum = allSum;
        }
    }

    private static long max(long... a) {
        long max = a[0];
        for (long i : a) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static class SegmentTree<V, T> {
        private final V[] a;
        private final T[] t;
        private final int n;
        private final Function<V, T> f;
        private final T neutralValue;
        private final BiFunction<T, T, T> bf;

        public SegmentTree(
                V[] values, Function<V, T> mappingFunction, BiFunction<T, T, T> biFunction,
                Class<T[]> clazz, V neutralElement
        ) {
            this.f = mappingFunction;
            this.bf = biFunction;
            this.n = nextPow2(values.length);
            neutralValue = f.apply(neutralElement);
            a = (V[]) values.getClass().cast(Array.newInstance(values.getClass().getComponentType(), n));
            for (int i = 0; i < values.length; i++) {
                a[i] = values[i];
            }
            for (int i = values.length; i < n; i++) {
                a[i] = neutralElement;
            }
            t = clazz.cast(Array.newInstance(clazz.getComponentType(), n * 2 - 1));
            for (int i = 0; i < n; i++) {
                t[n - 1 + i] = f.apply(a[i]);
            }
            for (int i = n - 2; i >= 0; i--) {
                t[i] = bf.apply(t[2 * i + 1], t[2 * i + 2]);
            }
        }

        public T query(int a, int b) {
            return query(0, 0, n, a, b);
        }

        private T query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) {
                return neutralValue;
            }
            if (ql <= l && r <= qr) {
                return t[v];
            }
            int mid = (l + r) / 2;
            return bf.apply(
                    query(v * 2 + 1, l, mid, ql, qr),
                    query(v * 2 + 2, mid, r, ql, qr)
            );
        }

        public void update(int pos, V value) {
            a[pos] = value;
            update(0, 0, n, pos, value);
        }

        private void update(int v, int l, int r, int pos, V value) {
            if (l == r - 1) {
                t[v] = f.apply(value);
            } else {
                int mid = (l + r) / 2;
                if (pos < mid) {
                    update(v * 2 + 1, l, mid, pos, value);
                } else {
                    update(v * 2 + 2, mid, r, pos, value);
                }
                t[v] = bf.apply(t[v * 2 + 1], t[v * 2 + 2]);
            }
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}

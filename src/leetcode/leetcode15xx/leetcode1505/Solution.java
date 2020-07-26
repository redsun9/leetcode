package leetcode.leetcode15xx.leetcode1505;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Solution {
    public String minInteger(String num, int k) {
        if (k == 0) return num;
        int n = num.length();
        char[] chars = num.toCharArray();
        if (k >= n * (n - 1) / 2) {
            Arrays.sort(chars);
            return new String(chars);
        }
        Stack<Integer>[] pqs = new Stack[10];
        for (int i = 0; i < 10; i++) pqs[i] = new Stack<>();
        for (int i = n - 1; i >= 0; i--) pqs[chars[i] - '0'].push(i);
        char[] ans = new char[n];
        SegmentTree<Integer, Integer> tree = SegmentTree.sumSegmentTree(new int[n]);
        for (int i = 0; i < n; i++) {
            for (int digit = 0; digit <= 9; digit++) {
                if (!pqs[digit].isEmpty()) {
                    Integer pos = pqs[digit].peek();
                    int shift = tree.query(0, pos);
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        tree.update(pos, 1);
                        pqs[digit].pop();
                        ans[i] = (char) (digit + '0');
                        break;
                    }
                }
            }
        }
        return new String(ans);
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

        public static SegmentTree<Integer, Integer> sumSegmentTree(int[] a) {
            return integerSegmentTree(a, Integer::sum, 0);
        }

        public static SegmentTree<Integer, Integer> maxSegmentTree(int[] a) {
            return integerSegmentTree(a, Integer::max, Integer.MIN_VALUE);
        }

        public static SegmentTree<Integer, Integer> minSegmentTree(int[] a) {
            return integerSegmentTree(a, Integer::min, Integer.MAX_VALUE);
        }

        public static SegmentTree<Integer, Integer> integerSegmentTree(
                int[] a, IntBinaryOperator combiner, int neutralElement
        ) {
            Integer[] integers = new Integer[nextPow2(a.length)];
            for (int i = 0; i < a.length; i++) {
                integers[i] = a[i];
            }
            Arrays.fill(integers, a.length, integers.length, neutralElement);
            return new SegmentTree<>(
                    integers, Function.identity(), combiner::applyAsInt, Integer[].class, neutralElement
            );
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

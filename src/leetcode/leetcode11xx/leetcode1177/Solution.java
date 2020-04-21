package leetcode.leetcode11xx.leetcode1177;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        SegmentTree<Character, boolean[]> tree = new SegmentTree<>(
                chars,
                c -> {
                    boolean[] b = new boolean[26];
                    if (c != null) b[c - 'a'] = true;
                    return b;
                },
                (l, r) -> {
                    boolean[] b = new boolean[26];
                    for (int i = 0; i < 26; i++) {
                        b[i] = l[i] ^ r[i];
                    }
                    return b;
                },
                boolean[][].class,
                null
        );
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            boolean[] b = tree.query(query[0], query[1] + 1);
            int count = 0;
            for (boolean b1 : b) {
                if (b1) count++;
            }
            ans.add(count / 2 <= query[2]);
        }
        return ans;
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

package leetcode.leetcode22xx.leetcode2213;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
    private final static char STAR = '*';

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        Character[] arr = new Character[n];
        for (int i = 0; i < n; i++) arr[i] = s.charAt(i);

        SegmentTree<Character, Node> tree = new SegmentTree<>(arr, Node::new, Solution::combine, Node[].class, STAR);
        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            tree.update(queryIndices[i], queryCharacters.charAt(i));
            Node node = tree.query();
            ans[i] = node.maxLength;
        }
        return ans;
    }

    private record Node(
            char charLeft, int leftLength,
            char charMax, int maxLength,
            char charRight, int rightLength,
            boolean allSame
    ) {
        Node(char c) {
            this(c, c == STAR ? 0 : 1);
        }

        Node(char c, int length) {
            this(c, length, c, length, c, length, true);
        }
    }

    private static Node combine(Node l, Node r) {
        int leftLength = l.leftLength + (l.allSame && l.charRight == r.charLeft ? r.leftLength : 0);
        int rightLength = r.rightLength + (r.allSame && r.charLeft == l.charRight ? l.rightLength : 0);
        boolean allSame = l.allSame && r.allSame && l.charRight == r.charLeft;
        char charMax;
        int maxLength;
        if (l.maxLength >= r.maxLength) {
            charMax = l.charMax;
            maxLength = l.maxLength;
        } else {
            charMax = r.charMax;
            maxLength = r.maxLength;
        }
        if (l.charRight == r.charLeft && l.rightLength + r.leftLength > maxLength) {
            charMax = l.charRight;
            maxLength = l.rightLength + r.leftLength;
        }

        return new Node(
                l.charLeft, leftLength,
                charMax, maxLength,
                r.charRight, rightLength,
                allSame
        );
    }

    @SuppressWarnings("DuplicatedCode")
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
            System.arraycopy(values, 0, a, 0, values.length);
            Arrays.fill(a, values.length, n, neutralElement);
            t = clazz.cast(Array.newInstance(clazz.getComponentType(), n * 2 - 1));
            for (int i = 0; i < n; i++) t[n - 1 + i] = f.apply(a[i]);
            for (int i = n - 2; i >= 0; i--) t[i] = bf.apply(t[2 * i + 1], t[2 * i + 2]);
        }

        public T query() {
            return query(0, n);
        }


        public T query(int a, int b) {
            return query(0, 0, n, a, b);
        }

        private T query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) return neutralValue;
            if (ql <= l && r <= qr) return t[v];
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
            if (l == r - 1) t[v] = f.apply(value);
            else {
                int mid = (l + r) / 2;
                if (pos < mid) update(v * 2 + 1, l, mid, pos, value);
                else update(v * 2 + 2, mid, r, pos, value);
                t[v] = bf.apply(t[v * 2 + 1], t[v * 2 + 2]);
            }
        }

        private static int nextPow2(int n) {
            if ((n & (n - 1)) == 0) return n;
            else return Integer.highestOneBit(n) << 1;
        }
    }
}

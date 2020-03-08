package basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class SegmentTree<V, T> {
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
        this.n = IntegerUtils.nextPow2(values.length);
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
        Integer[] integers = new Integer[IntegerUtils.nextPow2(a.length)];
        for (int i = 0; i < a.length; i++) {
            integers[i] = a[i];
        }
        Arrays.fill(integers, a.length, integers.length, neutralElement);
        return new SegmentTree<>(
                integers, Function.identity(), combiner::applyAsInt, Integer[].class, neutralElement
        );
    }
}

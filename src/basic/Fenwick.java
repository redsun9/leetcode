package basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Fenwick<T> {
    private final T[] a;
    private final T[] t;
    private final int leftBorder;
    private final int rightBorder;
    private final Supplier<T> supplier;
    private final int n;
    private final BiFunction<T, T, T> sumFunction;
    private final BiFunction<T, T, T> subFunction;

    public Fenwick(final Class<T[]> clazz, final int lb, final int rb,
                   Supplier<T> supplier, Function<Integer, T> f,
                   BiFunction<T, T, T> sumFunction, BiFunction<T, T, T> subFunction
    ) {
        leftBorder = lb;
        rightBorder = rb;
        this.supplier = supplier;
        n = rb - lb + 1;
        this.sumFunction = sumFunction;
        this.subFunction = subFunction;
        t = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
        a = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
        Arrays.fill(t, supplier.get());
        for (int i = 0; i < n; i++) {
            T value = f.apply(lb + i);
            a[i] = value;
            inc(i, value);
        }
    }

    public T get(int i) {
        assert leftBorder <= i;
        assert rightBorder >= i;
        return a[i - leftBorder];
    }

    /*
        sum from l to r inclusive
     */
    public T sum(int l, int r) {
        assert leftBorder <= l;
        assert l <= r;
        assert r <= rightBorder;
        return subFunction.apply(sum(r - leftBorder), sum(l - leftBorder - 1));
    }

    public void change(int i, T newValue) {
        assert leftBorder <= i;
        assert rightBorder >= i;
        int internalIndex = i - leftBorder;
        T oldValue = this.t[internalIndex];
        if (!oldValue.equals(newValue)) {
            a[internalIndex] = newValue;
            T delta = subFunction.apply(newValue, oldValue);
            inc(internalIndex, delta);
        }
        ;
    }

    private void inc(int i, T delta) {
        for (; i < n; i = (i | (i + 1)))
            t[i] = sumFunction.apply(t[i], delta);
    }

    private T sum(int r) {
        T result = supplier.get();
        for (; r >= 0; r = (r & (r + 1)) - 1)
            result = sumFunction.apply(result, t[r]);
        return result;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public Supplier<T> getSupplier() {
        return supplier;
    }

    public BiFunction<T, T, T> getSumFunction() {
        return sumFunction;
    }

    public BiFunction<T, T, T> getSubFunction() {
        return subFunction;
    }
}

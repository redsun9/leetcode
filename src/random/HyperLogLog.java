package random;

import java.util.concurrent.atomic.AtomicInteger;

public class HyperLogLog {
    private static final int[] B_PARAMETER = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private static final float[] A_PARAMETER = {
            0.673102f,
            0.697123f,
            0.709205f,
            0.715271f,
            0.718308f,
            0.719827f,
            0.720587f,
            0.720967f,
            0.721157f,
            0.721252f,
            0.7213f
    };

    private final int b, jMask, shift, m, wMask;
    private final float a;
    private final AtomicInteger[] counters;
    private int addNumber = 0;

    public HyperLogLog(int level) {
        a = A_PARAMETER[level];
        b = B_PARAMETER[level];
        m = 1 << b;
        shift = 32 - b;
        jMask = (m - 1) << shift;
        wMask = (1 << shift) - 1;
        counters = new AtomicInteger[m];
        for (int i = 0; i < m; i++) counters[i] = new AtomicInteger();
    }

    public void add(int v) {
        addNumber++;
        int j = (v & jMask) >>> shift;
        int w = v & wMask;
        if (w == 0) counters[j].set(wMask + 1);
        else {
            int newValue = w ^ (w & (w - 1));
            int prevValue, max;
            do {
                prevValue = counters[j].get();
                max = Math.max(prevValue, newValue);
            } while (!counters[j].compareAndSet(prevValue, max));
        }
    }

    public int size() {
        long count = 0;
        if (addNumber * 2 <= 5 * m) {
            int zeros = 0;
            for (AtomicInteger counter : counters) {
                if (counter.get() == 0) zeros++;
            }
            if (zeros != 0) return (int) (m * Math.log(((float) m) / zeros));
        }
        for (AtomicInteger counter : counters) {
            int value = counter.get();
            if (value != 0) count += Integer.reverse(value) >>> b;
            else count += (wMask + 1);
        }
        return (int) (a * m * Math.pow(2, 32) / count);
    }
}

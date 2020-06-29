package raiffeisen.mc;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/*
    Monte-Carlo simulations
    for 10 million simulations

    overIsOk = false
    Pair{index=6, val=0.547817372}
    Pair{index=9, val=0.493803251}
    Pair{index=10, val=0.481272205}
    Pair{index=11, val=0.475837245}
    Pair{index=8, val=0.474060359}
    Pair{index=4, val=0.467088538}
    Pair{index=7, val=0.463526504}
    Pair{index=3, val=0.463063723}
    Pair{index=5, val=0.460195054}
    Pair{index=2, val=0.460130607}
    Pair{index=1, val=0.453351289}

    overIsOk = true
    Pair{index=8, val=0.4563668}
    Pair{index=9, val=0.4433046}
    Pair{index=6, val=0.4214507}
    Pair{index=10, val=0.3773107}
    Pair{index=11, val=0.3607627}
    Pair{index=7, val=0.3602033}
    Pair{index=5, val=0.3176743}
    Pair{index=3, val=0.3116498}
    Pair{index=4, val=0.3066561}
    Pair{index=2, val=0.2868487}
    Pair{index=1, val=0.2705474}
 */

public class Solution3 {
    private static final int MAX_ITER = 1000;
    private static final int MAX_SIMULATIONS = 1_000_000_000;
    private static final boolean overIsOk = false;
    private static final int firstStart = 12;
    private static final int secondStart = 8;

    public static void main(String[] args) {
        double[] p = new double[6];
        double p1 = (1 - 0.22d - 0.21d) / 4;
        for (int i = 0; i < 6; i++) p[i] = p1;
        p[2] = 0.22;
        p[3] = 0.21;
        for (int i = 1; i < 5; i++) p[i] += p[i - 1];
        p[5] = 1.01;

        AtomicLong[] first = new AtomicLong[11];
        AtomicLong[] second = new AtomicLong[11];
        for (int i = 0; i < 11; i++) {
            first[i] = new AtomicLong();
            second[i] = new AtomicLong();
        }
        IntStream.rangeClosed(1, 11).forEach(accPos -> {
            IntStream.range(0, MAX_SIMULATIONS).parallel().forEach(testRun -> {
                Random random = new Random();
                boolean turn = true;
                int a = firstStart;
                int b = secondStart;
                int iterLeft = MAX_ITER;
                while (iterLeft-- > 0) {
                    double v = random.nextDouble();
                    int m = 1;
                    while (m < 6 && p[m - 1] < v) m++;
                    if (a - m == accPos) m += 6;
                    a = overIsOk ? Math.max(0, a - m) : (a >= m ? a - m : a);
                    if (a == 0) {
                        if (turn) first[accPos - 1].incrementAndGet();
                        else second[accPos - 1].incrementAndGet();
                        return;
                    } else {
                        turn = !turn;
                        int c = a;
                        a = b;
                        b = c;
                    }
                }
            });
        });

        IntStream.rangeClosed(1, 11).mapToObj(i -> {
            double tmpVal = first[i - 1].doubleValue() / (first[i - 1].get() + second[i - 1].get());
            return new Pair(i, tmpVal);
        }).sorted(Comparator.comparingDouble(x -> -x.val)).forEach(System.out::println);
    }

    private static class Pair {
        int index;
        double val;

        public Pair(int index, double val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", val=" + val +
                    '}';
        }
    }
}

package raiffeisen.mc;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/*
    Monte-Carlo simulations
    for 1 billion simulations

    overIsOk = false
    Pair{index=6, val=0.545201}
    Pair{index=11, val=0.485912}
    Pair{index=9, val=0.485655}
    Pair{index=8, val=0.484667}
    Pair{index=10, val=0.484326}
    Pair{index=2, val=0.472923}
    Pair{index=7, val=0.471232}
    Pair{index=3, val=0.467402}
    Pair{index=4, val=0.463221}
    Pair{index=5, val=0.458986}
    Pair{index=1, val=0.457993}

    overIsOk = true
    Pair{index=8, val=0.438717}
    Pair{index=6, val=0.424076}
    Pair{index=9, val=0.420778}
    Pair{index=10, val=0.402831}
    Pair{index=11, val=0.385158}
    Pair{index=7, val=0.373791}
    Pair{index=5, val=0.341824}
    Pair{index=4, val=0.325295}
    Pair{index=3, val=0.30837}
    Pair{index=2, val=0.292338}
    Pair{index=1, val=0.289534}
 */

public class Solution2 {
    private static final int MAX_ITER = 1000;
    private static final int MAX_SIMULATIONS = 1_000_000;
    private static final boolean overIsOk = true;
    private static final int firstStart = 12;
    private static final int secondStart = 8;

    public static void main(String[] args) {
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
                    int m = 1 + random.nextInt(6);
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

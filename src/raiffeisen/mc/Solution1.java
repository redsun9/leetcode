package raiffeisen.mc;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/*
    Monte-Carlo simulations
    for 1 billion simulations

    overIsOk = false
    0.446344172
    0.553655828

    overIsOk = true
    0.276016951
    0.723983049


 */

public class Solution1 {
    private static final int MAX_ITER = 1000; // maximum number of roles in a simulation
    private static final int MAX_SIMULATIONS = 1_000_000_000;

    // is a roll with a greater result than it's needed to achieve the final position ends the gamw
    private static final boolean overIsOk = true;

    private static final int firstStart = 12;
    private static final int secondStart = 8;

    public static void main(String[] args) {
        double[] p = new double[6];
        double p1 = (1 - 0.33d) / 5;
        for (int i = 0; i < 6; i++) p[i] = p1;
        p[3] = 0.33;
        for (int i = 1; i < 6; i++) p[i] += p[i - 1];

        AtomicLong first = new AtomicLong();
        AtomicLong second = new AtomicLong();

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
                a = overIsOk ? Math.max(0, a - m) : (a >= m ? a - m : a);
                if (a == 0) {
                    if (turn) first.incrementAndGet();
                    else second.incrementAndGet();
                    return;
                } else {
                    turn = !turn;
                    int c = a;
                    a = b;
                    b = c;
                }
            }
        });
        System.out.println(first.longValue() * 1.0 / (first.longValue() + second.longValue()));
        System.out.println(second.longValue() * 1.0 / (first.longValue() + second.longValue()));
    }
}

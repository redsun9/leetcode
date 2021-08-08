package leetcode.leetcode19xx.leetcode1960;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//Benchmark             (n)  (typeOfTest)  Mode  Cnt    Score   Error  Units
//PerfTest.manacher    1000          same  avgt   10    9.936 ± 0.031  ms/op
//PerfTest.manacher    1000        random  avgt   10    1.061 ± 0.011  ms/op
//PerfTest.manacher    1000        binary  avgt   10    1.572 ± 0.014  ms/op
//PerfTest.manacher   10000          same  avgt   10  772.987 ± 2.515  ms/op
//PerfTest.manacher   10000        random  avgt   10   10.564 ± 0.044  ms/op
//PerfTest.manacher   10000        binary  avgt   10   16.510 ± 0.119  ms/op
//PerfTest.manacher  100000        random  avgt   10  104.236 ± 0.298  ms/op
//PerfTest.manacher  100000        binary  avgt   10  164.740 ± 0.455  ms/op
//PerfTest.rabin       1000          same  avgt   10    2.670 ± 0.004  ms/op
//PerfTest.rabin       1000        random  avgt   10    2.492 ± 0.006  ms/op
//PerfTest.rabin       1000        binary  avgt   10    2.530 ± 0.003  ms/op
//PerfTest.rabin      10000          same  avgt   10   27.182 ± 0.069  ms/op
//PerfTest.rabin      10000        random  avgt   10   24.503 ± 0.118  ms/op
//PerfTest.rabin      10000        binary  avgt   10   24.439 ± 0.213  ms/op
//PerfTest.rabin     100000          same  avgt   10  262.735 ± 0.708  ms/op
//PerfTest.rabin     100000        random  avgt   10  246.333 ± 0.463  ms/op
//PerfTest.rabin     100000        binary  avgt   10  246.295 ± 1.468  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    private final int BATCH_SIZE = 100;
    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();
    private String[] tests = new String[BATCH_SIZE];

    @Param({"1000", "10000", "100000"})
    private int n;
    @Param({"same", "random", "binary"})
    private String typeOfTest;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void manacher(Blackhole bh) {
        if (n == 100000 && typeOfTest.equals("same")) throw new RuntimeException();
        for (int i = 0; i < BATCH_SIZE; i++) bh.consume(solution.maxProduct(tests[i]));
    }

    @Benchmark
    public void rabin(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) bh.consume(solution2.maxProduct(tests[i]));
    }


    @Setup
    public void setup() {
        IntStream.range(0, BATCH_SIZE).parallel().forEach(t -> {
            Random random = ThreadLocalRandom.current();
            char[] s = new char[n];
            switch (typeOfTest) {
                case "same" -> {
                    Arrays.fill(s, 'a');
                    int k = n / BATCH_SIZE;
                    s[t * k + random.nextInt(k)] = 'b';
                }
                case "binary" -> {
                    for (int i = 0; i < n; i++) s[i] = (char) ('a' + random.nextInt(2));
                }
                case "random" -> {
                    for (int i = 0; i < n; i++) s[i] = (char) ('a' + random.nextInt(26));

                }
                default -> throw new IllegalArgumentException("Unknown type - " + typeOfTest);
            }
            tests[t] = new String(s);
        });
    }

}

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

//Benchmark             (n)  (typeOfTest)  Mode  Cnt    Score    Error  Units
//PerfTest.manacher    1000          same  avgt   10    2.258 ±  0.248  ms/op
//PerfTest.manacher    1000        random  avgt   10    1.957 ±  0.021  ms/op
//PerfTest.manacher    1000        binary  avgt   10    3.228 ±  0.174  ms/op
//PerfTest.manacher   10000          same  avgt   10   20.481 ±  0.804  ms/op
//PerfTest.manacher   10000        random  avgt   10   18.272 ±  0.280  ms/op
//PerfTest.manacher   10000        binary  avgt   10   29.019 ±  0.223  ms/op
//PerfTest.manacher  100000          same  avgt   10  200.183 ±  2.256  ms/op
//PerfTest.manacher  100000        random  avgt   10  180.147 ±  0.427  ms/op
//PerfTest.manacher  100000        binary  avgt   10  288.142 ±  4.747  ms/op
//PerfTest.rabin       1000          same  avgt   10    3.450 ±  0.022  ms/op
//PerfTest.rabin       1000        random  avgt   10    3.840 ±  0.019  ms/op
//PerfTest.rabin       1000        binary  avgt   10    3.920 ±  0.042  ms/op
//PerfTest.rabin      10000          same  avgt   10   36.167 ±  4.380  ms/op
//PerfTest.rabin      10000        random  avgt   10   39.745 ±  1.147  ms/op
//PerfTest.rabin      10000        binary  avgt   10   38.967 ±  0.254  ms/op
//PerfTest.rabin     100000          same  avgt   10  345.992 ±  2.910  ms/op
//PerfTest.rabin     100000        random  avgt   10  424.694 ± 13.552  ms/op
//PerfTest.rabin     100000        binary  avgt   10  391.722 ±  6.365  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    private final int BATCH_SIZE = 100;
    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();
    private final String[] tests = new String[BATCH_SIZE];

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

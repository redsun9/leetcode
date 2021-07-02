package leetcode.leetcode58xx.leetcode5819;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//Benchmark                   (n)  Mode  Cnt      Score     Error  Units
//SolutionTest.sorted             10  avgt    5      0,005 ±   0,001  ms/op
//SolutionTest.sorted            100  avgt    5      0,178 ±   0,006  ms/op
//SolutionTest.sorted           1000  avgt    5      3,071 ±   0,019  ms/op
//SolutionTest.sorted          10000  avgt    5     45,519 ±   0,547  ms/op
//SolutionTest.sorted         100000  avgt    5    662,776 ±  25,151  ms/op
//SolutionTest.sorted        1000000  avgt    5  16275,051 ± 186,169  ms/op
//SolutionTest.monotonic          10  avgt    5      0,001 ±   0,001  ms/op
//SolutionTest.monotonic         100  avgt    5      0,013 ±   0,001  ms/op
//SolutionTest.monotonic        1000  avgt    5      0,362 ±   0,008  ms/op
//SolutionTest.monotonic       10000  avgt    5      3,538 ±   0,039  ms/op
//SolutionTest.monotonic      100000  avgt    5     35,916 ±   1,554  ms/op
//SolutionTest.monotonic     1000000  avgt    5    360,239 ±   4,100  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class SolutionTest {
    private final int BATCH_SIZE = 10;
    private final int[][] tests = new int[BATCH_SIZE][];
    Solution solution = new Solution();
    Solution2 solution2 = new Solution2();
    @Param({"10", "100", "1000", "10000", "100000", "1000000"})
    private int n;


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sorted(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) {
            bh.consume(solution2.findMaximums(tests[i]));
        }
    }

    @Benchmark
    public void monotonic(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) {
            bh.consume(solution.findMaximums(tests[i]));
        }
    }

    @Setup
    public void setup() {
        IntStream.range(0, BATCH_SIZE).parallel().forEach(t -> {
            int[] test = new int[n];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                test[i] = random.nextInt(1_000_000_000);
            }
            tests[t] = test;
        });
    }
}
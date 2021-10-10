package leetcode.leetcode20xx.leetcode2035;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


//Benchmark       (k)  (n)  Mode  Cnt     Score    Error  Units
//PerfTest.sol1     3   10  avgt   10     0.867 ±  0.007  ms/op
//PerfTest.sol1     3   20  avgt   10    47.813 ±  0.213  ms/op
//PerfTest.sol1     3   30  avgt   10  3420.654 ± 47.313  ms/op
//PerfTest.sol1    10   10  avgt   10     1.110 ±  0.007  ms/op
//PerfTest.sol1    10   20  avgt   10    70.468 ±  0.239  ms/op
//PerfTest.sol1    10   30  avgt   10  4787.754 ± 17.415  ms/op
//PerfTest.sol1  1000   10  avgt   10     1.201 ±  0.022  ms/op
//PerfTest.sol1  1000   20  avgt   10   103.418 ±  1.661  ms/op
//PerfTest.sol1  1000   30  avgt   10  5241.296 ± 17.669  ms/op
//PerfTest.sol2     3   10  avgt   10     0.475 ±  0.003  ms/op
//PerfTest.sol2     3   20  avgt   10     0.729 ±  0.006  ms/op
//PerfTest.sol2     3   30  avgt   10     1.190 ±  0.013  ms/op
//PerfTest.sol2    10   10  avgt   10     1.607 ±  0.007  ms/op
//PerfTest.sol2    10   20  avgt   10    32.295 ±  0.173  ms/op
//PerfTest.sol2    10   30  avgt   10   365.667 ±  1.362  ms/op
//PerfTest.sol2  1000   10  avgt   10     3.797 ±  0.021  ms/op
//PerfTest.sol2  1000   20  avgt   10  2336.696 ±  9.832  ms/op
//PerfTest.sol3     3   10  avgt   10   139.555 ±  3.938  ms/op
//PerfTest.sol3    10   10  avgt   10   138.932 ±  2.507  ms/op
//PerfTest.sol3  1000   10  avgt   10   137.576 ±  2.351  ms/op


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    @Param({"3", "10", "1000"})
    private int k;

    @Param({"10", "20", "30"})
    private int n;


    private static final int minValue = -1_000_000, maxValue = 1_000_000;
    private static final int BATCH_SIZE = 1000;

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();
    private final Solution3 solution3 = new Solution3();

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private int[][] tests;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[] nums : tests) {
            bh.consume(solution.minimumDifference(nums));
        }
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        if (n == 30 && k == 1000) throw new RuntimeException();
        for (int[] nums : tests) {
            bh.consume(solution2.minimumDifference(nums));
        }
    }

    @Benchmark
    public void sol3(Blackhole bh) {
        if (n >= 20) throw new RuntimeException();
        for (int[] nums : tests) {
            bh.consume(solution3.minimumDifference(nums));
        }
    }

    @Setup
    public void setup() {
        tests = new int[BATCH_SIZE][n];
        Set<Integer> set = new HashSet<>();
        int[] vals = new int[k];
        Random random = new Random();
        for (int i = 0; i < k; ) {
            vals[i] = minValue + random.nextInt(maxValue - minValue + 1);
            if (set.add(vals[i])) i++;
        }
        for (int[] nums : tests) {
            for (int i = 0; i < n; i++) {
                nums[i] = vals[random.nextInt(k)];
            }
        }
    }
}

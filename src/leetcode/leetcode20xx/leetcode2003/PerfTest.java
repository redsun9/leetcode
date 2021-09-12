package leetcode.leetcode20xx.leetcode2003;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("DuplicatedCode")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    @Param({"100", "1000", "10000", "100000"})
    private int n;

    private static final int batchSize = 100;

    private int[][][] tests;

    private static Solution solution = new Solution();
    private static Solution2 solution2 = new Solution2();

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[][] test : tests) bh.consume(solution.smallestMissingValueSubtree(test[0], test[1]));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int[][] test : tests) bh.consume(solution2.smallestMissingValueSubtree(test[0], test[1]));
    }


    @Setup
    public void setup() {
        tests = new int[batchSize][2][];
        Random random = new Random(0);
        for (int t = 0; t < batchSize; t++) {
            int[] parents = new int[n];
            parents[0] = -1;
            for (int i = 1; i < n; i++) parents[i] = random.nextInt(i);

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = i + 1;
            for (int i = n - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            tests[t][0] = parents;
            tests[t][1] = nums;
        }
    }
}

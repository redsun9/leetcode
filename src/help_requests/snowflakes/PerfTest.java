package help_requests.snowflakes;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class PerfTest {
    @Param({"100", "1000", "10000"})
    private int n;

    @Param({"10", "100", "1000"})
    private int k;

    private static final int BATCH_SIZE = 100;

    private int[][][] tests;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution.allUnique(test));
    }

    @Benchmark
    public void sol4(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution4.allUnique(test));
    }

    @Benchmark
    public void sol5(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution5.allUnique(test));
    }

    @Benchmark
    public void sol6(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution6.allUnique(test));
    }

    @Setup
    public void setup() {
        tests = new int[BATCH_SIZE][n][k];
        Random random = new Random(1);
        for (int[][] test : tests) for (int[] sf : test) for (int i = 0; i < k; i++) sf[i] = random.nextInt(10);
    }
}

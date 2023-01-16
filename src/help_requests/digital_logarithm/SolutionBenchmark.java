package help_requests.digital_logarithm;

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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class SolutionBenchmark {
    private static final int BATCH_SIZE = 100;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAl = 1_000_000;
    @Param({"100", "1000", "10000"})
    private int n;


    private int[][][] tests;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(SolutionBenchmark.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution.solveWithHashMap(test[0], test[1]));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution.solveWithPriorityQueue(test[0], test[1]));
    }

    @Setup
    public void setup() {
        tests = new int[BATCH_SIZE][2][n];
        Random random = new Random(0L);
        for (int[][] test : tests) {
            for (int i = 0; i < n; i++) {
                test[0][i] = MIN_VAL + random.nextInt(MAX_VAl - MIN_VAL);
                test[1][i] = MIN_VAL + random.nextInt(MAX_VAl - MIN_VAL);
            }
        }
    }
}

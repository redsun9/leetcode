package leetcode.leetcode23xx.leetcode2301;

import leetcode.leetcode23xx.leetcode2301.SolutionTest.TestData;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import prng.XorShift64;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class PerfTest {
    @Param({"100", "1000", "10000"})
    private int n;
    private TestData[] tests;

    private final Solution sol = new Solution();
    private final Solution3 sol2 = new Solution3();
    private final Solution4 sol3 = new Solution4();


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (TestData test : tests) bh.consume(sol.matchReplacement(test.s(), test.sub(), test.mappings()));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (TestData test : tests) bh.consume(sol2.matchReplacement(test.s(), test.sub(), test.mappings()));
    }

    @Benchmark
    public void sol3(Blackhole bh) {
        for (TestData test : tests) bh.consume(sol3.matchReplacement(test.s(), test.sub(), test.mappings()));
    }

    @Setup
    public void setup() {
        XorShift64 rng = new XorShift64(1);
        int numberOfTest = 1_000_000 / n;
        tests = new TestData[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            Random random = new Random(rng.nextLong());
            tests[i] = SolutionTest.generateTestData(random, n, n / 2);
        }
    }
}

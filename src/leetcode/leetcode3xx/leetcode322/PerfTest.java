package leetcode.leetcode3xx.leetcode322;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import prng.XorShift64;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {

    private static final int BATCH_SIZE = 1000;
    @Param({"1000", "10000"})
    private int n;

    @Param({"2", "5", "10", "100"})
    private int k;

    private TestData[] testData;

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (TestData data : testData) bh.consume(solution.coinChange(data.coins(), data.amount()));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (TestData data : testData) bh.consume(solution2.coinChange(data.coins(), data.amount()));
    }

    @Setup
    public void setup() {
        XorShift64 random = new XorShift64(1);
        testData = new TestData[BATCH_SIZE];
        for (int i = 0; i < BATCH_SIZE; i++) testData[i] = TestData.generate(random.nextLong(), k, k, n, n);
    }
}

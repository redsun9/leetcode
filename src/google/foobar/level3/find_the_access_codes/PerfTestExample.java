package google.foobar.level3.find_the_access_codes;

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
@Warmup(iterations = 10, time = 5)
@Measurement(iterations = 10, time = 5)
public class PerfTestExample {
    private static final int n = 2000;
    private static final int numberOfTests = 100;
    private final int[][] tests = new int[numberOfTests][n];

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTestExample.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[] test : tests) bh.consume(Answer.answer(test));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int[] test : tests) bh.consume(Answer.answer2(test));
    }

    @Setup
    public void setup() {
        Random random = new Random();
        for (int[] test : tests) for (int i = 0; i < n; i++) test[i] = random.nextInt(1, 1_000_000);
    }
}

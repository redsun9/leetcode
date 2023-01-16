package help_requests.digital_logarithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class LogarithmBenchmark {
    private static final int MAX_VAL = 1_000_000_000;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(LogarithmBenchmark.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int i = 1; i < MAX_VAL; i++) bh.consume(Solution.f1(i));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int i = 1; i < MAX_VAL; i++) bh.consume(Solution.f2(i));
    }

    @Benchmark
    public void sol3(Blackhole bh) {
        for (int i = 1; i < MAX_VAL; i++) bh.consume(Solution.f3(i));
    }

    @Benchmark
    public void sol4(Blackhole bh) {
        for (int i = 1; i < MAX_VAL; i++) bh.consume(Solution.f4(i));
    }
}

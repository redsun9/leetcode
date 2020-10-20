package basic.utils;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class UuidToolsPerf {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(UuidToolsPerf.class.getCanonicalName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        bh.consume(UuidUTools.getRandomUuidWithoutDashesLower());
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        bh.consume(UuidUTools.getRandomUuidWithoutDashesUpper());
    }

    @Benchmark
    public void sol3(Blackhole bh) {
        bh.consume(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @Benchmark
    public void sol4(Blackhole bh) {
        bh.consume(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
    }
}

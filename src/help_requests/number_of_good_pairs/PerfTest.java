package help_requests.number_of_good_pairs;

import basic.utils.ArrayTools;
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
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    private static final int BATCH_SIZE = 100;

    @Param({"10", "100", "1000"})
    private int n;

    private int[][][] tests;


//    Benchmark       (n)  Mode  Cnt    Score    Error  Units
//    PerfTest.sol1    10  avgt   10    0,020 ±  0,001  ms/op
//    PerfTest.sol1   100  avgt   10    2,319 ±  0,061  ms/op
//    PerfTest.sol1  1000  avgt   10  232,152 ±  8,995  ms/op
//    PerfTest.sol2    10  avgt   10    0,079 ±  0,001  ms/op
//    PerfTest.sol2   100  avgt   10    1,350 ±  0,050  ms/op
//    PerfTest.sol2  1000  avgt   10   19,100 ±  0,731  ms/op

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int[][] test : tests) bh.consume(DummySolution.numberOfGoodPairs(test[0], test[1]));
        //bh.consume(1);
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int[][] test : tests) bh.consume(Solution.numberOfGoodPairs(test[0], test[1]));
    }

    @Setup
    public void setup() {
        tests = new int[BATCH_SIZE][2][n];
        Random random = new Random(0L);
        for (int[][] test : tests) {
            test[0] = ArrayTools.naturalArray(n);
            test[1] = ArrayTools.naturalArray(n);
            ArrayTools.shuffle(test[0], random);
            ArrayTools.shuffle(test[1], random);
        }
    }
}

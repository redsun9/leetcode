package help_requests.colour_fill;

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
    @Param({"100", "1000", "10000"})
    private int n;

    @Param({"1", "2", "5", "100"})
    private int k;

    private int[][] mat;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(PerfTest.class.getCanonicalName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void solDFS(Blackhole bh) {
        setup();
        bh.consume(Solution2.numberOfFills(mat));
    }

    @Benchmark
    public void solBFS(Blackhole bh) {
        setup();
        bh.consume(Solution3.numberOfFills(mat));
    }

    @Benchmark
    public void solLineScanning(Blackhole bh) {
        setup();
        bh.consume(Solution4.numberOfFills(mat));
    }

    @Benchmark
    public void solDSU(Blackhole bh) {
        setup();
        bh.consume(Solution5.numberOfFills(mat));
    }

    public void setup() {
        mat = new int[n][n];
        Random random = new Random();
        for (int[] row : mat) for (int i = 0; i < n; i++) row[i] = 1 + random.nextInt(k);
    }
}

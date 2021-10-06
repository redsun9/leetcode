package leetcode.leetcode3xx.leetcode311;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//Benchmark        (p)       (sizes)  Mode  Cnt      Score     Error  Units
//PerfTest.sol1  0.001  1000,100,100  avgt    5    306.388 ±  62.889  ms/op
//PerfTest.sol1  0.001  100,1000,100  avgt    5    199.575 ±  23.198  ms/op
//PerfTest.sol1  0.001  100,100,1000  avgt    5    570.570 ±   3.255  ms/op
//PerfTest.sol1   0.01  1000,100,100  avgt    5    844.957 ±   2.908  ms/op
//PerfTest.sol1   0.01  100,1000,100  avgt    5   1078.183 ±  10.245  ms/op
//PerfTest.sol1   0.01  100,100,1000  avgt    5   1241.254 ±  57.040  ms/op
//PerfTest.sol1    0.1  1000,100,100  avgt    5  10396.545 ± 181.408  ms/op
//PerfTest.sol1    0.1  100,1000,100  avgt    5   9141.708 ± 600.229  ms/op
//PerfTest.sol1    0.1  100,100,1000  avgt    5  10765.990 ±  98.475  ms/op
//PerfTest.sol2  0.001  1000,100,100  avgt    5    186.980 ±   2.695  ms/op
//PerfTest.sol2  0.001  100,1000,100  avgt    5    179.087 ±   1.326  ms/op
//PerfTest.sol2  0.001  100,100,1000  avgt    5    283.019 ±   1.163  ms/op
//PerfTest.sol2   0.01  1000,100,100  avgt    5    248.600 ±   8.840  ms/op
//PerfTest.sol2   0.01  100,1000,100  avgt    5    220.661 ±   2.117  ms/op
//PerfTest.sol2   0.01  100,100,1000  avgt    5    325.121 ±   6.555  ms/op
//PerfTest.sol2    0.1  1000,100,100  avgt    5    619.688 ±  44.811  ms/op
//PerfTest.sol2    0.1  100,1000,100  avgt    5    478.093 ±   3.597  ms/op
//PerfTest.sol2    0.1  100,100,1000  avgt    5    793.038 ±  17.240  ms/op


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, batchSize = 10)
@Measurement(iterations = 5, time = 1, batchSize = 10)
public class PerfTest {
    private static final int BATCH_SIZE = 100;
    private static final Solution solution = new Solution();
    private static final Solution2 solution2 = new Solution2();

    private int[][][] testA;
    private int[][][] testB;

    @Param({"1000,100,100", "100,1000,100", "100,100,1000"})
    private String sizes;

    @Param({"0.001", "0.01", "0.1"})
    private double p;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) bh.consume(solution.multiply(testA[i], testB[i]));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) bh.consume(solution2.multiply(testA[i], testB[i]));
    }

    @Setup
    public void setup() {
        Random random = new Random(0);
        String[] split = sizes.split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);

        testA = new int[BATCH_SIZE][m][k];
        testB = new int[BATCH_SIZE][k][n];

        for (int[][] mat : testA) {
            for (int[] row : mat) {
                for (int i = 0; i < k; i++) {
                    if (random.nextDouble() <= p) row[i] = 1 + random.nextInt(100);
                }
            }
        }

        for (int[][] mat : testB) {
            for (int[] row : mat) {
                for (int i = 0; i < n; i++) {
                    if (random.nextDouble() <= p) row[i] = 1 + random.nextInt(100);
                }
            }
        }
    }
}
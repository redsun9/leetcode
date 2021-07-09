package leetcode.leetcode3xx.leetcode378;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//Benchmark                       (mode)    (n)  Mode  Cnt    Score   Error  Units
//SolutionTest.binarySearch   first half    100  avgt    5    0,066 ± 0,018  ms/op
//SolutionTest.binarySearch   first half   1000  avgt    5    1,381 ± 0,145  ms/op
//SolutionTest.binarySearch   first half  10000  avgt    5   61,038 ± 1,869  ms/op
//SolutionTest.binarySearch  second half    100  avgt    5    0,064 ± 0,002  ms/op
//SolutionTest.binarySearch  second half   1000  avgt    5    1,646 ± 0,096  ms/op
//SolutionTest.binarySearch  second half  10000  avgt    5   71,744 ± 1,740  ms/op
//SolutionTest.binarySearch       middle    100  avgt    5    0,072 ± 0,002  ms/op
//SolutionTest.binarySearch       middle   1000  avgt    5    1,820 ± 0,093  ms/op
//SolutionTest.binarySearch       middle  10000  avgt    5   75,182 ± 1,870  ms/op
//SolutionTest.binarySearch       random    100  avgt    5    0,066 ± 0,017  ms/op
//SolutionTest.binarySearch       random   1000  avgt    5    1,747 ± 0,332  ms/op
//SolutionTest.binarySearch       random  10000  avgt    5   64,135 ± 1,024  ms/op
//SolutionTest.biselect       first half    100  avgt    5    0,991 ± 0,041  ms/op
//SolutionTest.biselect       first half   1000  avgt    5    8,892 ± 0,981  ms/op
//SolutionTest.biselect       first half  10000  avgt    5  101,525 ± 2,972  ms/op
//SolutionTest.biselect      second half    100  avgt    5    0,914 ± 0,013  ms/op
//SolutionTest.biselect      second half   1000  avgt    5    8,518 ± 0,212  ms/op
//SolutionTest.biselect      second half  10000  avgt    5  107,571 ± 5,151  ms/op
//SolutionTest.biselect           middle    100  avgt    5    0,943 ± 0,033  ms/op
//SolutionTest.biselect           middle   1000  avgt    5    8,394 ± 0,164  ms/op
//SolutionTest.biselect           middle  10000  avgt    5  107,336 ± 3,598  ms/op
//SolutionTest.biselect           random    100  avgt    5    0,965 ± 0,008  ms/op
//SolutionTest.biselect           random   1000  avgt    5    8,679 ± 0,340  ms/op
//SolutionTest.biselect           random  10000  avgt    5  103,463 ± 4,472  ms/op

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 10)
@Measurement(iterations = 5, time = 2)
public class SolutionTest {
    private final int BATCH_SIZE = 20;
    private final int[][][] matrices = new int[BATCH_SIZE][][];
    private final int[] k = new int[BATCH_SIZE];
    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    @Param({"100", "1000", "10000"})
    private int n;

    @Param({"first half", "second half", "middle", "random"})
    private String mode;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void binarySearch(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) {
            bh.consume(solution.kthSmallest(matrices[i], k[i]));
        }
    }

    @Benchmark
    public void biselect(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) {
            bh.consume(solution2.kthSmallest(matrices[i], k[i]));
        }
    }

    @Setup
    public void setup() {
        IntStream.range(0, BATCH_SIZE).forEach(t -> {
            int[][] matrix = new int[n][n];
            Random random = new Random(n + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (i + j) * 20 + random.nextInt(10);
                }
            }
            int m = n * n;
            switch (mode) {
                case "first half" -> k[t] = 1 + random.nextInt(m / 2);
                case "second half" -> k[t] = m - random.nextInt(m / 2);
                case "middle" -> k[t] = m / 4 + random.nextInt(m / 2);
                case "random" -> k[t] = 1 + random.nextInt(m);
            }
            matrices[t] = matrix;
        });

    }
}
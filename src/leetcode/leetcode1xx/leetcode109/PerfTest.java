package leetcode.leetcode1xx.leetcode109;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/*
    PerfTest.sol1                    100    avgt      10     0,001 ±  0,001   ms/op
    PerfTest.sol1                   1000    avgt      10     0,006 ±  0,001   ms/op
    PerfTest.sol1                  10000    avgt      10     0,072 ±  0,011   ms/op
    PerfTest.sol1                 100000    avgt      10     0,766 ±  0,006   ms/op
    PerfTest.sol1                1000000    avgt      10    13,823 ±  0,371   ms/op
    PerfTest.sol1               10000000    avgt      10   149,063 ± 67,052   ms/op
    PerfTest.sol2                    100    avgt      10     0,001 ±  0,001   ms/op
    PerfTest.sol2                   1000    avgt      10     0,015 ±  0,001   ms/op
    PerfTest.sol2                  10000    avgt      10     0,174 ±  0,001   ms/op
    PerfTest.sol2                 100000    avgt      10     2,095 ±  0,004   ms/op
    PerfTest.sol2                1000000    avgt      10    37,242 ±  0,788   ms/op
    PerfTest.sol2               10000000    avgt      10   329,471 ± 16,403   ms/op
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 1, batchSize = 100)
@Measurement(iterations = 10, time = 1)
public class PerfTest {
    @Param({"100", "1000", "10000", "100000", "1000000", "10000000"})
    private int n;
    private ListNode list;
    private final Solution solution1 = new Solution();
    private final Solution2 solution2 = new Solution2();


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void sol1(Blackhole bh) {
        bh.consume(solution1.sortedListToBST(list));
    }

    @Benchmark
    public void sol2(Blackhole bh) {
        bh.consume(solution2.sortedListToBST(list));
    }

    @Setup
    public void setup() {
        list = LeetcodeUtils.initializeList(new int[n]);
    }
}

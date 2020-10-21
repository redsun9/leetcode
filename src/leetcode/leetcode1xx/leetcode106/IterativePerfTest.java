package leetcode.leetcode1xx.leetcode106;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static leetcode.tools.LeetcodeUtils.*;

/*
Benchmark                        (n)  (typeOfTrees)  Mode  Cnt      Score     Error  Units
IterativePerfTest.iterative       10       balanced  avgt   10      0,046 ±   0,001  ms/op
IterativePerfTest.iterative       10         random  avgt   10      0,041 ±   0,001  ms/op
IterativePerfTest.iterative       10    degenerated  avgt   10      0,041 ±   0,001  ms/op
IterativePerfTest.iterative      100       balanced  avgt   10      0,754 ±   0,002  ms/op
IterativePerfTest.iterative      100         random  avgt   10      0,755 ±   0,002  ms/op
IterativePerfTest.iterative      100    degenerated  avgt   10      0,839 ±   0,004  ms/op
IterativePerfTest.iterative     1000       balanced  avgt   10      7,626 ±   0,035  ms/op
IterativePerfTest.iterative     1000         random  avgt   10      7,676 ±   0,021  ms/op
IterativePerfTest.iterative     1000    degenerated  avgt   10      8,070 ±   0,048  ms/op
IterativePerfTest.iterative    10000       balanced  avgt   10     95,828 ±   0,313  ms/op
IterativePerfTest.iterative    10000         random  avgt   10     94,222 ±   0,503  ms/op
IterativePerfTest.iterative    10000    degenerated  avgt   10     98,272 ±   0,397  ms/op
IterativePerfTest.iterative   100000       balanced  avgt   10    866,036 ±  31,107  ms/op
IterativePerfTest.iterative   100000         random  avgt   10    881,416 ±   6,889  ms/op
IterativePerfTest.iterative   100000    degenerated  avgt   10    946,581 ±  10,837  ms/op
IterativePerfTest.iterative  1000000       balanced  avgt   10  10701,916 ± 171,583  ms/op
IterativePerfTest.iterative  1000000         random  avgt   10  10163,144 ± 221,718  ms/op
IterativePerfTest.iterative  1000000    degenerated  avgt   10  10582,983 ± 238,721  ms/op
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
public class IterativePerfTest {
    private final int BATCH_SIZE = 100;
    private final Solution2 solution = new Solution2();

    private final TreeNode[] tests = new TreeNode[BATCH_SIZE];
    private final int[][] inorders = new int[BATCH_SIZE][];
    private final int[][] postorders = new int[BATCH_SIZE][];

    @Param({"10", "100", "1000", "10000", "100000", "1000000"})
    private int n;
    @Param({"balanced", "random", "degenerated"})
    private String typeOfTrees;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(IterativePerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void iterative(Blackhole bh) {
        for (int i = 0; i < BATCH_SIZE; i++) {
            bh.consume(solution.buildTree(inorders[i], postorders[i]));
        }
    }

    @Setup
    public void setup() {
        IntStream.range(0, BATCH_SIZE).parallel().forEach(t -> {
            tests[t] = switch (typeOfTrees) {
                case "balanced" -> generateBalancedTree(0, 1000000, n, ThreadLocalRandom.current());
                case "random" -> generateRandomTree(0, 1000000, n, ThreadLocalRandom.current());
                case "degenerated" -> generateDegenerateTree(0, 1000000, n, ThreadLocalRandom.current());
                default -> null;
            };
            List<Integer> inOrderValues = LeetcodeUtils.getInOrderValues(tests[t]);
            List<Integer> postOrderValues = LeetcodeUtils.getPostOrderValues(tests[t]);
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            Iterator<Integer> inOrderIterator = inOrderValues.iterator();
            Iterator<Integer> postOrderIterator = postOrderValues.iterator();
            for (int i = 0; i < n; i++) {
                inorder[i] = inOrderIterator.next();
                postorder[i] = postOrderIterator.next();
            }
            inorders[t] = inorder;
            postorders[t] = postorder;
        });
    }
}

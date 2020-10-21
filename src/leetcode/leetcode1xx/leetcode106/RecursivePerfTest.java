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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class RecursivePerfTest {
    private final int BATCH_SIZE = 100;
    private final Solution solution = new Solution();

    private final TreeNode[] tests = new TreeNode[BATCH_SIZE];
    private final int[][] inorders = new int[BATCH_SIZE][];
    private final int[][] postorders = new int[BATCH_SIZE][];

    @Param("1")
    private int n;
    private static final int[] nValues = {10, 100, 1000, 10000, 100000, 1000000};


    @Param("")
    private String typeOfTrees;
    private static final String[] typeOfTreeValues = {"balanced", "random", "degenerated"};

    public static void main(String[] args) throws RunnerException {
        for (int nValue : nValues) {
            for (String typeOfTreeValue : typeOfTreeValues) {
                if (nValue <= 1000 || !typeOfTreeValue.equals("degenerated")) {
                    Options opt = new OptionsBuilder()
                            .include(RecursivePerfTest.class.getCanonicalName())
                            .param("n", Integer.toString(nValue))
                            .param("typeOfTrees", typeOfTreeValue)
                            .forks(1)
                            .build();
                    new Runner(opt).runSingle();
                }
            }
        }
    }

    @Benchmark
    public void recursive(Blackhole bh) {
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

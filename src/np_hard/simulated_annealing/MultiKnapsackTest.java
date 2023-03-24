package np_hard.simulated_annealing;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiKnapsackTest {

    @Test
    void solve() throws InterruptedException {
        int m = 10;
        int n = 10;
        int sum = 1_000;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(m, n, sum, seed),
                items -> MultiKnapsack.solve(items, m),
                (testData, ans) -> check(ans, sum),
                10_000,
                1,
                100
        ));
    }

    private static boolean check(int[][] ans, int sum) {
        int m = ans.length;
        int n = ans[0].length;
        int[] sums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) sums[i] += ans[i][j];
        }
        long distance = 0;
        for (int[] knapsack : ans) {
            long tmp = 0;
            for (int j = 0; j < n; j++) tmp += knapsack[j];
            distance += (tmp - sum) * (tmp - sum);
        }
        if (distance == 0) return true;
        System.out.println(Arrays.deepToString(ans));
        System.out.println(Arrays.toString(sums));
        System.out.println(distance);
        return false;
    }

    //uniformly generate n numbers that sum up to sum
    //use stars and bars method
    //to do this we need generate n-1 numbers between 1 and sum-1
    private static int[] generate(int m, int n, int sum, long seed) {
        Random random = new Random(seed);
        int[] testData = new int[m * n];
        for (int i = 0; i < m; i++) {
            int[] tmp = generate(n, sum, random);
            System.arraycopy(tmp, 0, testData, i * n, n);
        }
        return testData;
    }

    private static int[] generate(int n, int sum, Random random) {
        Set<Integer> set = new HashSet<>();
        int[] tmp = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int next = random.nextInt(sum - 1) + 1;
            while (set.contains(next)) next = random.nextInt(sum - 1) + 1;
            set.add(next);
            tmp[i] = next;
        }
        Arrays.sort(tmp);
        int[] ans = new int[n];
        ans[0] = tmp[0];
        for (int i = 1; i < n - 1; i++) ans[i] = tmp[i] - tmp[i - 1];
        ans[n - 1] = sum - tmp[n - 2];
        return ans;
    }
}
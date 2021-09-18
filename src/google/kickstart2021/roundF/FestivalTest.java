package google.kickstart2021.roundF;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class FestivalTest {
    private static final int n = 10, k = 3, d = 10, maxH = 10;

    @Test
    @Disabled
    void test1() throws InterruptedException {
        StressTester.exactStressTest(
                FestivalTest::generateTestCase,
                triples -> {
                    long ans = 0;
                    for (int i = 0; i < d; i++) {
                        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
                        for (int[] triple : triples) if (triple[1] <= i && triple[2] >= i) q.offer(triple[0]);
                        int temp = 0;
                        int count = 0;
                        while (count++ < k && !q.isEmpty()) temp += q.poll();
                        ans = Math.max(ans, temp);
                    }
                    return ans;
                },
                triples -> Festival.solve(triples, k)
        );
    }

    private static int[][] generateTestCase(long seed) {
        Random random = new Random(seed);
        int[][] triples = new int[n][];
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(d);
            int b = random.nextInt(d);
            int h = 1 + random.nextInt(maxH);
            triples[i] = new int[]{h, Math.min(a, b), Math.max(a, b), i};
        }
        return triples;
    }


    public static void main(String[] args) {
        Random random = new Random(1657646152127445526L);
        int[][] triples = generateTestCase(1657646152127445526L);
        for (int[] t : triples) {
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
        System.out.println();
        System.out.println(Festival.solve(triples, k));
    }
}
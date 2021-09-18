package google.kickstart2021.roundF;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.*;

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
                        for (Festival.Triple triple : triples) {
                            if (triple.s <= i && triple.e >= i) q.offer(triple.h);
                        }
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

    private static List<Festival.Triple> generateTestCase(long seed) {
        Random random = new Random(seed);
        List<Festival.Triple> triples = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(d);
            int b = random.nextInt(d);
            int h = 1 + random.nextInt(maxH);
            triples.add(new Festival.Triple(h, Math.min(a, b), Math.max(a, b), i));
        }
        return triples;
    }


    public static void main(String[] args) {
        Random random = new Random(1657646152127445526L);
        List<Festival.Triple> triples = generateTestCase(1657646152127445526L);
        for (Festival.Triple t : triples) {
            System.out.println(t.h + " " + t.s + " " + t.e);
        }
        System.out.println();
        System.out.println(Festival.solve(triples, k));
    }
}
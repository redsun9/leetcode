package codeforces.contest1769;

import stress.StressTester;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static codeforces.contest1769.ProblemD1.solve;

@SuppressWarnings("DuplicatedCode")
public class Generator {
    private static final long allCards = (1L << 36) - 1;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Long> map = new ConcurrentHashMap<>();
        StressTester.constructionStressTest(
                Generator::generateBiased,
//                Generator::generateRandom,
                a -> {
                    HashMap<ProblemD1.State, Integer> cache = new HashMap<>();
                    return Math.abs(solve(a, allCards ^ a, cache) + solve(allCards ^ a, a, cache));
                },
                (a, val) -> {
                    if (!map.containsKey(val)) {
                        System.out.println("added " + val + " = " + a);
                        map.put(val, a);
                        System.out.println(map.keySet().stream().toList());
                        System.out.println(map.size() + " " + map.values());
                        System.out.println();
                    }
                    return true;
                }
        );
    }
    // 5373161447, 1382280311, 1210838518, 44059815781, 14028073719, 5404553143, 1281609653,
    // 3224890711, 1629679605, 22551113207, 1617161463, 9674387443, 3290623987, 3257132983,
    // 1751377843, 1126395891, 1093134263, 1097068405, 5371063799, 44025767923, 1084485591,
    // 1143205875, 1612935159, 1080291287, 1080291303, 1076097015

    private static long generateRandom(long seed) {
        Random random = new Random(seed);
        long a = 0L;
        int k = 18, n = 36;
        while (k != 0) if (random.nextInt(n--) < k) {
            a |= 1L << n;
            k--;
        }
        return a;
    }

    //for random swaps can cover all cases
    private static long generateBiased(long seed) {
        Random random = new Random(seed);
        long a = ((1L << 18) - 1) ^ (1L << 3) ^ (1L << 12) ^ (1L << 21) ^ (1L << 30);
        for (int k = 0; k < 4; k++) {
            int i = random.nextInt(36), j = random.nextInt(36);
            a = a ^ (a & 1L << i) ^ (a & 1L << j) ^ ((a >> i & 1) << j) ^ ((a >> j & 1) << i);
        }
        return a;
    }
}


package random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

class HyperLogLogTest {

    @Test
    @Disabled
    void test() {
        int maxLevel = 11;
        HyperLogLog[] hlls = new HyperLogLog[maxLevel];
        for (int i = 0; i < maxLevel; i++) hlls[i] = new HyperLogLog(i);

        Set<Integer> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        Random random = new Random();
        int multiplier = 2;
        for (int i = 0, m = 0, nextM = multiplier; i < 30; i++, m = nextM, nextM *= multiplier) {
            IntStream.range(m, nextM).parallel().map(t -> random.nextInt()).forEach(a -> {
                set.add(a);
                for (int j = 0; j < maxLevel; j++) hlls[j].add(a);
            });
            System.out.println("n = " + nextM);
            int expected = set.size();
            System.out.println("expected - " + expected);
            for (int k = 0; k < maxLevel; k++) {
                System.out.println(k + " " + (hlls[k].size() - expected) * 100f / expected);
            }
            System.out.println();
        }

    }
}
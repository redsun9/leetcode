package leetcode.leetcode3xx.leetcode322;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

record TestData(int[] coins, int amount) {
    static TestData generate(long seed, int kMin, int kMax, int amountMin, int amountMax) {
        Random random = new Random(seed);
        int amount = amountMin + random.nextInt(amountMax - amountMin + 1);
        int k = kMin + random.nextInt(kMax - kMin + 1);
        k = Math.min(k, amount);
        int[] coins = new int[k];
        Set<Integer> set = new HashSet<>();
        while (set.size() < k) {
            int coin = 1 + random.nextInt(amount);
            if (set.add(coin)) coins[set.size() - 1] = coin;
        }
        Arrays.sort(coins);
        return new TestData(coins, amount);
    }

    @Override
    public String toString() {
        return "amount = " + amount + ", coins = " + Arrays.toString(coins);
    }
}

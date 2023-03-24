package np_hard.simulated_annealing;

import basic.utils.ArrayTools;
import prng.XorShift64;

import java.util.Arrays;
import java.util.Random;

public class MultiKnapsack {
    // distribute m*n elements to m basket, so each basket has n elements
    // and sum_{i,j} = (sum(i)-sum(j))^2 is minimum or in other words min sum(sum(i)^2))
    public static int[][] solve(int[] items, int m) {
        final int totalSimulations = 10000;
        int totalItems = items.length;
        int n = totalItems / m;

        long totalSum = 0;
        for (int item : items) totalSum += item;
        long minPossibleEnergy = (totalSum % m) * (totalSum / m + 1) * (totalSum / m + 1) +
                (m - totalSum % m) * (totalSum / m) * (totalSum / m);

        Arrays.sort(items);
        long maxPossibleEnergy = 0, tmp = 0;
        for (int i = 0; i < totalItems; i++) {
            tmp += items[i];
            if (i % n == n - 1) {
                maxPossibleEnergy += tmp * tmp;
                tmp = 0;
            }
        }

        int[][] bestAns = null;
        long bestEnergy = Long.MAX_VALUE;
        XorShift64 random = new XorShift64(1L);

        for (int i = 0; i < totalSimulations && bestEnergy != minPossibleEnergy; i++) {
            AnnealingResult annealingResult = simulate(items, m, n, maxPossibleEnergy, minPossibleEnergy, random.nextLong());
            if (annealingResult.energy < bestEnergy) {
                bestEnergy = annealingResult.energy;
                bestAns = annealingResult.ans;
            }
        }
        return bestAns;
    }

    private static AnnealingResult simulate(int[] items, int m, int n, long maxPossibleEnergy, long minPossibleEnergy, long seed) {
        int totalItems = m * n;

        Random random = new Random(seed);
        int[] copyOfArr = Arrays.copyOf(items, totalItems);
        ArrayTools.shuffle(copyOfArr, random);
        int[][] ans = new int[m][n];
        for (int i = 0; i < totalItems; i++) ans[i / n][i % n] = copyOfArr[i];

        long[] sums = new long[m];
        long currentEnergy = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) sum += ans[i][j];
            sums[i] = sum;
            currentEnergy += sum * sum;
        }

        double temperature = maxPossibleEnergy;
        long totalIterations = 10L * totalItems * totalItems;
        double coefficient = 1.0 / Math.pow(temperature, 1.0 / totalIterations);
        int expectedTunneling = 5;
        double tunnelingCoefficient = 1.0 / totalIterations * expectedTunneling;

        for (long i = 0; i < totalIterations && currentEnergy != minPossibleEnergy; i++) {
            int a = random.nextInt(totalItems);
            int b = a;
            while (a / n == b / n) b = random.nextInt(totalItems);

            int i1 = a / n, j1 = a % n, i2 = b / n, j2 = b % n;
            if (ans[i1][j1] != ans[i2][j2]) {
                long sum1 = sums[i1], sum2 = sums[i2];
                int elem1 = ans[i1][j1], elem2 = ans[i2][j2];
                long newSum1 = sum1 - elem1 + elem2, newSum2 = sum2 - elem2 + elem1;
                long diff = newSum1 * newSum1 + newSum2 * newSum2 - sum1 * sum1 - sum2 * sum2;
                boolean shouldSwap = diff <= 0;
                if (diff > 0) {
                    double p = tunnelingCoefficient * Math.exp(-diff / temperature);
                    shouldSwap = random.nextDouble() < p;
                }
                if (shouldSwap) {
                    ans[i1][j1] = elem2;
                    ans[i2][j2] = elem1;
                    sums[i1] = newSum1;
                    sums[i2] = newSum2;
                    currentEnergy += diff;
                }
            }
            temperature *= coefficient;
        }
        return new AnnealingResult(ans, currentEnergy);
    }

    private record AnnealingResult(int[][] ans, long energy) {
    }
}

package leetcode.leetcode1362;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int[] closestDivisors(int num) {
        Map<Integer, Long> factors1 = primeFactors(num + 1).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int[] closest1 = findClosest(factors1, num + 1);

        Map<Integer, Long> factors2 = primeFactors(num + 2).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int[] closest2 = findClosest(factors2, num + 2);

        if (closest1[0] - closest1[1] <= closest2[0] - closest2[1]) return closest1;
        else return closest2;
    }

    public int[] findClosest(Map<Integer, Long> factors, int n) {
        int a = n, b = 1;
        int diff = n - 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        for (Map.Entry<Integer, Long> entry : factors.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue().intValue();
            int nextGen = queue.size();
            for (int i = 0; i < nextGen; i++) {
                Integer polled = queue.poll();
                for (int j = 0; j <= entryValue; j++) {
                    queue.add(polled);
                    polled *= entryKey;
                }
            }
        }
        for (Integer candidate : queue) {
            int t = n / candidate;
            int d = Math.abs(t - candidate);
            if (d < diff) {
                a = Math.max(t, candidate);
                b = Math.min(t, candidate);
                diff = d;
            }
        }

        return new int[]{a, b};
    }

    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

}

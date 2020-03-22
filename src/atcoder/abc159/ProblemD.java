package atcoder.abc159;

import java.util.HashMap;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        HashMap<Integer, Long> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ai = scanner.nextInt();
            a[i] = ai;
            count.put(ai, count.getOrDefault(ai, 0L) + 1);
        }
        long sum = 0;
        for (long value : count.values()) {
            sum += value * (value - 1) / 2;
        }
        for (int i = 0; i < n; i++) {
            long ac = count.get(a[i]);
            System.out.println(sum - (ac - 1));
        }
    }
}

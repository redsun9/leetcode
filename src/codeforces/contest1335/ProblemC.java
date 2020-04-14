package codeforces.contest1335;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            if (n <= 3) {
                System.out.println(n / 2);
                continue;
            }
            HashMap<Integer, Integer> countMap = new HashMap<>();
            int largest = 0;
            for (int ai : a) {
                int count = countMap.getOrDefault(ai, 0) + 1;
                largest = max(largest, count);
                countMap.put(ai, count);
            }
            int groups = countMap.size();
            System.out.println(max(min(largest, groups - 1), min(largest - 1, groups)));
        }
    }
}

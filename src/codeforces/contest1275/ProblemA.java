package codeforces.contest1275;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Pair> set = new HashSet<>();
        for (int a = 1; a <= n; a++) {
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int b = scanner.nextInt();
                if (!set.remove(new Pair(b, a))) set.add(new Pair(a, b));
            }
        }
        System.out.println(set.size());
        for (Pair pair : set) {
            System.out.println(pair.b + " " + pair.a);
        }
    }

    private record Pair(int a, int b) {
    }
}

package codeforces.contest1324;

import java.util.HashSet;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            HashSet<Integer> hashSet = new HashSet<>(2 * n);
            int previous = 0;
            int prePrevious = 100000;
            boolean answer = false;
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                if (!hashSet.add(a) && (previous != a || prePrevious == a)) answer = true;
                prePrevious = previous;
                previous = a;
            }
            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

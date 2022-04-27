package codeforces.contest1672;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int t = 0; t < numberOfTests; t++) {
            int n = scanner.nextInt();
            int left = -1, right = -1, previous = -1;
            for (int i = 0; i < n; i++) {
                int current = scanner.nextInt();
                if (current == previous) {
                    if (left == -1) left = i;
                    right = i;
                }
                previous = current;
            }
            int ans = right - left;
            if (ans <= 1) System.out.println(ans);
            else System.out.println(ans - 1);
        }
    }
}

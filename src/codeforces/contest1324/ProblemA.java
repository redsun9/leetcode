package codeforces.contest1324;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int counter = 0;
            for (int j = 0; j < n; j++) {
                counter += (scanner.nextInt() & 1);
            }
            if (counter == 0 || counter == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

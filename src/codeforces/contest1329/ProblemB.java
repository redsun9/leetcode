package codeforces.contest1329;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long d = scanner.nextInt();
            int m = scanner.nextInt();
            long tmp = Long.highestOneBit(d);
            long ans = d - tmp + 2;
            tmp >>= 1;
            while (tmp != 0 && ans != 0) {
                ans = ans * (tmp + 1) % m;
                tmp >>= 1;
            }
            ans = (ans + m - 1) % m;
            System.out.println(ans);
        }
    }
}

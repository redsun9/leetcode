package yandex.cup2021.algo.qual.problemB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());

        int[] count1 = new int[81];
        for (int i = 0; i < k; i++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int a = gc(s1.charAt(0));
            int b = gc(s1.charAt(1));
            int c = gc(s2.charAt(1));
            int d = gc(s2.charAt(0));
            count1[gt(a, b, c, d)]++;
        }

        String s = scanner.nextLine().strip();
        String[] parts = s.split(" ");
        int n = Integer.parseInt(parts[0]), m = Integer.parseInt(parts[1]);
        if (4 * k < n * m) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < n; i += 2) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            for (int j = 0; j < m; j += 2) {
                int a = gc(s1.charAt(j));
                int b = gc(s1.charAt(j + 1));
                int c = gc(s2.charAt(j + 1));
                int d = gc(s2.charAt(j));
                if (--count1[gt(a, b, c, d)] < 0) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

    private static int gc(char c) {
        if (c == 'W') return 0;
        if (c == 'B') return 1;
        else return 2;
    }

    private static int gt(int a, int b, int c, int d) {
        return Math.min(
                Math.min(a + b * 3 + c * 9 + d * 27, b + c * 3 + d * 9 + a * 27),
                Math.min(c + d * 3 + a * 9 + b * 27, d + a * 3 + b * 9 + c * 27)
        );
    }
}

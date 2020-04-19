package atcoder.abc163;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = 0;
        for (int i = 0; i < m; i++) {
            a += scanner.nextInt();
        }
        System.out.println(Math.max(-1, n - a));
    }
}

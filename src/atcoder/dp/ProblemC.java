package atcoder.dp;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prev = new int[3];
        int[] next = new int[3];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            next[0] = a + Math.max(prev[1], prev[2]);
            next[1] = b + Math.max(prev[0], prev[2]);
            next[2] = c + Math.max(prev[0], prev[1]);
            int[] tmp = next;
            next = prev;
            prev = tmp;
        }
        System.out.println(Math.max(prev[0], Math.max(prev[1], prev[2])));
    }
}

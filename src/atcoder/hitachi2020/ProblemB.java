package atcoder.hitachi2020;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ai = new int[a];
        int[] bi = new int[b];
        int minA = 1000001;
        int minB = 1000001;
        int tmp;
        for (int i = 0; i < a; i++) {
            tmp = scanner.nextInt();
            ai[i] = tmp;
            minA = Math.min(minA, tmp);
        }
        for (int i = 0; i < b; i++) {
            tmp = scanner.nextInt();
            bi[i] = tmp;
            minB = Math.min(minB, tmp);
        }
        int minCost = minA + minB;
        int x, y, c;
        for (int i = 0; i < m; i++) {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            c = scanner.nextInt();
            minCost = Math.min(minCost, ai[x] + bi[y] - c);
        }
        System.out.println(minCost);
    }
}

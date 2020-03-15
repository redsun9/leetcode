package codeforces.contest1325;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long u = scanner.nextLong();
        long v = scanner.nextLong();
        if (((u ^ v) & 1) != 0 || u > v) {
            System.out.println(-1);
            return;
        }
        if (u == v) {
            if (u != 0) {
                System.out.println(1);
                System.out.println(u);
            } else {
                System.out.println(0);
            }
            return;
        }
        long x = (v - u) / 2;
        if ((u & x) != 0) {
            System.out.println(3);
            System.out.println(u + " " + x + " " + x);
        } else {
            System.out.println(2);
            System.out.println((u ^ x) + " " + x);
        }
    }
}

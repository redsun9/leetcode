package atcoder.abc160;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] p = new int[a];
        for (int i = 0; i < a; i++) {
            p[i] = scanner.nextInt();
        }
        int[] q = new int[b];
        for (int i = 0; i < b; i++) {
            q[i] = scanner.nextInt();
        }
        int[] r = new int[c];
        for (int i = 0; i < c; i++) {
            r[i] = scanner.nextInt();
        }
        Arrays.sort(p);
        Arrays.sort(q);
        Arrays.sort(r);
        //забеьем красные по максимуму
        int ci = c - 1;
        int ai = Math.max(0, a - x);
        if (x > a) ci -= (x - a);
        int bi = Math.max(0, b - y);
        if (y > b) ci -= (y - b);
        while (ci >= 0 && (ai < a && p[ai] < r[ci] || bi < b && q[bi] < r[ci])) {
            if (ai < a && bi < b) {
                if (p[ai] < q[bi]) {
                    ai++;
                    ci--;
                } else {
                    bi++;
                    ci--;
                }
            } else if (ai < a) {
                ai++;
                ci--;
            } else {
                bi++;
                ci--;
            }
        }

        long sum = 0;
        for (int i = ai; i < a; i++) {
            sum += p[i];
        }
        for (int i = bi; i < b; i++) {
            sum += q[i];
        }
        for (int i = ci + 1; i < c; i++) {
            sum += r[i];
        }
        System.out.println(sum);
    }
}

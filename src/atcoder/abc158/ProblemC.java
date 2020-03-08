package atcoder.abc158;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int la, ra;
        if ((a & 1) == 0) {
            la = a * 25 / 2;
            ra = (a + 1) * 25 / 2;
        } else {
            la = a * 25 / 2 + 1;
            ra = (a + 1) * 25 / 2 - 1;
        }

        int lb = b * 10;
        int rb = b * 10 + 9;

        if (la > rb || ra < lb) System.out.println(-1);
        else System.out.println(Math.max(la, lb));
    }
}

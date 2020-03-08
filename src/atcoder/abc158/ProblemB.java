package atcoder.abc158;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long res = n / (a + b) * a;
        long m = n % (a + b);
        if (m >= a) res += a;
        else res += m;
        System.out.println(res);
    }
}

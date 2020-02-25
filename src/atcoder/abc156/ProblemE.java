package atcoder.abc156;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(roaming(n, k));
    }

    public static int roaming(int n, int k) {
        int m = 1_000_000_007;
        BigInteger bigM = BigInteger.valueOf(m);
        if (k >= n - 1) {
            long factB = 1;
            for (int i = 2; i <= n - 1; i++) {
                factB = factB * i % m;
            }
            long topF = 1;
            for (int i = 2 * n - 1; i >= n + 1; i--) {
                topF = topF * i % m;
            }
            return BigInteger.valueOf(topF).multiply(BigInteger.valueOf(factB).modInverse(bigM)).mod(bigM).intValue();
        } else {
            BigInteger s = BigInteger.ONE;
            BigInteger tmp = BigInteger.ONE;
            for (int i = 1; i <= k; i++) {
                tmp = tmp.multiply(BigInteger.valueOf(n - i)).mod(bigM).multiply(BigInteger.valueOf(n - i + 1))
                        .multiply(BigInteger.valueOf(i).modInverse(bigM).pow(2));
                s = s.add(tmp).mod(bigM);
            }
            return s.intValue();
        }
    }
}

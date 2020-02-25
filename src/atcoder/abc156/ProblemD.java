package atcoder.abc156;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(bouquet(n, a, b));
    }

    public static int bouquet(int n, int a, int b) {
        int m = 1_000_000_007;
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger m2 = BigInteger.valueOf(1_000_000_005);
        BigInteger res = BigInteger.valueOf(2).modPow(BigInteger.valueOf(n), bigM);
        HashSet<Integer> neededFactorials = new HashSet<>();
        HashMap<Integer, BigInteger> calculatedFactorials = new HashMap<>();
        HashSet<Integer> neededTops = new HashSet<>();
        HashMap<Integer, BigInteger> calculatedTops = new HashMap<>();
        neededFactorials.add(a);
        neededFactorials.add(b);
        neededTops.add(n - a + 1);
        neededTops.add(n - b + 1);
        calculatedFactorials.put(0, BigInteger.ONE.modInverse(bigM));
        long tmp = 1;
        for (int i = 1; i <= Math.max(a, b); i++) {
            tmp = tmp * i % m;
            if (neededFactorials.contains(i)) {
                calculatedFactorials.put(i, BigInteger.valueOf(tmp).modInverse(bigM));
            }
        }
        tmp = 1;
        for (int i = n; i > n - Math.max(a, b); i--) {
            tmp = tmp * i % m;
            if (neededTops.contains(i)) {
                calculatedTops.put(i, BigInteger.valueOf(tmp));
            }
        }
        return res.subtract(
                calculatedTops.get(n - a + 1).multiply(calculatedFactorials.get(a))
        ).subtract(
                calculatedTops.get(n - b + 1).multiply(calculatedFactorials.get(b))
        ).subtract(BigInteger.ONE).mod(bigM).intValue();
    }
}

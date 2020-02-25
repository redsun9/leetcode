package atcoder.abc154;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        System.out.println(manyManyPaths(r1, c1, r2, c2));
    }

    public static int manyManyPaths(final int r1, final int c1, final int r2, final int c2) {
        final int m = 1_000_000_007;
        final BigInteger bigM = BigInteger.valueOf(m);
        HashSet<Integer> neededFactors = new HashSet<>();
        HashSet<Integer> neededReversedFactors = new HashSet<>();
        HashMap<Integer, BigInteger> calculatedFactors = new HashMap<>();
        HashMap<Integer, BigInteger> calculatedReversedFactors = new HashMap<>();
        neededFactors.add(c1 + r1);
        neededFactors.add(c1 + r2 + 1);
        neededFactors.add(c2 + r1 + 1);
        neededFactors.add(c2 + r2 + 2);
        neededReversedFactors.add(c1);
        neededReversedFactors.add(r1);
        neededReversedFactors.add(r2 + 1);
        neededReversedFactors.add(c2 + 1);
        calculatedFactors.put(0, BigInteger.ONE);
        calculatedFactors.put(1, BigInteger.ONE);
        calculatedReversedFactors.put(0, BigInteger.ONE);
        calculatedReversedFactors.put(1, BigInteger.ONE);

        long tmp = 1;
        for (int i = 2; i <= c2 + r2 + 2; i++) {
            tmp = tmp * i % m;
            if (neededFactors.contains(i)) {
                calculatedFactors.put(i, BigInteger.valueOf(tmp));
            }
            if (neededReversedFactors.contains(i)) {
                calculatedReversedFactors.put(i, BigInteger.valueOf(tmp).modInverse(bigM));
            }
        }
        return calculatedFactors.get(c1 + r1).multiply(calculatedReversedFactors.get(c1)).multiply(calculatedReversedFactors.get(r1))
                .subtract(calculatedFactors.get(c1 + r2 + 1).multiply(calculatedReversedFactors.get(c1)).multiply(calculatedReversedFactors.get(r2 + 1)))
                .subtract(calculatedFactors.get(c2 + r1 + 1).multiply(calculatedReversedFactors.get(c2 + 1)).multiply(calculatedReversedFactors.get(r1)))
                .add(calculatedFactors.get(c2 + r2 + 2).multiply(calculatedReversedFactors.get(c2 + 1)).multiply(calculatedReversedFactors.get(r2 + 1)))
                .mod(bigM).intValue();
    }
}

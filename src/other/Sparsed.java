package other;

import java.math.BigInteger;
import java.util.Scanner;

/*
    find n-th number which has only two bits set in 1
 */
public class Sparsed {
    private static final BigInteger p = new BigInteger("35184372089371");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < x; t++) {
            int k = Integer.parseInt(scanner.nextLine());
            int posOfFirst = (int) Math.ceil((Math.sqrt(8L * k + 1) + 1) / 2);
            BigInteger first = BigInteger.TWO.modPow(BigInteger.valueOf(posOfFirst - 1), p);
            int posOfSecond = k - 1 - ((posOfFirst - 1) * (posOfFirst - 2) / 2);
            BigInteger second = BigInteger.TWO.modPow(BigInteger.valueOf(posOfSecond), p);
            System.out.println(first.add(second).mod(p));
        }
    }
}

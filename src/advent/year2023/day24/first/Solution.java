package advent.year2023.day24.first;

import org.apache.commons.math3.fraction.BigFraction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class Solution {
    private final static BigFraction TEST_AREA_MIN = new BigFraction(200000000000000L);
    private final static BigFraction TEST_AREA_MAX = new BigFraction(400000000000000L);

//    private final static BigFraction TEST_AREA_MIN = new BigFraction(7);
//    private final static BigFraction TEST_AREA_MAX = new BigFraction(27);


    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day24/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day24/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day24/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<long[]> parseInput(Scanner scanner) {
        List<long[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (s.isBlank()) continue;
            String[] split = s.split("[, @]+");
            long[] arr = new long[6];
            for (int i = 0; i < 6; i++) arr[i] = Long.parseLong(split[i]);
            input.add(arr);
        }
        return input;
    }

    private static int solve(List<long[]> input) {
        int n = input.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            long[] a = input.get(i);
            for (int j = i + 1; j < n; j++) {
                long[] b = input.get(j);
                if (raysIntersects(
                        valueOf(a[0]), valueOf(a[1]), valueOf(a[3]), valueOf(a[4]),
                        valueOf(b[0]), valueOf(b[1]), valueOf(b[3]), valueOf(b[4])
                )) ans++;
            }
        }
        return ans;
    }

    private static boolean raysIntersects(
            BigInteger px1, BigInteger py1, BigInteger vx1, BigInteger vy1,
            BigInteger px2, BigInteger py2, BigInteger vx2, BigInteger vy2
    ) {
        BigFraction[] intersection = lineIntersection(
                vy1, vx1.negate(), vx1.multiply(py1).subtract(vy1.multiply(px1)),
                vy2, vx2.negate(), vx2.multiply(py2).subtract(vy2.multiply(px2))
        );

        if (intersection == null) return false;

        if (
                intersection[0].compareTo(TEST_AREA_MIN) < 0 ||
                        intersection[0].compareTo(TEST_AREA_MAX) > 0 ||
                        intersection[1].compareTo(TEST_AREA_MIN) < 0 ||
                        intersection[1].compareTo(TEST_AREA_MAX) > 0
        ) return false;

        BigFraction t1 = intersection[0].subtract(px1).divide(vx1);
        BigFraction t2 = intersection[0].subtract(px2).divide(vx2);
        if (t1.compareTo(BigFraction.ZERO) <= 0 || t2.compareTo(BigFraction.ZERO) <= 0) return false;

        return true;
    }

    // two lines in a form as ax+by+c=0
    private static BigFraction[] lineIntersection(
            BigInteger a1, BigInteger b1, BigInteger c1,
            BigInteger a2, BigInteger b2, BigInteger c2
    ) {
        BigInteger d = a1.multiply(b2).subtract(b1.multiply(a2));
        if (d.equals(ZERO)) return null;

        BigFraction x = new BigFraction(c2.multiply(b1).subtract(c1.multiply(b2)), d);
        BigFraction y = new BigFraction(a2.multiply(c1).subtract(a1.multiply(c2)), d);
        return new BigFraction[]{x, y};
    }
}

package atcoder.keyence2020;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemF {
    //TODO: this is incomplete
    public static final int m = 998_244_353;
    private static final BigInteger bigM = BigInteger.valueOf(m);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        scanner.nextLine();
        boolean[][] field = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                field[i][j] = s.charAt(j) == '#';
            }
        }
        System.out.println(numberOfDrawings(field));
    }

    public static int numberOfDrawings(boolean[][] field) {
        int h = field.length;
        int w = field[0].length;
        BigInteger[][] c = getC(Math.max(h, w));
        int[][] coeffs = getCoeffs(h, w, c);
        int[][] nRects = new int[h + 1][w + 1];
        int[] rowMask = IntStream.range(0, h).map(i -> IntStream.range(0, w).filter(j -> field[i][j]).map(j -> 1 << j).sum()).toArray();
        int[] colMask = IntStream.range(0, w).map(j -> IntStream.range(0, h).filter(i -> field[i][j]).map(i -> 1 << i).sum()).toArray();
        int badRowsMask = 0;
        int badColMask = 0;

        int fullColMask = (1 << (w)) - 1;
        int fullRowMask = (1 << (h)) - 1;
        for (int i = 0; i < h; i++) {
            if (
                    ((rowMask[i] & fullColMask) == 0)
                            ||
                            (((~rowMask[i]) & fullColMask) == 0)
            ) {
                badRowsMask |= 1 << i;
            }
        }

        for (int i = 0; i < w; i++) {
            if (
                    ((colMask[i] & fullRowMask) == 0)
                            ||
                            (((~colMask[i]) & fullRowMask) == 0)
            ) {
                badColMask |= 1 << i;
            }
        }

        for (int chosenRows = 1; chosenRows < 1 << h; chosenRows++) {
            if ((badRowsMask & chosenRows) != 0) continue;
            int bitH = Integer.bitCount(chosenRows);
            for (int chosenCols = 1; chosenCols < 1 << w; chosenCols++) {
                if ((badColMask & chosenCols) != 0) continue;
                boolean failed = false;
                for (int row = 0; row < h; row++) {
                    if (((1 << row) & chosenRows) != 0) {
                        if (
                                ((rowMask[row] & chosenCols) == 0)
                                        ||
                                        (((~rowMask[row]) & chosenCols) == 0)
                        ) {
                            failed = true;
                            break;
                        }
                    }
                }
                if (failed) continue;
                for (int col = 0; col < w; col++) {
                    if (((1 << col) & chosenCols) != 0) {
                        if (
                                ((colMask[col] & chosenRows) == 0)
                                        ||
                                        (((~colMask[col]) & chosenRows) == 0)
                        ) {
                            failed = true;
                            break;
                        }
                    }
                }
                if (failed) continue;
                System.out.println(Integer.toBinaryString(chosenRows) + " " + Integer.toBinaryString(chosenCols) + " ");
                int bitW = Integer.bitCount(chosenCols);
                nRects[bitH][bitW]++;
            }
        }

        long result = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (nRects[i][j] != 0) {
                    System.out.println(i + " " + j + " " + coeffs[h - i][w - j]);
                }
                if (i == h && j == w) {
                    result += getCoeffs2(h, w, 0, c).longValue();
                } else {
                    result += nRects[i][j] * coeffs[h - i][w - j];
                }
            }
        }
        System.out.println(cached);
        return (int) (result % m);
    }

    public static BigInteger[][] getC(int maxWH) {
        final BigInteger[][] c = new BigInteger[maxWH + 1][maxWH + 1];
        deepFill(c, BigInteger.ZERO);
        for (int i = 0; i <= maxWH; i++) {
            c[0][i] = BigInteger.ONE;
        }
        for (int i = 1; i <= maxWH; i++) {
            for (int j = i; j <= maxWH; j++) {
                c[i][j] = c[i - 1][j].multiply(BigInteger.valueOf(j - i + 1)).divide(BigInteger.valueOf(i));
            }
        }
        return c;
    }

    private static final boolean[][] transitions = new boolean[][]{ //i - после, j - до
            //       0      a      b      c      d      ab     cd     ac     bd
            {false, false, false, false, false, false, false, false, false}, //0
            {true, false, false, false, true, false, true, false, true}, //a
            {true, false, false, true, false, false, true, true, false}, //b
            {true, false, true, false, false, true, false, false, true}, //c
            {true, true, false, false, false, true, false, true, false}, //d
            {true, false, false, true, true, false, true, true, true}, //ab
            {true, true, true, false, false, true, false, true, true}, //cd
            {true, false, true, false, true, true, true, false, true}, //ac
            {true, true, false, true, false, true, true, true, false}, //bd
    };

    public static int[][] getCoeffs(int h, int w, BigInteger[][] c) {
        final int maxWH = Math.max(h, w);

        BigInteger[][][] coeffs = new BigInteger[h + 1][w + 1][9];
        deepFill(coeffs, BigInteger.ZERO);

        for (int i = 0; i < transitions.length; i++) {
            coeffs[0][0][i] = BigInteger.ONE;
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                for (int k = 0; k < transitions.length; k++) {
                    for (int l = 0; l < transitions[k].length; l++) {
                        if (transitions[k][l]) {
                            switch (k) {
                                case 0: //до этого был пустой
                                    break;
                                case 1: //до этого покрасиили несколько рядов белым
                                case 2: //до этого покрасиили несколько рядов черным
                                    for (int n = 1; n <= h - i; n++) {
                                        coeffs[i + n][j][l] = coeffs[i + n][j][l].add(coeffs[i][j][k].multiply(c[n][i + n]));
                                    }
                                    break;
                                case 3: //до этого покрасиили несколько стобцов белым
                                case 4: //до этого покрасиили несколько стобвоц черным
                                    for (int n = 1; n <= w - j; n++) {
                                        coeffs[i][j + n][l] = coeffs[i][j + n][l].add(coeffs[i][j][k].multiply(c[n][j + n]));
                                    }
                                    break;
                                case 5: //до этого покрасиили несколько рядов белым и черным
                                    for (int n = 1; n <= h - i - 1; n++) {
                                        for (int p = 1; p <= h - i - n; p++) {
                                            coeffs[i + n + p][j][l] = coeffs[i + n + p][j][l].add(coeffs[i][j][k].multiply(c[n][i + n + p]).multiply(c[p][i + p]));
                                        }
                                    }
                                    break;
                                case 6: //до этого покрасиили несколько столбцов белым и черным
                                    for (int n = 1; n <= w - j - 1; n++) {
                                        for (int p = 1; p <= w - j - n; p++) {
                                            coeffs[i][j + n + p][l] = coeffs[i][j + n + p][l].add(coeffs[i][j][k].multiply(c[n][j + n + p]).multiply(c[p][j + p]));
                                        }
                                    }
                                    break;
                                case 7: //до этого покрасиили несколько столбцов и строк белым
                                case 8: //до этого покрасиили несколько столбцов и строк черным
                                    for (int n = 1; n <= h - i; n++) {
                                        for (int p = 1; p <= w - j; p++) {
                                            coeffs[i + n][j + p][l] = coeffs[i + n][j + p][l].add(coeffs[i][j][k].multiply(c[n][i + n]).multiply(c[p][j + p]));
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }

        int[][] result = new int[h + 1][w + 1];
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                result[i][j] = coeffs[i][j][0].mod(bigM).intValue();
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public static HashMap<CacheKey, BigInteger> cached = new HashMap<>();

    public static BigInteger getCoeffs2(int h, int w, int k, BigInteger[][] c) {
        if (h == 0 || w == 0) return BigInteger.ONE;
        CacheKey cacheKey = new CacheKey(h, w, k);
        if (cached.containsKey(cacheKey)) {
            return cached.get(cacheKey);
        }
        if (h == 1) {
            BigInteger result = BigInteger.ONE.shiftLeft(w);
            if (k != 0) {
                result = result.subtract(BigInteger.ONE);
            }
            cached.put(cacheKey, result);
            return result;
        }
        if (w == 1) {
            BigInteger result = BigInteger.ONE.shiftLeft(h);
            if (k != 0) {
                result = result.subtract(BigInteger.ONE);
            }
            cached.put(cacheKey, result);
            return result;
        }
        BigInteger counter = BigInteger.ONE;
//        BigInteger counter = BigInteger.ZERO;

        for (int i = 0; i < transitions.length; i++) {
            if (transitions[i][k]) {
                switch (i) {
                    case 0: //до этого был пустой
                        break;
                    case 1: //до этого покрасиили несколько рядов белым
                    case 2: //до этого покрасиили несколько рядов черным
                        for (int n = 1; n < h; n++) {
                            counter = counter.add(getCoeffs2(h - n, w, i, c).multiply(c[n][h]));
                        }
                        break;
                    case 3: //до этого покрасиили несколько стобцов белым
                    case 4: //до этого покрасиили несколько стобвоц черным
                        for (int n = 1; n < w; n++) {
                            counter = counter.add(getCoeffs2(h, w - n, i, c).multiply(c[n][w]));
                        }
                        break;
                    case 5: //до этого покрасиили несколько рядов белым и черным
                        for (int n = 1; n < h - 1; n++) {
                            for (int p = 1; p < h - n; p++) {
                                counter = counter.add(getCoeffs2(h - n - p, w, i, c).multiply(c[n][h]).multiply(c[p][h - n]));
                            }
                        }
                        break;
                    case 6: //до этого покрасиили несколько столбцов белым и черным
                        for (int n = 1; n < w - 1; n++) {
                            for (int p = 1; p < w - n; p++) {
                                counter = counter.add(getCoeffs2(h, w - n - p, i, c).multiply(c[n][w]).multiply(c[p][w - n]));
                            }
                        }
                        break;
                    case 7: //до этого покрасиили несколько столбцов и строк белым
                    case 8: //до этого покрасиили несколько столбцов и строк черным
                        for (int n = 1; n < h; n++) {
                            for (int p = 1; p < w; p++) {
                                counter = counter.add(getCoeffs2(h - n, w - p, i, c).multiply(c[n][h]).multiply(c[p][w]));
                            }
                        }
                        break;
                }
            }
        }
        cached.put(cacheKey, counter);
        return counter;
    }

    public static void deepFill(Object[] arr, Object val) {
        if (isArray(arr[0])) {
            for (Object o : arr) {
                deepFill((Object[]) o, val);
            }
        } else {
            Arrays.fill(arr, val);
        }
    }

    public static boolean isArray(final Object obj) {
        return obj instanceof Object[] || obj instanceof boolean[] ||
                obj instanceof byte[] || obj instanceof short[] ||
                obj instanceof char[] || obj instanceof int[] ||
                obj instanceof long[] || obj instanceof float[] ||
                obj instanceof double[];
    }

    public static class CacheKey {
        private final int h;
        private final int w;
        private final int previousT;

        public CacheKey(int h, int w, int previousT) {
            this.h = h;
            this.w = w;
            this.previousT = previousT;
        }

        public int getH() {
            return h;
        }

        public int getW() {
            return w;
        }

        public int getPreviousT() {
            return previousT;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return h == cacheKey.h &&
                    w == cacheKey.w &&
                    previousT == cacheKey.previousT;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, w, previousT);
        }

        @Override
        public String toString() {
            return "{" + h + ", " + w + ", " + previousT + '}';
        }
    }
}

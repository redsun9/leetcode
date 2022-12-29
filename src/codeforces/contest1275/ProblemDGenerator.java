package codeforces.contest1275;

import static java.lang.Integer.bitCount;

public class ProblemDGenerator {
    private static final int cntMask = 0b001111100111110011111;
    private static final int colMask = 0b1000000100000010000001;
    private static final int rowMask = 0b1111111;

    public static void main(String[] args) {
        long[] cnt = new long[29];
        long[] nError = new long[29];
        long[] nLost = new long[29];

        for (int key = (1 << 28) - 1; key >= 0; key--) {
            int lost = 15 - countLost(key);
            int bits = 28 - bitCount(key);
            cnt[bits]++;
            if (lost != 0) {
                nError[bits]++;
                nLost[bits] += lost;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("private static final double[] prob = {");
        for (int i = 0; i <= 28; i++) {
            if (i != 0) sb.append(", ");
            sb.append((double) nError[i] / cnt[i]);
        }
        sb.append("};\n");
        sb.append("private static final double[] expect = {");
        for (int i = 0; i <= 28; i++) {
            if (i != 0) sb.append(", ");
            sb.append((double) nLost[i] / cnt[i]);
        }
        sb.append("};\n");
        System.out.println(sb);
    }

    private static int countLost(int key) {
        int prevKey;
        do {
            prevKey = key;
            for (int j = 0; j < 7; j++) if (bitCount(key & colMask << j) >= 3) key |= colMask << j;
            for (int i = 0; i < 4; i++) if (bitCount(key & (rowMask << (7 * i))) >= 5) key |= rowMask << (7 * i);
        } while (prevKey != key);
        return bitCount(key & cntMask);
    }
}

package prng;

public class XorShiftN {
    private static final int[][] s = {
            {4, 2, 1, 1}, {5, 3, 2, 4}, {6, 4, 3, 5}, {7, 5, 4, 6},
            {8, 1, 2, 5}, {9, 6, 7, 5}, {10, 5, 4, 3}, {11, 9, 8, 6},
            {12, 9, 7, 5}, {13, 7, 8, 4}, {14, 8, 9, 3}, {15, 9, 10, 3},
            {16, 11, 7, 7}, {17, 5, 8, 3}, {18, 7, 9, 3}, {19, 6, 7, 4},
            {20, 9, 13, 5}, {21, 9, 13, 4}, {22, 15, 17, 6}, {23, 4, 13, 2},
            {24, 13, 16, 7}, {25, 11, 19, 2}, {26, 11, 5, 7}, {27, 7, 9, 1},
            {28, 14, 17, 8}, {29, 5, 18, 2}, {30, 13, 18, 4}, {31, 13, 19, 3},
    };

    private int a;
    private final int mask;
    private final int s1;
    private final int s2;
    private final int s3;

    XorShiftN(int a, int bits, int s1, int s2, int s3) {
        if (bits < 4 || bits > 31) throw new IllegalArgumentException();
        this.mask = (1 << bits) - 1;
        this.a = a & mask;
        if (this.a == 0) throw new IllegalArgumentException();
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public XorShiftN(int a, int bits) {
        if (bits < 4 || bits > 31) throw new IllegalArgumentException();
        this.mask = (1 << bits) - 1;
        this.a = a & mask;
        if (this.a == 0) throw new IllegalArgumentException();
        this.s1 = s[bits - 4][1];
        this.s2 = s[bits - 4][2];
        this.s3 = s[bits - 4][3];
    }

    public int nextInteger() {
        a ^= a << s1;
        a ^= a >> s2;
        a ^= a << s3;
        return a &= mask;
    }
}

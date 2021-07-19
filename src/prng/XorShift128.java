package prng;

//has period of 2^128-1
public class XorShift128 {
    private int a, b, c, d, t;

    public XorShift128(int a, int b, int c, int d) {
        if ((a | b | c | d) == 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int nextInt() {
        t = d;
        d = c;
        c = b;
        b = a;
        t ^= t << 11;
        t ^= t >>> 8;
        a = t ^ a ^ (a >>> 19);
        return a;
    }
}

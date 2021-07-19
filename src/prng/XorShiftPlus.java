package prng;

//has period of 2^128-1
public class XorShiftPlus {
    private long a, b;

    public XorShiftPlus(long a, long b) {
        if ((a | b) == 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    public long nextLong() {
        long t = a;
        a = b;
        t ^= t << 23;
        t ^= t >>> 17;
        t ^= a ^ (a >> 26);
        b = t;
        return t + a;
    }
}

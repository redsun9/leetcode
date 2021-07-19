package prng;

//has period of 2^64-1
public class XorShift64 {
    private long a;

    public XorShift64(long a) {
        if (a == 0) throw new IllegalArgumentException();
        this.a = a;
    }

    public long nextLong() {
        a ^= a << 13;
        a ^= a >>> 7;
        a ^= a << 17;
        return a;
    }
}

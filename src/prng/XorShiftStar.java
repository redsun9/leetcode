package prng;

// has a period of 2^64-1
public class XorShiftStar {
    private long a;

    public XorShiftStar(long a) {
        if (a == 0) throw new IllegalArgumentException();
        this.a = a;
    }

    public long nextInt() {
        a ^= a >>> 12;
        a ^= a << 25;
        a ^= a >>> 27;
        return a * 0x2545F4914F6CDD1DL;
    }
}

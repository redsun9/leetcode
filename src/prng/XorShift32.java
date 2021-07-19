package prng;

//has period of 2^32-1
public class XorShift32 {
    private int a;

    public XorShift32(int a) {
        if (a == 0) throw new IllegalArgumentException();
        this.a = a;
    }

    public int nextInteger() {
        a ^= a << 13;
        a ^= a >>> 17;
        a ^= a << 5;
        return a;
    }
}

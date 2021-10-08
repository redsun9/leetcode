package prng;

public class XorShift8 {
    private byte a;

    public XorShift8(byte a) {
        if (a == 0) throw new IllegalArgumentException();
        this.a = a;
    }

    public byte nextByte() {
        return a ^= (a >> 3) ^ (a << 4);
    }
}

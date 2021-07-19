package prng;

// has period of 2^1024-1
public class XorShift1024 {
    private long[] arr;
    private int index = 0;

    public XorShift1024(long[] arr) {
        long t = 0;
        if (arr.length < 16) throw new IllegalArgumentException();
        for (int i = 0; i < 16; i++) t |= arr[i];
        if (t == 0) throw new IllegalArgumentException();
        this.arr = arr;
    }

    public long nextLong() {
        long s = arr[index++];
        long t = arr[index &= 15];
        t ^= t << 31;
        t ^= t >>> 11;
        t ^= s ^ (s >>> 30);
        arr[index] = t;
        return t * 1181783497276652981L;
    }
}

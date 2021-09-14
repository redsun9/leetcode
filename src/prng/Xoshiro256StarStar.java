package prng;

// Has a period of 2^256-1
@SuppressWarnings("DuplicatedCode")
public class Xoshiro256StarStar {
    private long[] arr;

    public Xoshiro256StarStar(long[] arr) {
        if (arr.length < 4) throw new IllegalArgumentException();
        long t = 0;
        for (int i = 0; i < 4; i++) t |= arr[i];
        if (t == 0) throw new IllegalArgumentException();
        this.arr = arr;
    }

    public long nextLong() {
        long s1 = arr[1] * 5;
        long ans = ((s1 << 7) | (s1 >>> 57)) * 9;
        long t = s1 << 17;

        arr[2] ^= arr[0];
        arr[3] ^= arr[1];
        arr[1] ^= arr[2];
        arr[0] ^= arr[3];

        arr[2] ^= t;
        arr[3] = (arr[3] << 45) | (arr[3] >>> 19);

        return ans;
    }
}

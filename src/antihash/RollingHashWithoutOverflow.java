package antihash;

public class RollingHashWithoutOverflow implements StringHasher {
    private final int base, shift;
    private final long mod;

    public RollingHashWithoutOverflow(int base, int shift, long mod) {
        this.base = base;
        this.shift = shift;
        this.mod = mod;
    }

    public long hash(String s) {
        int n = s.length();
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = hash * base + s.charAt(i) - 'a' + shift;
            if (hash >= mod) hash %= mod;
        }
        return hash;
    }
}

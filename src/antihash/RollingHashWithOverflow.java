package antihash;

public final class RollingHashWithOverflow implements StringHasher {
    private final int base, shift;

    public RollingHashWithOverflow(int base, int shift) {
        this.base = base;
        this.shift = shift;
    }

    public long hash(String s) {
        int n = s.length();
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = hash * base + s.charAt(i) - 'a' + shift;
        }
        return hash;
    }
}

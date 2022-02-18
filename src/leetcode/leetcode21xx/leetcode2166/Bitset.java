package leetcode.leetcode21xx.leetcode2166;

public class Bitset {
    private final int size;
    private final long[] body;

    private int numberOfBitSet;
    private boolean reversed;


    public Bitset(int size) {
        this.size = size;
        this.body = new long[(size + 63) / 64];
    }

    public void fix(int idx) {
        setBit(idx, !reversed);
    }

    private void setBit(int idx, boolean val) {
        int cell = idx >>> 6, bit = idx & 63;
        boolean prevVal = (body[cell] >> bit & 1) == 1;
        if (prevVal != val) {
            body[cell] ^= 1L << bit;
            if (val) numberOfBitSet++;
            else numberOfBitSet--;
        }
    }

    public void unfix(int idx) {
        setBit(idx, reversed);
    }


    public void flip() {
        this.reversed = !this.reversed;
    }

    public boolean all() {
        return !reversed && numberOfBitSet == size || reversed && numberOfBitSet == 0;
    }

    public boolean one() {
        return !reversed && numberOfBitSet != 0 || reversed && numberOfBitSet != size;
    }

    public int count() {
        if (!reversed) return numberOfBitSet;
        else return size - numberOfBitSet;
    }

    public String toString() {
        char[] ans = new char[body.length * 64];
        for (int i = 0, j = 0; i < body.length; i++) {
            for (int bit = 0; bit < 64 && j < size; bit++, j++) {
                ans[j] = reversed ^ ((body[i] >> bit & 1) == 1) ? '1' : '0';
            }
        }
        return new String(ans, 0, size);
    }
}

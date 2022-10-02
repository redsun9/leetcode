package leetcode.leetcode24xx.leetcode2424;

import java.util.BitSet;

public class LUPrefix {
    private final BitSet bs;
    private final int n;
    private int prefix;

    public LUPrefix(int n) {
        this.bs = new BitSet(n);
        this.n = n;
        this.prefix = 0;
    }

    public void upload(int video) {
        video--;
        bs.set(video);
        if (video == prefix) while (prefix < n && bs.get(prefix)) prefix++;
    }

    public int longest() {
        return prefix;
    }
}

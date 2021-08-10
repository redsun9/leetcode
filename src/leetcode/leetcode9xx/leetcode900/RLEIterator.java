package leetcode.leetcode9xx.leetcode900;

public class RLEIterator {
    private final int[] encoding;
    private int pos = 0;
    private long curLeft, spent, total;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        int n = encoding.length;
        for (int i = 0; i < n; i += 2) total += encoding[i];
        curLeft = n == 0 ? 0 : encoding[0];
    }

    public int next(int n) {
        if (spent >= total) return -1;
        spent += n;
        if (spent > total) return -1;
        while (curLeft < spent) {
            pos += 2;
            curLeft += encoding[pos];
        }
        return encoding[pos + 1];
    }
}

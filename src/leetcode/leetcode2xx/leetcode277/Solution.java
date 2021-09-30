package leetcode.leetcode2xx.leetcode277;

public class Solution extends Relation {
    public Solution() {
    }

    public Solution(int ans, int n, long seed) {
        super(ans, n, seed);
    }

    public int findCelebrity(int n) {
        int potentialStar = 0;
        for (int i = 1; i < n; ) {
            boolean ab = knows(potentialStar, i);
            boolean ba = knows(i, potentialStar);
            if (ab == ba) {
                potentialStar = i + 1;
                i += 2;
            } else if (ab) {
                potentialStar = i;
                i += 1;
            } else i += 1;
        }
        if (potentialStar == n) return -1;
        for (int i = potentialStar - 1; i >= 0; i--) {
            if (knows(potentialStar, i) || !knows(i, potentialStar)) return -1;
        }
        return potentialStar;
    }
}
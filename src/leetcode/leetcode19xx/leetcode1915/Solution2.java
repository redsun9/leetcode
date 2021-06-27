package leetcode.leetcode19xx.leetcode1915;

public class Solution2 {
    public static final int MAX_CHAR = 10;

    public long wonderfulSubstrings(String word) {
        int n = word.length();
        int[] count = new int[1 << MAX_CHAR];
        count[0] = 1;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            count[mask]++;
        }
        long ans = 0;
        for (int i = 0; i < count.length; i++) {
            long a = count[i];
            if (a == 0) continue;
            ans += a * (a - 1L);
            for (int j = 0; j < 10; j++) {
                ans += a * count[i ^ (1 << j)];
            }
        }
        return ans / 2;
    }
}

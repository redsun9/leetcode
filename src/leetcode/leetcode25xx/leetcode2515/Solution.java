package leetcode.leetcode25xx.leetcode2515;

public class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) return 0;
        int n = words.length;
        if (n == 1) return -1;
        for (int i1 = (startIndex - 1 + n) % n, i2 = (startIndex + 1) % n, d = 1, k = 1; k < n; k += 2, d++) {
            if (words[i1].equals(target) || words[i2].equals(target)) return d;
            i1 = (i1 - 1 + n) % n;
            i2 = (i2 + 1) % n;
        }
        return -1;
    }
}

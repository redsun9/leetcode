package leetcode.leetcode3xx.leetcode387;

public class Solution {
    public int firstUniqChar(String s) {
        int[] pos = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 'a';
            if (pos[a] == 0) pos[a] = i + 1;
            else pos[a] = -1;
        }
        int ans = s.length() + 1;
        for (int po : pos) {
            if (po > 0 && po < ans) ans = po;
        }
        return (ans % (s.length() + 1) - 1);
    }
}

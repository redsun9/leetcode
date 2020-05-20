package leetcode.leetcode4xx.leetcode443;

public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) return n;
        int ans = 0;
        int i = 0;
        while (i < n) {
            int counter = 0;
            char prev = chars[i];
            while (i < n && chars[i] == prev) {
                counter++;
                i++;
            }
            chars[ans++] = prev;
            if (counter > 1) {
                if (counter >= 1000) {
                    chars[ans++] = (char) ('0' + counter / 1000);
                    counter %= 1000;
                    chars[ans++] = (char) ('0' + counter / 100);
                    counter %= 100;
                    chars[ans++] = (char) ('0' + counter / 10);
                    counter %= 10;
                    chars[ans++] = (char) ('0' + counter);
                } else if (counter >= 100) {
                    chars[ans++] = (char) ('0' + counter / 100);
                    counter %= 100;
                    chars[ans++] = (char) ('0' + counter / 10);
                    counter %= 10;
                    chars[ans++] = (char) ('0' + counter);
                } else if (counter >= 10) {
                    chars[ans++] = (char) ('0' + counter / 10);
                    counter %= 10;
                    chars[ans++] = (char) ('0' + counter);
                } else {
                    chars[ans++] = (char) ('0' + counter);
                }
            }
        }
        return ans;
    }
}

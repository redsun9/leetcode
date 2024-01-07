package leetcode.leetcode25xx.leetcode2586;

public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            char a = words[i].charAt(0);
            char b = words[i].charAt(words[i].length() - 1);
            if (
                    (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') &&
                            (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u')
            ) ans++;
        }
        return ans;
    }
}

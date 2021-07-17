package leetcode.leetcode3xx.leetcode318;

public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        if (n < 2) return 0;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            int mask = 0;
            for (int j = 0; j < m; j++) mask |= 1 << (word.charAt(j) - 'a');
            masks[i] = mask;
        }
        int ans = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if ((masks[i] & masks[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
        return ans;

    }
}

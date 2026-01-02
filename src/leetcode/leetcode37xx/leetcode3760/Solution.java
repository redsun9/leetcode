package leetcode.leetcode37xx.leetcode3760;

public class Solution {
    public int maxDistinct(String s) {
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) used[s.charAt(i) - 'a'] = true;
        int ans = 0;
        for (boolean b : used) if (b) ans++;
        return ans;
    }
}

package leetcode.leetcode21xx.leetcode2185;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) if (word.startsWith(pref)) ans++;
        return ans;
    }

}

package leetcode.leetcode19xx.leetcode1967;

public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String str : patterns) if (word.contains(str)) ans++;
        return ans;
    }
}

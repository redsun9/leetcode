package leetcode.leetcode30xx.leetcode3083;

public class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[][] arr = new boolean[26][26];
        for (int i = 1; i < s.length(); i++) arr[s.charAt(i - 1) - 'a'][s.charAt(i) - 'a'] = true;
        for (int i = 1; i < s.length(); i++) if (arr[s.charAt(i) - 'a'][s.charAt(i - 1) - 'a']) return true;
        return false;
    }
}

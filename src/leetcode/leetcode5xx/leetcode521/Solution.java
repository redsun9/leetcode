package leetcode.leetcode5xx.leetcode521;

public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) return Math.max(a.length(), b.length());
        if (a.equals(b)) return -1;
        else return a.length();
    }
}

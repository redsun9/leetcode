package leetcode.leetcode28xx.leetcode2839;

public class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char a1 = s1.charAt(0), a2 = s2.charAt(0), b1 = s1.charAt(1), b2 = s2.charAt(1), c1 = s1.charAt(2), c2 = s2.charAt(2), d1 = s1.charAt(3), d2 = s2.charAt(3);
        return (a1 == a2 && c1 == c2 || a1 == c2 && c1 == a2) && (b1 == b2 && d1 == d2 || b1 == d2 && d1 == b2);
    }
}

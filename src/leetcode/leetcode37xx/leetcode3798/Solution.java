package leetcode.leetcode37xx.leetcode3798;

public class Solution {
    public String largestEven(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '2') i--;
        return s.substring(0, i + 1);
    }
}

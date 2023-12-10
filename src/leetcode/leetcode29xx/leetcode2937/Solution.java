package leetcode.leetcode29xx.leetcode2937;

public class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int minLength = Math.min(n1, Math.min(n2, n3));
        while (i < minLength && s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == s3.charAt(i)) i++;
        return i != 0 ? n1 + n2 + n3 - 3 * i : -1;
    }
}

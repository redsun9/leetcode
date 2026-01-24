package leetcode.leetcode37xx.leetcode3794;

public class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = k - 1; i < k; i++, j--) arr[i] = s.charAt(j);
        return new String(arr);
    }
}

package leetcode.leetcode24xx.leetcode2425;

public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m1 = 0, n1 = 0, m2 = 0, n2 = 0;
        for (int i : nums1) m1 ^= i;
        for (int i : nums1) m2 ^= ~i;
        for (int i : nums2) n1 ^= i;
        for (int i : nums2) n2 ^= ~i;
        return (m1 & n2) ^ (m2 & n1);
    }
}

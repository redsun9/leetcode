package leetcode.leetcode25xx.leetcode2570;

public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int ansLength = 0;
        int i1 = 0, i2 = 0, n1 = nums1.length, n2 = nums2.length;
        while (i1 < n1 && i2 < n2) {
            int min = Math.min(nums1[i1][0], nums2[i2][0]);
            if (nums1[i1][0] == min) i1++;
            if (nums2[i2][0] == min) i2++;
            ansLength++;
        }
        ansLength += (n1 - i1) + (n2 - i2);

        int[][] ans = new int[ansLength][2];
        i1 = 0;
        i2 = 0;
        ansLength = 0;
        while (i1 < n1 || i2 < n2) {
            int id = Math.min(
                    i1 < n1 ? nums1[i1][0] : Integer.MAX_VALUE,
                    i2 < n2 ? nums2[i2][0] : Integer.MAX_VALUE
            );
            int sum = 0;
            if (i1 < n1 && nums1[i1][0] == id) sum += nums1[i1++][1];
            if (i2 < n2 && nums2[i2][0] == id) sum += nums2[i2++][1];
            ans[ansLength][0] = id;
            ans[ansLength++][1] = sum;
        }
        return ans;
    }
}

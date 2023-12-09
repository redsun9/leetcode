package leetcode.leetcode25xx.leetcode2569;

public class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        Node root = new Node(nums1, 0, nums1.length);
        int n = queries.length;

        int ansLength = 0;
        for (int[] query : queries) if (query[0] == 3) ansLength++;

        long totalSum = 0;
        for (int num : nums2) totalSum += num;

        long[] ans = new long[ansLength];
        int pos = 0;
        for (int[] query : queries) {
            if (query[0] == 1) root.flip(query[1], query[2] + 1);
            else if (query[0] == 2) totalSum += query[1] * root.sum(0, nums1.length);
            else ans[pos++] = totalSum;
        }
        return ans;
    }


    private static class Node {
        int l, r, totalSum;
        final Node left, right;
        boolean shouldBeSwapped;

        Node(int[] nums, int l, int r) {
            this.l = l;
            this.r = r;
            if (r - l > 1) {
                int m = (l + r) >>> 1;
                if (m - l >= 0) {
                    this.left = new Node(nums, l, m);
                } else this.left = null;

                if (r - m >= 0) {
                    this.right = new Node(nums, m, r);
                } else this.right = null;

                this.totalSum = (left != null ? left.totalSum : 0) + (right != null ? right.totalSum : 0);
            } else {
                this.left = null;
                this.right = null;
                this.totalSum = nums[l];
            }
        }

        void flip(int ql, int qr) {
            if (qr <= l || ql >= r) return;
            else if (ql <= l && qr >= r) {
                shouldBeSwapped = !shouldBeSwapped;
                totalSum = (r - l) - totalSum;
            } else {
                if (shouldBeSwapped) {
                    if (this.left != null) this.left.flip(l, r);
                    if (this.right != null) this.right.flip(l, r);
                    shouldBeSwapped = false;
                }
                if (this.left != null) this.left.flip(ql, qr);
                if (this.right != null) this.right.flip(ql, qr);
                this.totalSum = (left != null ? left.totalSum : 0) + (right != null ? right.totalSum : 0);
            }
        }

        long sum(int ql, int qr) {
            if (qr <= l || ql >= r) return 0L;
            else if (ql <= l && qr >= r) return totalSum;
            else {
                if (shouldBeSwapped) {
                    if (this.left != null) this.left.flip(l, r);
                    if (this.right != null) this.right.flip(l, r);
                    shouldBeSwapped = false;
                }
                return (left != null ? left.sum(ql, qr) : 0) + (right != null ? right.sum(ql, qr) : 0);
            }
        }
    }
}

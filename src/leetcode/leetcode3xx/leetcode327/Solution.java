package leetcode.leetcode3xx.leetcode327;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        long sum = 0;
        Tree tree = new Tree(0);
        for (int num : nums) {
            sum += num;
            ans += tree.countRangeSum(sum - upper, sum - lower);
            tree.insert(sum);
        }
        return ans;
    }

    public static class Tree {
        long l, r, val, count;
        int total;
        Tree left, right;

        void insert(long newVal) {
            total++;
            if (val == newVal) {
                count++;
            } else if (newVal < val) {
                l = Math.min(l, newVal);
                if (left == null) this.left = new Tree(newVal);
                else left.insert(newVal);
            } else {
                r = Math.max(r, newVal);
                if (right == null) this.right = new Tree(newVal);
                else right.insert(newVal);
            }
        }

        public int countRangeSum(long ql, long qr) {
            if (ql > r || qr < l) return 0;
            if (ql <= l && qr >= r) return total;
            int ans = 0;
            if (ql <= val && qr >= val) ans += count;
            if (ql < val && left != null) ans += left.countRangeSum(ql, qr);
            if (qr > val && right != null) ans += right.countRangeSum(ql, qr);
            return ans;
        }

        public Tree(long val) {
            this.l = val;
            this.r = val;
            this.val = val;
            this.count = 1;
            this.total = 1;
        }

        @Override
        public String toString() {
            if (left != null && right != null)
                return left.toString() + ",[" + val + ":" + count + "]," + right.toString();
            if (left != null) return left.toString() + ",[" + val + ":" + count + "]";
            if (right != null) return "[" + val + ":" + count + "]," + right.toString();
            else return "[" + val + ":" + count + "]";
        }
    }

}

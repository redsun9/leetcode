package leetcode.leetcode414;

public class Solution {
    public int thirdMax(int[] nums) {
        Integer a = null, b = null, c = null;
        int tmp;
        for (int num : nums) {
            if (a != null && a != num) {
                if (a < num) {
                    c = b;
                    b = a;
                    a = num;
                } else if (b != null && b != num) if (b < num) {
                    c = b;
                    b = num;
                } else if (c != null && c != num) {
                    if (c < num) c = num;
                } else c = num;
                else b = num;
            } else a = num;
        }
        return c == null ? a : c;
    }
}

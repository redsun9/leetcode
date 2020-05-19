package leetcode.leetcode6xx.leetcode659;

public class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        if (n < 3) return false;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int pAll = 0;
        int pShort = 0;

        int pre = 0;
        int i = 0;

        while (i < n) {
            int cur = nums[i];
            int cnt = 0;
            while (i < n && nums[i] == cur) {
                i++;
                cnt++;
            }
            if (cur != pre + 1) {
                if (pShort != 0) return false; //оборвались короткие
                p1 = cnt;
                p2 = 0;
                p3 = 0;
                pAll = cnt;
                pShort = cnt;
            } else {
                if (cnt < pShort) return false; //недостаточно, чтобы продлить короткие
                int c1 = Math.max(0, cnt - pAll); //сколько осталось
                int c2 = p1;
                p3 = p2 + Math.min(p3, cnt - pShort);
                p1 = c1;
                p2 = c2;
                pShort = p1 + p2;
                pAll = cnt;
            }
            pre = cur;
        }
        return pShort == 0;
    }
}

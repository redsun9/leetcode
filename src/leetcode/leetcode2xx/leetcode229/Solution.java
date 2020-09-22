package leetcode.leetcode2xx.leetcode229;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a1 = 0, a2 = 0, c1 = 0, c2 = 0;

        //find candidates
        for (int num : nums) {
            if (a1 == num) c1++;
            else if (a2 == num) c2++;
            else if (c1 == 0) {
                a1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                a2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        //check candidates
        int threshold = n / 3 + 1;
        List<Integer> ans = new LinkedList<>();
        c1 = 0;
        for (int num : nums) if (a1 == num) c1++;
        if (c1 >= threshold) ans.add(a1);

        if (a1 != a2) {
            c2 = 0;
            for (int num : nums) if (a2 == num) c2++;
            if (c2 >= threshold) ans.add(a2);
        }
        return ans;
    }
}

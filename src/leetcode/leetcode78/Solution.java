package leetcode.leetcode78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int mask = (1 << nums.length) - 1;
        for (int submask = mask; ; submask = (submask - 1) & mask) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((submask & (1 << i)) != 0) list.add(nums[i]);
            }
            ans.add(list);
            if (submask == 0) break;
        }
        return ans;
    }
}

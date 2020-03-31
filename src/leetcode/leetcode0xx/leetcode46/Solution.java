package leetcode.leetcode0xx.leetcode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Given a collection of distinct integers, return all possible permutations.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        permute(nums, new boolean[nums.length], 0, nums.length, new int[nums.length], res);
        return res;
    }


    private static void permute(int[] nums, boolean[] used, int i, int n, int[] tmp, List<List<Integer>> ans) {
        if (i == n) {
            List<Integer> intList = new ArrayList<>(n);
            for (int j : tmp) {
                intList.add(nums[j]);
            }
            ans.add(intList);
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!used[j]) {
                    used[j] = true;
                    tmp[i] = j;
                    permute(nums, used, i + 1, n, tmp, ans);
                    used[j] = false;
                }
            }
        }
    }
}

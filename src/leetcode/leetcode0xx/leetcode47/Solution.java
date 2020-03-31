package leetcode.leetcode0xx.leetcode47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] b;
        {
            LinkedList<int[]> borders = new LinkedList<>();
            int start = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    borders.add(new int[]{start, i});
                    start = i;
                }
            }
            borders.add(new int[]{start, n});
            b = borders.toArray(new int[borders.size()][]);
        }
        List<List<Integer>> res = new LinkedList<>();
        permuteUnique(nums, res, new boolean[n], b, 0, 0, n, new int[n]);
        return res;
    }

    private static void permuteUnique(
            int[] nums, List<List<Integer>> ans, boolean[] used,
            int[][] b, int groupIndex, int i, int n, int[] tmp
    ) {
        if (i == b[groupIndex][1]) groupIndex++;
        if (groupIndex == b.length) {
            Integer[] integers = new Integer[n];
            for (int j = 0; j < tmp.length; j++) {
                integers[tmp[j]] = nums[j];
            }
            ans.add(Arrays.asList(integers));
        } else {
            int j = b[groupIndex][0] == i ? 0 : tmp[i - 1] + 1;
            while (j < n) {
                if (!used[j]) {
                    used[j] = true;
                    tmp[i] = j;
                    permuteUnique(nums, ans, used, b, groupIndex, i + 1, n, tmp);
                    used[j] = false;
                }
                j++;
            }
        }
    }
}

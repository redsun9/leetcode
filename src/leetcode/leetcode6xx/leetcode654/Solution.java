package leetcode.leetcode6xx.leetcode654;

import leetcode.tools.TreeNode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(x -> nums[x]));
        return construct(nums, indices, 0, n, n - 1);
    }

    private static TreeNode construct(int[] nums, Integer[] indices, int left, int right, int pos) {
        //left,right - начало и конец подмассива nums
        //pos - откуда начинать в массиве индексов
        while (pos >= 0 && (indices[pos] < left || indices[pos] >= right)) pos--;
        if (pos < 0) return null;
        TreeNode node = new TreeNode(nums[indices[pos]]);
        node.left = construct(nums, indices, left, indices[pos], pos - 1);
        node.right = construct(nums, indices, indices[pos] + 1, right, pos - 1);
        return node;
    }
}

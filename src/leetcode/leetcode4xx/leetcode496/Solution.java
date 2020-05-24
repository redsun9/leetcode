package leetcode.leetcode4xx.leetcode496;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= val) stack.pop();
            if (map.containsKey(val)) {
                if (!stack.isEmpty()) nums1[map.get(val)] = stack.peek();
                else nums1[map.get(val)] = -1;
            }
            stack.push(val);
        }
        return nums1;
    }
}

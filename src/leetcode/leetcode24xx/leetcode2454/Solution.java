package leetcode.leetcode24xx.leetcode2454;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), tmp = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s2.empty() && nums[s2.peek()] < nums[i]) ans[s2.pop()] = nums[i];
            while (!s1.empty() && nums[s1.peek()] < nums[i]) tmp.push(s1.pop());
            while (!tmp.empty()) s2.push(tmp.pop());
            s1.push(i);
        }
        return ans;
    }
}

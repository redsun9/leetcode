package leetcode.leetcode4xx.leetcode442;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) answer.add(index + 1);
            nums[index] = -nums[index];
        }
        return answer;
    }
}
